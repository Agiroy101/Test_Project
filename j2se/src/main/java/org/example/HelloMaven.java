package org.example;

/**
 * @author Agiroy
 * @date 2022/5/28 16:40
 * @effect
 */

public class HelloMaven {
    public int add(int i1, int i2){
        return i1+i2;
    }

    public static void main(String[] args) {
        HelloMaven helloMaven = new HelloMaven();
        int add = helloMaven.add(1, 5);
        System.out.println(add);

    }
}
