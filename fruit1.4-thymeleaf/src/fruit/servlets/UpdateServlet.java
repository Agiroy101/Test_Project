package fruit.servlets;

import fruit.dao.impl.FruitDAOImpl;
import myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Agiroy
 * @date 2022/5/17 17:19
 * @effect
 */
@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {
    private FruitDAOImpl fruitDAO = new FruitDAOImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String fname = request.getParameter("fname");
        Integer price = Integer.parseInt(request.getParameter("price"));
        Integer fcount = Integer.parseInt(request.getParameter("fcount"));
        String remark = request.getParameter("remark");
        int fid = Integer.parseInt(request.getParameter("fid"));
        System.out.println(fid);
//        int i = fruitDAO.updateFruitById(new Fruit(fid, fname, price, fcount, remark));
        int i = fruitDAO.updateFruitById(fid, fname, price, fcount, remark);
        System.out.println(i>0?"成功":"失败");
//        super.processTemplate("index",request,response);
        //上面的语句相当于request.getRequestDispatcher("index.html").forward(request,response);
        //此处需要重定向，目的是重新给IndexServlet发请求，重新获取fruitList，然后覆盖到session域中，这样index.html显示的数据才是最新的
        response.sendRedirect("index");

    }
}
