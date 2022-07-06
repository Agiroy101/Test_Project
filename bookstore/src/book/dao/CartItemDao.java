package book.dao;

import book.pojo.CartItem;
import book.pojo.User;

import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/23 14:55
 * @effect
 */

public interface CartItemDao {

    //新增购物车项
    void addCartItem(CartItem cartItem);

    //修改特定的购物车项
    void updateCartIetm(CartItem cartItem);

    //获取特定用户的购物车项
    List<CartItem> getCartItemList(User user);

    //删除指定的购物车项
    void delCartItem(CartItem cartItem);

}
