package hsp.chapter13.date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        Date date1 = new Date();
        System.out.println(date);

        SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日 hh小时:mm:ss E");
        String day = sd.format(date);
        System.out.println(day);

//        String s = "1990年1月1日 12:20:21 星期二";
//        Date date1 = sd.parse(s);
//
//
//        System.out.println(sd.format(date1));

    }
}
