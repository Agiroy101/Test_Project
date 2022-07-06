package javaweb.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Agiroy
 * @date 2022/5/16 19:20
 * @effect
 */
@WebServlet("/demo04")
public class demo04Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo04");
        //服务器内部转发
//        req.getRequestDispatcher("demo05").forward(req,resp);
        //客户端重定向
        resp.sendRedirect("demo05");
    }
}
