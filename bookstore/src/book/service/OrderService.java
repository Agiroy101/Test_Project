package book.service;

import book.pojo.OrderBean;
import book.pojo.User;

import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/23 18:25
 * @effect
 */

public interface OrderService {
    public void addOrderBean(OrderBean orderBean);

    List<OrderBean> getOrderList(User user);

}
