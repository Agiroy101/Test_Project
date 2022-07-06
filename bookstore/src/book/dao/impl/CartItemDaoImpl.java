package book.dao.impl;

import book.dao.CartItemDao;
import book.pojo.CartItem;
import book.pojo.User;
import myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/23 14:57
 * @effect
 */

public class CartItemDaoImpl extends BaseDAO<CartItem> implements CartItemDao {
    @Override
    public void addCartItem(CartItem cartItem) {
        super.executeUpdate("insert into t_cart_item values(0,?,?,?)",cartItem.getBook().getId(),cartItem.getBuyCount(),cartItem.getUserBean().getId());
    }

    @Override
    public void updateCartIetm(CartItem cartItem) {
        executeUpdate("update t_cart_item set buyCount = ? where id = ?",cartItem.getBuyCount(),cartItem.getId());
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        return executeQuery("select * from t_cart_item where userBean = ? " , user.getId());
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        super.executeUpdate("delete from t_cart_item where id = ?",cartItem.getId());
    }
}
