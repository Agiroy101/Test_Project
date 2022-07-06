package book.dao;

import book.pojo.OrderBean;
import book.pojo.User;

import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/23 18:14
 * @effect
 */

public interface OrderDao {
    //添加订单
    void addOrderBean(OrderBean orderBean);

    List<OrderBean> getOrderList(User user);

    Integer getOrderTotalBookCount(OrderBean orderBean);

}
