package book.service;

import book.pojo.Cart;
import book.pojo.CartItem;
import book.pojo.User;

import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/23 15:02
 * @effect
 */

public interface CartItemService {
    void addCartItem(CartItem cartItem);

    void updateCartItem(CartItem cartItem);

    void addOrUpdateCartItem(CartItem cartItem, Cart cart);

    List<CartItem> getCartItemList(User user);

    //加载特定用户的购物车信息
    Cart getCart(User user);
}
