package hsp.chapter23;

/**
 * @author Agiroy
 * @date 2022/4/29 23:54
 * @effect
 */

public class Car {
    public  String brand = "宝马";
    public int price = 500000;
    public String color = "白色";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
