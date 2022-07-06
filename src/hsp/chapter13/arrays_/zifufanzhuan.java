package hsp.chapter13.arrays_;

public class zifufanzhuan {
    public static void main(String[] args) {
        String s = "abcdef";

        String ss = reverse(s,0,4);
        System.out.println(ss);
    }

    public static String reverse(String str, int start, int end){
//        String s = "";
//        System.arraycopy(str,start,s,0,end);
//        System.out.println(s);
//        s = str.substring(start,end);
        StringBuffer sb = new StringBuffer(str.substring(start,end+1));
        sb.reverse();
        char c[] = str.toCharArray();
        for (int i = start,j = 0; i <= end; i++,j++) {
            c[i] = sb.charAt(j);
        }
        String s1 = String.valueOf(c);
        String s2 = new String(c);
        return s1;

    }
}
