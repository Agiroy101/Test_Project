package hsp.chapter13.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortCustom {
    public static void main(String[] args) {
        int a[] = {1, 3, 5, -1, -4, 12, 3, 20};
        bubble(a,new Comparator(){

            @Override
            public int compare(Object o1, Object o2) {
                Integer o11 = (Integer) o1;
                Integer o21 = (Integer) o2;
                return o21 - o11;
            }
        });
        System.out.println(Arrays.toString(a));

    }

    public static void bubble(int a[], Comparator c) {
        int temp = 0;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (c.compare(a[j], a[j + 1]) > 0){
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}


