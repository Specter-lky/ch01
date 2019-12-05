package controller.salesman;

import com.dao.SalesDao;
import com.pojo.Salesman;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/sales")
public class SalesController {
    @Resource
    private SalesDao salesDao;
    @RequestMapping("/employee")
    public String employee(HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession(true);
        List<Salesman> list=salesDao.selectAllSalesman();
        session.setAttribute("allsales",list);
        return "smanage/lookSalesman";
    }
    @RequestMapping("add")
    public String add(HttpServletRequest request, HttpServletResponse response){
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
}
