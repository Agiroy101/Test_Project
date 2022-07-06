package hsp.chapter14.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionIterator {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Book("三国演义","罗贯中",21));
        list.add(new Book("红楼梦","曹雪芹",12));
        list.add(new Book("水浒传","施耐庵",31));

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            Object obj = iterator.next();
            System.out.println(obj);
        }

        //根据itit代码模板快速生成的代码
//        while (iterator.hasNext()) {
//            Object next =  iterator.next();
//
//        }


        //当退出while循环后，这是iterator迭代器，指向最后的元素
//        iterator.next();//会抛NoSuchElementException异常
        //如果希望再次遍历，需要重置迭代器
        iterator = list.iterator();
        System.out.println("===第二次遍历===");
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }


        System.out.println("===增强for===");
        //底层也是迭代器
        //快捷键是大写的I或者是list.for
        for (Object book: list) {
            System.out.println(book);
        }


    }
}

class Book{
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}