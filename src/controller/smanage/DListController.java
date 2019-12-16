package controller.smanage;

import com.dao.ContractDao;
import com.dao.DListDao;
import com.dao.GoodsDao;
import com.dao.OrdersDao;
import com.pojo.Contract;
import com.pojo.DList;
import com.pojo.Goods;
import com.pojo.Orders;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dlist")
public class DListController {
    @Resource
    private DListDao dListDao;
    @Resource
    private OrdersDao ordersDao;
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private ContractDao contractDao;
    @RequestMapping("lookDList")
    public String lookDList(HttpServletRequest request, HttpServletResponse response){
        List<DList> list=dListDao.selectAllDList();
        HttpSession session=request.getSession(true);
        session.setAttribute("allDList",list);
        return "smanage/lookDList";
    }
    @RequestMapping("clookDList")
    public String clookDList(HttpServletRequest request, HttpServletResponse response){
        List<DList> list=dListDao.selectAllDList();
        HttpSession session=request.getSession(true);
        session.setAttribute("allDList",list);
        return "cmanage/lookDList";
    }
    @RequestMapping("add")
    public String add(HttpServletRequest request, HttpServletResponse response){
        int ono=Integer.parseInt(request.getParameter("ono"));
        HttpSession session=request.getSession(true);
        Orders one=ordersDao.selectOneOrders(ono);
        List<DList> dLists=dListDao.selectOrders(ono);
        Goods goods=goodsDao.selectOneGoods(one.getG_name());
        session.setAttribute("one",one);
        session.setAttribute("dLists",dLists);
        session.setAttribute("goods",goods);
        return "smanage/addDList";
    }
    @RequestMapping("addDList")
    public String addDList(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int ono=Integer.parseInt(request.getParameter("ono"));
        String gname=request.getParameter("gname");
        double gprice=Double.parseDouble(request.getParameter("gprice"));
        int dlnum=Integer.parseInt(request.getParameter("dlnum"));
        String dlplace=request.getParameter("dlplace");
        //添加订单，状态是未发货
        DList add=new DList(1,ono,gname,gprice,dlnum,0,dlplace);
        dListDao.addDList(add);
        List<DList> list=dListDao.selectAllDList();
        Orders one=ordersDao.selectOneOrders(ono);
        one.setO_status(1);
        ordersDao.updateOrders(one);
        Contract contract=contractDao.selectOneContract(one.getCt_no());
        contract.setCt_status(1);
        contractDao.updateContract(contract);
        HttpSession session=request.getSession(true);
        session.setAttribute("allDList",list);
        return "smanage/lookDList";
    }
    @RequestMapping("delivergoods")
    public String delivergoods(HttpServletRequest request, HttpServletResponse response){
        int count=0,flag=0,check=0;
        HttpSession session=request.getSession(true);
        int dlno=Integer.parseInt(request.getParameter("dlno"));
        //判断库存是否足够发货
        DList one=dListDao.selectoneDList(dlno);
        Goods goods=goodsDao.selectOneGoods(one.getG_name());
        if (goods.getG_num()<one.getDl_num()){
            System.out.println("当前库存不足");
            session.setAttribute("error","当前库存不足，请进货");
        }
        else {
            //发货，发货单的状态改为已发货，并将发货单所处的订单的状态改为执行中
            one.setDl_status(1);
            int num=goods.getG_num()-one.getDl_num();
            goods.setG_num(num);
            dListDao.updateDList(one);
            goodsDao.updateGoods(goods);
            //判断订单是否已执行完毕，若是，则将状态改为已完成
            int ono=one.getO_no();
            Orders orders=ordersDao.selectOneOrders(ono);
            List<DList> dList=dListDao.selectOrders(ono);
            for (DList d : dList){
                if(d.getDl_status()!=0)count+=d.getDl_num();
            }
            if(count==orders.getO_num()){
                orders.setO_status(2);
                ordersDao.updateOrders(orders);
            }
            //判断合同的所有订单是否都执行完毕，如是，则将合同的状态改变
            List<Orders> ol=ordersDao.selectContractOrders(orders.getCt_no());
            for(Orders o:ol){
                if (o.getO_status()!=2)flag=1;
            }
            if(flag!=1){
                Contract contract=contractDao.selectOneContract(orders.getCt_no());
                contract.setCt_status(2);
                contractDao.updateContract(contract);
            }
        }
        List<DList> list=dListDao.selectAllDList();
        session.setAttribute("allDList",list);
        return "cmanage/lookDList";
    }
}
