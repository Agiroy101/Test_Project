package test;

public class test3 {
    public static void main(String[] args) {

        double[] a = new double[10];
        for (int i = 0; i < 10; i++) {
            a[i] = Math.random() * 100;
            System.out.printf("%.2f\n",a[i]);
        }
    }
}
