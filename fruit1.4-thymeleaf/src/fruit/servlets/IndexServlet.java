package fruit.servlets;


import fruit.dao.FruitDAO;
import fruit.pojo.Fruit;
import fruit.dao.impl.FruitDAOImpl;
import myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


//Servlet从3.0版本开始支持注解方式的注册
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req,resp);
    }


    @Override
    public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession() ;
        Integer pageNo = 1;
        String oper = request.getParameter("oper");
        //如果oper不为空，说明通过表单的查询按钮跳转过来的
        //如果oper为空，说明不是通过表单的查询按钮跳转过来的

        String keyword = null;
        if ("search".equals(oper)){
             keyword = request.getParameter("keyword");
            if(keyword == null || keyword.equals("")){
                keyword="";
            }
            session.setAttribute("keyword",keyword);
        }else {
            String pageNoStr = request.getParameter("pageNo");
            if (pageNoStr != null){
                pageNo = Integer.parseInt(pageNoStr);
            }
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj!=null){
                keyword = (String) keywordObj;
            }else {
                keyword="";
            }
        }




        session.setAttribute("pageNo",pageNo);

        int fruitCount = fruitDAO.getFruitCount(keyword);

        int pageCount = (fruitCount+4)/5 ;

        session.setAttribute("pageCount",pageCount);
        if (pageNo > pageCount){
            pageNo = pageCount;
        }
        session.setAttribute("pageNo",pageNo);

        List<Fruit> fruitList = fruitDAO.getFruitList(keyword,pageNo);
        //保存到session作用域

        session.setAttribute("fruitList",fruitList);
        //此处的视图名称是 index
        //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
        //逻辑视图名称 ：   index
        //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
        //所以真实的视图名称是：      /       index       .html
        super.processTemplate("index",request,response);

    }
}
