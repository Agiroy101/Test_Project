package hsp.chapter11.enumeration;

public class EnumExercise {
    public static void main(String[] args) {
        Week[] weeks = Week.values();
        for (Week week:weeks){
            System.out.println(week);
        }
    }
}

enum Week{
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),THURSDAY("星期四"),FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期日");
    private String day;

    Week(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return day ;
    }
}
