package hsp.chapter08.polyparameter;

public class Worker extends Employee{
    public Worker(String name, double salary) {
        super(name, salary);
    }

    public String work(){
        return "工人" + getName() + "在工作中";
    }

    @Override
    public double getAunual() {
        return super.getAunual();
    }


}
