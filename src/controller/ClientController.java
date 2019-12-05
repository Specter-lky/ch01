package controller;

import com.dao.ClientDao;
import com.pojo.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        return "smanage/lookClient";
    }
}