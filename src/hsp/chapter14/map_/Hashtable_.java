package hsp.chapter14.map_;

import java.util.Hashtable;

public class Hashtable_ {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();
        table.put("john",12);
//        table.put(null,12);//异常 k不能为空
//        table.put("john",null);//异常 v不能为空
        table.put("lucy",42);
        table.put("lic",100);
        table.put("lic",998);
        System.out.println(table);
    }
}
