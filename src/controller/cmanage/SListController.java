package controller.cmanage;

import com.dao.GoodsDao;
import com.dao.SListDao;
import com.pojo.Goods;
import com.pojo.SList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/slist")
public class SListController {
    @Resource
    private SListDao sListDao;
    @Resource
    private GoodsDao goodsDao;
    @RequestMapping("looksList")
    public String lookDList(HttpServletRequest request, HttpServletResponse response){
        List<SList> list=sListDao.selectAllSList();
        HttpSession session=request.getSession(true);
        session.setAttribute("allSList",list);
        return "cmanage/lookSList";
    }
    @RequestMapping("slooksList")
    public String slookDList(HttpServletRequest request, HttpServletResponse response){
        List<SList> list=sListDao.selectAllSList();
        HttpSession session=request.getSession(true);
        session.setAttribute("allSList",list);
        return "smanage/lookSList";
    }
    @RequestMapping("add")
    public String add(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session=request.getSession(true);
        List<Goods> goods=goodsDao.selectAllGoods();
        session.setAttribute("allGoods",goods);
        return "smanage/addSList";
    }
    @RequestMapping("addSList")
    public String addSList(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String gname=request.getParameter("gname");
        int slnum=Integer.parseInt(request.getParameter("slnum"));
        Goods goods=goodsDao.selectOneGoods(gname);
        SList add=new SList(1,gname,slnum,goods.getG_bprice(),0);
        sListDao.addSList(add);
        List<SList> list=sListDao.selectAllSList();
        HttpSession session=request.getSession(true);
        session.setAttribute("allSList",list);
        return "smanage/lookSList";
    }
    @RequestMapping("stockgoods")
    public String stockgoods(HttpServletRequest request, HttpServletResponse response){
        int slno=Integer.parseInt(request.getParameter("slno"));
        SList sList=sListDao.selectOneSList(slno);
        sList.setSl_status(1);
        sListDao.updateSList(sList);
        int slnum=sList.getSl_num();
        Goods goods=goodsDao.selectOneGoods(sList.getG_name());
        int total=slnum+goods.getG_num();
        goods.setG_num(total);
        goodsDao.updateGoods(goods);
        List<SList> list=sListDao.selectAllSList();
        HttpSession session=request.getSession(true);
        session.setAttribute("allSList",list);
        return "cmanage/lookSList";
    }
}
