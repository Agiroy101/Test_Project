package book.controller;

import book.pojo.OrderBean;
import book.pojo.User;
import book.service.OrderService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Agiroy
 * @date 2022/5/23 18:38
 * @effect
 */

public class OrderController {

    private OrderService orderService;

    public String checkout(HttpSession session) {

        OrderBean orderBean = new OrderBean();
        Date now = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String nowStr = sdf.format(now);
        int year = now.getYear();
        int month = now.getMonth();
        int day = now.getDate();
        int hours = now.getHours();
        int minutes = now.getMinutes();
        int sec = now.getSeconds();
        orderBean.setOrderNo(UUID.randomUUID().toString() + "_" + year + month + day + hours + minutes + sec);
        orderBean.setOrderDate(now);
        User user = (User)session.getAttribute("currUser");
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);

        orderService.addOrderBean(orderBean);

        return "index";
    }

    public String getOrderList(HttpSession session){
        User user = (User)session.getAttribute("currUser");

        List<OrderBean> orderList = orderService.getOrderList(user);
        user.setOrderList(orderList);

        session.setAttribute("currUser",user);

        return "order/order";
    }
}
