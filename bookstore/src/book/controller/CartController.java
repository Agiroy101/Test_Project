package book.controller;

import book.pojo.Book;
import book.pojo.Cart;
import book.pojo.CartItem;
import book.pojo.User;
import book.service.CartItemService;

import javax.servlet.http.HttpSession;

/**
 * @author Agiroy
 * @date 2022/5/23 14:53
 * @effect
 */

public class CartController {

    private CartItemService cartItemService;

    //加载当前用户的购物车信息
    public String index(HttpSession session){
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
        session.setAttribute("currUser",user);
        return "cart/cart";

    }

    public String addCart(Integer bookId, HttpSession session){
        User user = (User) session.getAttribute("currUser");
        CartItem cartItem = new CartItem(new Book(bookId),1,user);
        //将指定的图书添加到当前用户的购物车中
        //如果当前用户的购物车中已经存在这个图书了，那么将购物车中这个图书的数量+1
        //否则在我的购物车新增一个这本图书的CartItem，数量是1

        cartItemService.addOrUpdateCartItem(cartItem, user.getCart());

        return "redirect:cart.do";
    }

    public String editCart(Integer cartItemId, Integer buyCount){
        cartItemService.updateCartItem(new CartItem(cartItemId,buyCount));

        return "redirect:cart.do";
    }
}
