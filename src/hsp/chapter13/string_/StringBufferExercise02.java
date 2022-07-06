package hsp.chapter13.string_;

import java.util.Scanner;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        StringBuffer sb = new StringBuffer().append(next);
        int j = sb.indexOf(".");
        int i = sb.indexOf(" ");
        int sum = 1;
        for (int k = j-1; k > i; k--) {
            if(sum == 3){
                sb = sb.insert(k,",");
                sum = 0;
            }else {
                sum += 1;
            }
        }
        System.out.println(sb);

    }
}
