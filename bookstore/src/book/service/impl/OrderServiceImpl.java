package book.service.impl;

import book.dao.CartItemDao;
import book.dao.OrderDao;
import book.dao.OrderItemDao;
import book.pojo.CartItem;
import book.pojo.OrderBean;
import book.pojo.OrderItem;
import book.pojo.User;
import book.service.OrderService;

import java.util.List;
import java.util.Map;

/**
 * @author Agiroy
 * @date 2022/5/23 18:27
 * @effect
 */

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    private OrderItemDao orderItemDao;
    private CartItemDao cartItemDao;
    private Integer getOrderTotalCount;

    @Override
    public void addOrderBean(OrderBean orderBean) {
        orderDao.addOrderBean(orderBean);
        User currUser = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();
        for (CartItem cartItem : cartItemMap.values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemDao.addOrderItem(orderItem);
        }
//        List<OrderItem> orderItemList = orderBean.getOrderItemList();
//        for (OrderItem orderItem : orderItemList) {
//            orderItemDao.addOrderItem(orderItem);
//        }



        for (CartItem cartItem : cartItemMap.values()) {
            cartItemDao.delCartItem(cartItem);
        }
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        List<OrderBean> orderBeanList = orderDao.getOrderList(user);
        for (OrderBean orderBean : orderBeanList) {
            Integer totalBookCount = orderDao.getOrderTotalBookCount(orderBean);
            orderBean.setTotalBookCount(totalBookCount);
        }


        return orderBeanList;
    }
}
