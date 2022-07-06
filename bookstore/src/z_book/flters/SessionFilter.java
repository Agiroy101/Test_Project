package z_book.flters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/24 13:43
 * @effect
 */
//
//@WebFilter(urlPatterns = {"*.do","*.html"},
//    initParams = {@WebInitParam(name="bai",value = "/page.do?operate=page&page=user/login,/user.do?null")})
public class SessionFilter implements Filter {

    List<String> baiList = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String bai = filterConfig.getInitParameter("bai");
        String[] baiArr = bai.split(",");
        baiList = Arrays.asList(baiArr);

//        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getQueryString() = " + request.getQueryString());

        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        String str = uri + "?" + queryString;
        if(baiList.contains(str)){
            filterChain.doFilter(request,response);
            return;
        }else{
            HttpSession session = request.getSession();
            Object currUserObj = session.getAttribute("currUser");
            if (currUserObj == null){
                response.sendRedirect("page.do?operate=page&page=user/login");
            }else {
                filterChain.doFilter(request,response);
            }
        }


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
