package controller.salesman;

import com.dao.SalesDao;
import com.pojo.Salesman;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        return "smange/lookSalesman";
    }
    @RequestMapping("add")
    public String add(HttpServletRequest request, HttpServletResponse response){
        return "smange/addSalesman";
    }
}
