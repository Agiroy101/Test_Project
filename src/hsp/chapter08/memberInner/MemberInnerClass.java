package hsp.chapter08.memberInner;

public class MemberInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();

        //第一种方法
        Outer.Inner inner = outer.new Inner();
        inner.run();

        //第二种方法
        //利用外部类的内部类构造器来返回
        Outer.Inner inner1 = outer.getInner();
        inner1.run();

        //第三种方法
        //跟第一种基本一样，写法简略一点
        Outer.Inner inner2 = new Outer().new Inner();
        inner2.run();

    }
}

class Outer{
    private int i = 10;

    public void test(){
        System.out.println("test");
    }

    class Inner{
        private int i = 66;
        public void run(){
            System.out.println("run...");
            System.out.println("外部类的i:" + Outer.this.i + "\n内部类的i:" + i);
        }
    }

    public Inner getInner(){
        return new Inner();
    }

}
