package book.dao.impl;

import book.dao.OrderItemDao;
import book.pojo.OrderItem;
import myssm.basedao.BaseDAO;

/**
 * @author Agiroy
 * @date 2022/5/23 18:22
 * @effect
 */

public class OrderItemDaoImpl extends BaseDAO<OrderItem> implements OrderItemDao {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        super.executeUpdate("insert into t_order_item values(0,?,?,?)",orderItem.getBook().getId(),orderItem.getBuyCount(),orderItem.getOrderBean().getId());
    }
}
