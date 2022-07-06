package hsp.chapter14.map_;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Properties_ {
    public static void main(String[] args) {
        Properties properties = new Properties();
//        properties.put("john",null);//异常 Properties继承了Hashtable类，所以键值都不能为空

        properties.put("john",123);
        properties.put("luck","123");
        properties.put("milk",12);
        properties.put("lic",23);
        System.out.println(properties);

        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Object, Object> next =  iterator.next();
            System.out.println(next.getKey()+"-"+next.getValue());
        }

        //根据key获取value
        System.out.println(properties.get("lic"));
        System.out.println(properties.getProperty("john"));

    }
}
