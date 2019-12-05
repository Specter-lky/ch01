package controller;

import com.dao.SalesDao;
import com.dao.UserDao;
import com.pojo.Salesman;
import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/hi")
public class LoginController {
    @Resource
    private UserDao userDao;
    @Resource
    private SalesDao salesDao;
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession httpSession = request.getSession(true);
        response.setContentType("text/html");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        //获取登录页面中表单提交的信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String identity = request.getParameter("identity");
        if (username == null) {
            httpSession.setAttribute("error", "还没登录，请先登录");
            return "redirect:/index.jsp";
        }
        if (identity.equals("")){
            httpSession.setAttribute("error","请选择登录身份");
            return "redirect:/index.jsp";
        }
        if (!identity.equals("销售人员")) {
            User loginuser = new User(username, password, identity);
            //如果登录发生错误，利用session传递登录错误的信息，跳转到登录页面index.jsp
            if (userDao.login(loginuser) == null) {
                httpSession.setAttribute("error", "用户名或密码错误");
                return "redirect:/index.jsp";
            } else {
                if (identity.equals("销售管理员")) {
                    return "smanage/main";
                }
                else{
                    return "cmanage_main";
                }
            }
        } else {
            int no=Integer.parseInt(username);
            Salesman salesman=new Salesman(no,"","","",password);
            if (salesDao.login(salesman)==null){
                httpSession.setAttribute("error", "用户名或密码错误");
                return "redirect:/index.jsp";
            }
            else{
                return "spersonal_main";
            }
        }
    }

}