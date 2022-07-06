package hsp.chapter08.polyparameter;

public class Test {


    public static void main(String[] args) {
        Employee e1 = new Worker("zs", 2000);
        Employee e2 = new Manager("ls", 5000, 200000);
        Test test1  = new Test();
        test1.ShowEmpAnnal(e1);
        test1.ShowEmpAnnal(e2);

        test1.Testwork(e1);
        test1.Testwork(e2);



    }

    public void ShowEmpAnnal(Employee e) {
        System.out.println(e.getAunual());
    }

    public void Testwork(Employee e) {
        if (e instanceof Worker) {
            System.out.println(((Worker) e).work());
        } else if (e instanceof Manager) {
            System.out.println(((Manager) e).work());
        }
    }

}
