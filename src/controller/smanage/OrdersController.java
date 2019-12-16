package controller.smanage;

import com.dao.DListDao;
import com.dao.OrdersDao;
import com.pojo.DList;
import com.pojo.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    private OrdersDao ordersDao;
    @Resource
    private DListDao dListDao;
    @RequestMapping("lookOrders")
    public String lookFinishedOrders(HttpServletRequest request, HttpServletResponse response){
        List<Orders> list=ordersDao.selectAllOrders();
        HttpSession session=request.getSession(true);
        session.setAttribute("allOrders",list);
        return "smanage/lookOrders";
    }
    @RequestMapping("lookoneOrders")
    public String lookoneOrders(HttpServletRequest request, HttpServletResponse response){
        int ono=Integer.parseInt(request.getParameter("ono"));
        Orders one=ordersDao.selectOneOrders(ono);
        HttpSession session=request.getSession(true);
        session.setAttribute("one",one);
        return "smanage/lookoneOrders";
    }
}
