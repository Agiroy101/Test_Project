package hsp.chapter11.enumeration;

public class EnumMethod {
    public static void main(String[] args) {
        Season spring = Season.Spring;
        System.out.println(spring);
        System.out.println(spring.name());
        //ordinal() 输出的是该美剧对象的次序/编号,从0开始编号
        //Spring 枚举对象时第一个，因此输出0
        System.out.println(spring.ordinal());

        //从反编译可以看出values方法，返回Season[]
        //含有定义的所有枚举对象
        Season[] values = Season.values();
        for (Season season : values) {
            System.out.println(season);
        }

        Season spring1 = Season.valueOf("Spring");
        System.out.println(spring==spring1);

        //return self.ordinal - other.ordinal
        System.out.println(Season.Spring.compareTo(Season.Winter));

        System.out.println(Season.Spring.getDeclaringClass());
    }
}
