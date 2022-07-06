package test;

import java.util.Arrays;

public class test10 {
    public static void main(String[] args) {
        String str[] = {"asdas","asd"};
        String[] strings = Arrays.copyOf(str, 12);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}
