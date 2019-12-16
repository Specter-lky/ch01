package controller.smanage;

import com.dao.*;
import com.pojo.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sales")
public class SalesController {
    @Resource
    private SalesDao salesDao;
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private ClientDao clientDao;
    @Resource
    private ContractDao contractDao;
    @Resource
    private OrdersDao ordersDao;
    @RequestMapping("employee")
    public String employee(HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession(true);
        List<Salesman> list=salesDao.selectAllSalesman();
        session.setAttribute("allsales",list);
        return "smanage/lookSalesman";
    }
    @RequestMapping("one")
    public String one(HttpServletRequest request, HttpServletResponse response){
        int no=Integer.parseInt(request.getParameter("no"));
        HttpSession session=request.getSession(true);
        Salesman one=salesDao.selectOneSalesman(no);
        session.setAttribute("one",one);
        return "smanage/lookoneSalesman";
    }
    @RequestMapping("add")
    public String add(){
        return "smanage/addSalesman";
    }
    @RequestMapping("addSales")
    public String addSales(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String name=request.getParameter("name");
        String phone=request.getParameter("phone");
        String adress=request.getParameter("adress");
        String password=request.getParameter("password");
        Salesman addsale=new Salesman(1,name,phone,adress,password);
        salesDao.addSalesman(addsale);
        HttpSession session=request.getSession(true);
        List<Salesman> list=salesDao.selectAllSalesman();
        session.setAttribute("allsales",list);
        return "smanage/lookSalesman";
    }
    @RequestMapping("update")
    public String update(HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession(true);
        int no=Integer.parseInt(request.getParameter("no"));
        Salesman salesman=salesDao.selectOneSalesman(no);
        session.setAttribute("salesman",salesman);
        return "smanage/updateSalesman";
    }
    @RequestMapping("updateSalesman")
    public String updateSalesman(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int no=Integer.parseInt(request.getParameter("no"));

        String name=request.getParameter("name");
        String phone=request.getParameter("phone");
        String adress=request.getParameter("adress");
        String password=request.getParameter("password");
        Salesman update=new Salesman(no,name,phone,adress,password);
        salesDao.updateSalesman(update);
        HttpSession session=request.getSession(true);
        List<Salesman> list=salesDao.selectAllSalesman();
        session.setAttribute("allsales",list);
        return "smanage/lookSalesman";
    }
    @RequestMapping("lookGSales")
    public String lookGSales(HttpServletRequest request, HttpServletResponse response){
        List<Orders> orders=ordersDao.selectAllOrders();
        List<Goods> goods=goodsDao.selectAllGoods();
        HttpSession session=request.getSession(true);
        session.setAttribute("orders",orders);
        session.setAttribute("goods",goods);
        return "smanage/lookGSales";
    }
    @RequestMapping("searchGSales")
    public String searchGSales(HttpServletRequest request, HttpServletResponse response, Model model) throws ParseException {
        response.setContentType("text/html");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String start=request.getParameter("start");
        String end=request.getParameter("end");
        String gname=request.getParameter("gname");
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date sDate=formatter.parse(start);
        Date eDate=formatter.parse(end);
        List<Contract> contracts=contractDao.selectAllContract();
        List<Orders> all=new ArrayList<Orders>();
        for(Contract c : contracts){
            if(c.getCt_date().getTime()>=sDate.getTime()&&c.getCt_date().getTime()<=eDate.getTime()){
                List<Orders> orders=ordersDao.selectContractOrders(c.getCt_no());
                for(Orders o : orders){
                    if (o.getG_name().equals(gname))all.add(o);
                }
            }
        }
        HttpSession session=request.getSession(true);
        session.setAttribute("all",all);
        model.addAttribute("gname",gname);
        return "smanage/searchGSales";
    }
    @RequestMapping("lookCSales")
    public String lookCSales(HttpServletRequest request, HttpServletResponse response,Model model){
        List<Contract> contracts=contractDao.selectAllContract();
        List<Orders> orders=ordersDao.selectAllOrders();
        List<Client> clients=clientDao.selectAllClient();
        double total=0;
        for (Orders o:orders){
            total+=o.getO_num()*o.getG_price();
        }
        HttpSession session=request.getSession(true);
        session.setAttribute("contracts",contracts);
        session.setAttribute("client",clients);
        model.addAttribute("total",total);
        return "smanage/lookCSales";
    }
    @RequestMapping("searchCSales")
    public String searchCSales(HttpServletRequest request, HttpServletResponse response,Model model) throws ParseException {
        response.setContentType("text/html");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        double total=0;
        String start=request.getParameter("start");
        String end=request.getParameter("end");
        String cname=request.getParameter("cname");
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date sDate=formatter.parse(start);
        Date eDate=formatter.parse(end);
        List<Contract> contracts=contractDao.selectAllContract();
        List<Contract> contract=new ArrayList<Contract>();
        for(Contract c : contracts){
            if(c.getCt_date().getTime()>=sDate.getTime()&&c.getCt_date().getTime()<=eDate.getTime()&&c.getC_name().equals(cname)){
                List<Orders> orders=ordersDao.selectContractOrders(c.getCt_no());
                for(Orders o : orders){
                    total+=o.getO_num()*o.getG_price();
                }
                contract.add(c);
            }
        }
        HttpSession session=request.getSession(true);
        session.setAttribute("contract",contract);
        model.addAttribute("total",total);
        model.addAttribute("cname",cname);
        return "smanage/searchCSales";
    }
    @RequestMapping("lookownContract")
    public String lookownContract(HttpServletRequest request, HttpServletResponse response){
        int sno=Integer.parseInt(request.getParameter("sno"));
        Salesman salesman=salesDao.selectOneSalesman(sno);
        List<Contract> contract=contractDao.selectSalesContract(salesman.getS_name());
        HttpSession session=request.getSession(true);
        session.setAttribute("contract",contract);
        session.setAttribute("sno",sno);
        return "spersonal/lookownContract";
    }
    @RequestMapping("lookSperformance")
    public String lookSperformance(HttpServletRequest request, HttpServletResponse response,Model model){
        int sno=Integer.parseInt(request.getParameter("sno"));
        double total=0;
        Salesman salesman=salesDao.selectOneSalesman(sno);
        List<Contract> contract=contractDao.selectSalesContract(salesman.getS_name());
        for(Contract c : contract){
            List<Orders> orders=ordersDao.selectContractOrders(c.getCt_no());
            for(Orders o:orders)total+=o.getO_num()*o.getG_price();
        }
        HttpSession session=request.getSession(true);
        session.setAttribute("contract",contract);
        session.setAttribute("sno",sno);
        model.addAttribute("total",total);
        return "spersonal/lookSperformance";
    }
    @RequestMapping("searchSperformance")
    public String searchSperformance(HttpServletRequest request, HttpServletResponse response,Model model) throws ParseException {
        int sno=Integer.parseInt(request.getParameter("sno"));
        String start=request.getParameter("start");
        String end=request.getParameter("end");
        double total=0;
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date sDate=formatter.parse(start);
        Date eDate=formatter.parse(end);
        Salesman salesman=salesDao.selectOneSalesman(sno);
        List<Contract> contract=contractDao.selectSalesContract(salesman.getS_name());
        List<Contract> contracts=new ArrayList<Contract>();
        for(Contract c : contract){
            if(c.getCt_date().getTime()>=sDate.getTime()&&c.getCt_date().getTime()<=eDate.getTime()) {
                List<Orders> orders = ordersDao.selectContractOrders(c.getCt_no());
                for (Orders o : orders) total += o.getO_num() * o.getG_price();
                contracts.add(c);
            }
        }
        HttpSession session=request.getSession(true);
        session.setAttribute("contract",contracts);
        session.setAttribute("sno",sno);
        model.addAttribute("total",total);
        return "spersonal/searchSperformance";
    }
}
