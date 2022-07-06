package fruit.servlets;

import fruit.dao.impl.FruitDAOImpl;
import fruit.pojo.Fruit;
import myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Agiroy
 * @date 2022/5/17 16:40
 * @effect
 */


@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {
    private FruitDAOImpl fruitDAO = new FruitDAOImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidstr = req.getParameter("fid");
        System.out.println(fidstr);
        if(fidstr != null && (!fidstr.equals(""))){
            int fid = Integer.parseInt(fidstr);
            Fruit fruit = fruitDAO.getFruitById(fid);
            req.setAttribute("fruit",fruit);
            super.processTemplate("edit",req,resp);
        }
    }
}
