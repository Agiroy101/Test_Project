package hsp.homework.homework1;

public class Teacher extends Person{

    private int work_age;

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    @Override
    public String play() {
        return super.play() + "爱玩象棋";
    }

    public String teach(){
        return "我承诺，我会认真教学。";
    }

    @Override
    public String toString() {
        return "Teacher" + super.toString() +
                ", work_age=" + work_age + "\n" + teach() + '\n' + play() +
                '}';
    }
}
