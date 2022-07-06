package book.pojo;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

/**
 * @author Agiroy
 * @date 2022/5/23 15:06
 * @effect
 */

public class Cart {
    private Map<Integer, CartItem> cartItemMap; //购物车中购物车项的集合，这个Map中的key是book的id
    private Double totalMoney;//购物车的总金额
    private Integer totalCount;//购物车中购物种类的数量，不是商品的总数量
    private Integer totalBookCount;//购物车中书本的总数量



    public Cart() {
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney = 0.0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for (Map.Entry<Integer, CartItem> cartItemEntry : entries) {
                CartItem cartItem = cartItemEntry.getValue();
                BigDecimal bigDecimal1 = new BigDecimal(cartItem.getBook().getPrice()+"");
                BigDecimal bigDecimal2 = new BigDecimal(cartItem.getBuyCount());
//                bigDecimal1.multiply(bigDecimal2).doubleValue();
                totalMoney += bigDecimal1.multiply(bigDecimal2).doubleValue();;
//                totalMoney += cartItem.getBook().getPrice() * cartItem.getBuyCount();
            }
        }


        return totalMoney;
    }
//只读属性，所以不需要set方法
    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getTotalCount() {
        totalCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            totalCount = cartItemMap.size();
        }
        return totalCount;
    }
//只读属性，所以不需要set方法
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            for (CartItem cartItem : cartItemMap.values()) {
                totalBookCount += cartItem.getBuyCount();
            }
        }
        return totalBookCount;
    }

    public void setTotalBookCount(Integer totalBookCount) {
        this.totalBookCount = totalBookCount;
    }
}
