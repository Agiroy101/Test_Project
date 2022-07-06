package book.dao;

import book.pojo.OrderItem;

/**
 * @author Agiroy
 * @date 2022/5/23 18:15
 * @effect
 */

public interface OrderItemDao {
    //添加订单项
    void addOrderItem(OrderItem orderItem);
}
