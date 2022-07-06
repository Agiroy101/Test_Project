package hsp.chapter11.enumeration;

public class Enumeration {
    public static void main(String[] args) {
        System.out.println(Season.Spring);
        System.out.println(Season.Winter);
    }
}

enum Season{
    Spring("春天","温暖"),Summer("夏天","炎热"),Autumn("秋天","凉爽"),Winter("冬天","寒冷");
    private String name;
    private String desc;

    private String getName() {
        return name;
    }

    private String getDesc() {
        return desc;
    }

    Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}