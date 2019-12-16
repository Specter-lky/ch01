package controller.smanage;

import com.dao.ClientDao;
import com.pojo.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Resource
    private ClientDao clientDao;
    @RequestMapping("lookClient")
    public String lookClient(HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession(true);
        List<Client> list=clientDao.selectAllClient();
        session.setAttribute("allClient",list);
        return "smanage/lookClient";
    }
    @RequestMapping("lookoneClient")
    public String lookoneClient(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpSession session=request.getSession(true);
        String name=request.getParameter("name");
        Client one=clientDao.selectOneClient(name);
        session.setAttribute("one",one);
        return "smanage/lookoneClient";
    }
    @RequestMapping("add")
    public String add(){
        return "smanage/addClient";
    }
    @RequestMapping("addClient")
    public String addClient(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String name=request.getParameter("name");
        String phone=request.getParameter("phone");
        String adress=request.getParameter("adress");
        Client add=new Client(name,phone,adress);
        clientDao.addClient(add);
        HttpSession session=request.getSession(true);
        List<Client> list=clientDao.selectAllClient();
        session.setAttribute("allClient",list);
        return "smanage/lookClient";
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpSession session=request.getSession(true);
        String name=request.getParameter("name");
        Client client=clientDao.selectOneClient(name);
        session.setAttribute("client",client);
        return "smanage/updateClient";
    }
    @RequestMapping("updateClient")
    public String updateClient(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String name=request.getParameter("name");
        String phone=request.getParameter("phone");
        String adress=request.getParameter("adress");
        Client update=new Client(name,phone,adress);
        clientDao.updateClient(update);
        HttpSession session=request.getSession(true);
        List<Client> list=clientDao.selectAllClient();
        session.setAttribute("allClient",list);
        return "smanage/lookClient";
    }
}