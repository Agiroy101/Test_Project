package hsp.chapter17;

public class cupNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpuNums = runtime.availableProcessors();
        System.out.println("当前cpu的个数有：" + cpuNums);

    }
}
