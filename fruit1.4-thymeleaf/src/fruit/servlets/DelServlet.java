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
 * @date 2022/5/17 18:52
 * @effect
 */

@WebServlet("/del.do")
public class DelServlet extends ViewBaseServlet {
    private FruitDAOImpl fruitDAO = new FruitDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int fid = Integer.parseInt(request.getParameter("fid"));
        int i = fruitDAO.delFruitById(fid);
        System.out.println(i>0?"成功":"失败");
        response.sendRedirect("index");


    }
}
