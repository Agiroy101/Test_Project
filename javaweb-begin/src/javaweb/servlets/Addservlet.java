package javaweb.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Agiroy
 * @date 2022/5/16 15:00
 * @effect
 */
//@WebServlet("/add")//SpringBoot的内容，这里配置xml来实现
public class Addservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //post方式下，设置编码，防止中文乱码
        //get方式目前不需要设置编码（tomcat8之后）
        String method = request.getMethod();
        request.setCharacterEncoding("utf-8");
        String fanme = request.getParameter("fanme");
        Integer price = Integer.parseInt(request.getParameter("price"));
        Integer fcount = Integer.parseInt(request.getParameter("fcount"));
        String remark = request.getParameter("remark");
        System.out.println(fanme + "\t" + price + "\t" + fcount + "\t" + remark);


    }
}
