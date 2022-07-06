package fruit.servlets.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Agiroy
 * @date 2022/5/17 16:02
 * @effect
 */
@WebServlet("/demo06")
public class demo06Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = requset.getServletContext();
        Object name = application.getAttribute("name");
        System.out.println(name);
    }
}
