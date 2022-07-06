package hsp.chapter14.map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Map_ {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("no1","韩顺平");//新的k-v
        map.put("no2","张无忌");//新的k-v
        map.put("no1","张三丰");//当有相同的k,就等价于替换 源码中有e = p
        map.put("no3","张三丰");//新的k-v
        map.put(null,null);//新的k-v
        map.put(null,"asd");//等价替换
        map.put("no4",null);//新的k-v
        map.put("no5",null);//新的k-v

        //通过get方法，传入key，会返回对应的value
        System.out.println(map.get("no2"));

        System.out.println(map);

        //k-v是存放在  HashMap$Node node  = newNode(hash, key, vlaue, null)
        //为了方便遍历，还会创建EntrySet集合，该集合存放的元素的类型是Entry，一个Entry对象就有k,v    Entry<Entry<k,v>>
        //个人理解是：HashMap$Node实现了EntrySet接口,在entrySet类中k,v只是指向了HashMap$Node中的元素
        Set set = map.entrySet();
        for (Object obj: set) {
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        //HashMap中有keySet()和Values()方法来单独获取k和v的值
        Set set1 = map.keySet();
        System.out.println(set1.getClass());
        System.out.println(set1);
        Collection values = map.values();
        System.out.println(values.getClass());
        System.out.println(values);

    }
}
