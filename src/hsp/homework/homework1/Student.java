package hsp.homework.homework1;

public class Student extends Person{

    private String stu_id;

    public Student(String name, char sex, int age, String stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    @Override
    public String play() {
        return super.play() + "爱玩足球。";
    }

    public String study(){
        return "我承诺，我会认真学习。";

    }

    @Override
    public String toString() {
        return "Student" + super.toString() +
                ", stu_id='" + stu_id + '\'' + "\n" + study() + '\n' + play() +
                '}';
    }
}
