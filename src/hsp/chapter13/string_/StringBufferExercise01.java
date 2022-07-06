package hsp.chapter13.string_;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);//需要看源码，底层调用的是AbstractStringBuilder的appendNull
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.length());

        StringBuffer sb = new StringBuffer(str);//看底层源码 super(str.length()+16)
        System.out.println(sb);


    }
}
