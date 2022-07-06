package hsp.chapter13.date_;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDate_ {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println("年：" + now.getYear());
        System.out.println("月：" + now.getMonth());
        System.out.println("月：" + now.getMonthValue());
        System.out.println("日：" + now.getDayOfMonth());
        System.out.println("时：" + now.getHour());
        System.out.println("分：" + now.getMinute());
        System.out.println("秒：" + now.getSecond());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd   HH:mm:ss");
        String day = dtf.format(now);
        System.out.println(now);

        //提供plus和minus方法可以对当前时间进行加或者减
        //看看890天后是什么时候
        LocalDateTime ld = now.plusDays(887);
        System.out.println("890天后：" + dtf.format(ld));

        //1234分钟前是什么时候
        LocalDateTime ld1 = now.minusMinutes(1234);
        System.out.println("1234分钟前是：" + dtf.format(ld1));


    }
}
