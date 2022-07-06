package hsp.chapter13.date_;

import java.util.Calendar;

public class Calendar01 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c);

        System.out.println("年" + c.get(Calendar.YEAR));
        System.out.println("月" + (c.get(Calendar.MONTH)) + 1);
        System.out.println("日" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("时" + c.get(Calendar.HOUR));
        System.out.println("分" + c.get(Calendar.MINUTE));
        System.out.println("秒" + c.get(Calendar.SECOND));

        //用24小时进制来获取时间 ,Calendar.HOUR 改成 Calendar.HOUR_OF_DAY
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));
    }
}
