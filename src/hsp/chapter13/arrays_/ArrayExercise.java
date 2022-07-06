package hsp.chapter13.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦",100);
        books[1] = new Book("金瓶梅新",90);
        books[2] = new Book("java从入门到放弃",15);
        books[3] = new Book("青年文摘20年",300);
        bubble(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int o11 = (int) o1;
                int o22 = (int) o2;
                return o11 - o22;
            }
        });

        bubble2(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int o11 = (int) o1;
                int o22 = (int) o2;
                return o11 - o22;
            }
        });

//        Arrays.sort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book book1 = (Book) o1;
//                Book book2 = (Book) o2;
//                return book1.price - book2.price;
//
//            }
//        });
//        Arrays.sort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book book1 = (Book) o1;
//                Book book2 = (Book) o2;
//                return book1.name.length() - book2.name.length();
//
//            }
//        });

        System.out.println(Arrays.toString(books));

    }
    public static void bubble(Book[] obj, Comparator c){
        Book o = null;
        for (int i = 0; i < obj.length - 1; i++) {
            for (int j = 0; j < obj.length - i - 1; j++) {
                if(c.compare(obj[j].price,obj[j + 1].price) > 0){
                    o = obj[j];
                    obj[j] = obj[j + 1];
                    obj[j + 1] = o;
                }
            }
        }
    }

    public static void bubble2(Book[] obj, Comparator c){
        Book o = null;
        for (int i = 0; i < obj.length - 1; i++) {
            for (int j = 0; j < obj.length - i - 1; j++) {
                if(c.compare(obj[j].name.length(),obj[j + 1].name.length()) > 0){
                    o = obj[j];
                    obj[j] = obj[j + 1];
                    obj[j + 1] = o;
                }
            }
        }
    }

}

class Book{
    public String name;
    public int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}