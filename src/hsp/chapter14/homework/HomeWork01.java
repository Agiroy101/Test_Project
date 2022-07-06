package hsp.chapter14.homework;

import java.util.ArrayList;

public class HomeWork01 {
    public static void main(String[] args) {
        News news = new News("新闻一");
        News news2 = new News("新闻二");
        news.setContent("新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧");
        news2.setContent("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");

        ArrayList list = new ArrayList();
        list.add(news);
        list.add(news2);
//        list.sort(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return (((News) o2).getTitle()).compareTo(((News) o1).getTitle());
//            }
//        });
//        for (Object obj : list){
//            News n = (News) obj;
//            if(n.getContent().length() >= 15){
//                String s = (n.getContent()).substring(0, 15) + "...";
//                System.out.println(s);
//            }
//        }


//        System.out.println(list);
        for (int i = list.size() - 1; i >= 0; i--) {
//            System.out.println(list.get(i));
            News n = (News) list.get(i);
            if (n.getContent().length() >= 15) {
                String s = (n.getContent()).substring(0, 15) + "...";
                System.out.println(list.get(i) + ",内容：" + s);
            }
        }


    }
}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "title=" + title;
    }
}