package hsp.chapter08.polyparameter;

public class Manager extends Employee{
    private double bouns;

    public Manager(String name, double salary, double bouns) {
        super(name, salary);
        this.bouns = bouns;
    }

    public double getBouns() {
        return bouns;
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }

    public String work(){
        return "经理" + getName() + "在工作中";
    }

    @Override
    public double getAunual() {
        return super.getAunual() + bouns;
    }


}
