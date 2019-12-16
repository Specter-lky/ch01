package controller.smanage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.*;
import com.pojo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Resource
    private ContractDao contractDao;
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private SalesDao salesDao;
    @Resource
    private ClientDao clientDao;
    @Resource
    private OrdersDao ordersDao;
    @RequestMapping("lookContract")
    public String lookContract(HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession(true);
        List<Contract> list=contractDao.selectAllContract();
        session.setAttribute("allContract",list);
        return "smanage/lookContract";
    }
    @RequestMapping("lookoneContract")
    public String lookoneContract(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int ctno=Integer.parseInt(request.getParameter("ctno"));
        Contract one=contractDao.selectOneContract(ctno);
        HttpSession session=request.getSession(true);
        session.setAttribute("one",one);
        return "smanage/lookoneContract";
    }
    @RequestMapping("add")
    public String add(HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession(true);
        List<Salesman> allSalesman=salesDao.selectAllSalesman();
        List<Goods> allGoods=goodsDao.selectAllGoods();
        List<Client> allClient=clientDao.selectAllClient();
        session.setAttribute("allSalesman",allSalesman);
        session.setAttribute("allGoods",allGoods);
        session.setAttribute("allClient",allClient);
        return "smanage/addContract";
    }
    @RequestMapping("addContract")
    @ResponseBody
    public String addContract(@RequestBody String a) throws ParseException {
        System.out.println(a);
        JSONObject jsonObject=JSON.parseObject(a);
        int ctno=Integer.parseInt(jsonObject.getString("ctno"));
        String sname=jsonObject.getString("sname");
        String cname=jsonObject.getString("cname");
        String d=jsonObject.getString("date");
        String code="";
        if (contractDao.selectOneContract(ctno)!=null){
            code="error";
        }
        else{
            code="success";
            SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
            Date date=formatter.parse(d);
            Contract add=new Contract(ctno,sname,cname,date,0);
            contractDao.addContract(add);
            String orders = jsonObject.getString("orders");
            JSONArray jsonArray=JSONArray.parseArray(orders);
            List<Orders> list=JSONObject.parseArray(orders,Orders.class);
            for(Orders o :list){
                String gname=o.getG_name();
                Goods goods=goodsDao.selectOneGoods(gname);
                o.setCt_no(ctno);
                o.setG_price(goods.getG_price());
                o.setO_status(0);
            ordersDao.addOrders(o);
            }
        }
        return code;
    }
    @RequestMapping("update")
    public String update(HttpServletRequest request, HttpServletResponse response){
        int ctno=Integer.parseInt(request.getParameter("ctno"));
        Contract contract=contractDao.selectOneContract(ctno);
        List<Orders> orders=ordersDao.selectContractOrders(ctno);
        HttpSession session=request.getSession(true);
        session.setAttribute("contract",contract);
        session.setAttribute("orders",orders);
        return "smanage/updateContract";
    }
    @RequestMapping("updateContract")
    public String updateContract(){
        return "";
    }
}
