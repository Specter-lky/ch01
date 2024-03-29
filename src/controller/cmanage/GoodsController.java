package controller.cmanage;

import com.dao.GoodsDao;
import com.pojo.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsDao goodsDao;
    @RequestMapping("lookGoods")
    public String lookGoods(HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession(true);
        List<Goods> list=goodsDao.selectAllGoods();
        session.setAttribute("allGoods",list);
        return "cmanage/lookGoods";
    }
    @RequestMapping("lookoneGoods")
    public String lookoneGoods(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpSession session=request.getSession(true);
        String name=request.getParameter("name");
        Goods one=goodsDao.selectOneGoods(name);
        session.setAttribute("one",one);
        return "cmanage/lookoneGoods";
    }
    @RequestMapping("add")
    public String add(){
        return "cmanage/addGoods";
    }
    @RequestMapping("addGoods")
    public String addGoods(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String name=request.getParameter("name");
        int num=Integer.parseInt(request.getParameter("num"));
        double price=Double.parseDouble(request.getParameter("price"));
        double bprice=Double.parseDouble(request.getParameter("bprice"));
        int threshold=Integer.parseInt(request.getParameter("threshold"));
        Goods add=new Goods(name,num,price,bprice,threshold);
        goodsDao.addGoods(add);
        HttpSession session=request.getSession(true);
        List<Goods> list=goodsDao.selectAllGoods();
        session.setAttribute("allGoods",list);
        return "cmanage/lookGoods";
    }
}
