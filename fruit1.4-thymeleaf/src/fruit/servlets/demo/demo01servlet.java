package fruit.servlets.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Agiroy
 * @date 2022/5/17 16:00
 * @effect
 */
@WebServlet("/demo01")
public class demo01servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name","Agiroy01");
        request.getRequestDispatcher("demo02").forward(request,response);
    }
}
