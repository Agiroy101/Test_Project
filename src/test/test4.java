package test;

public class test4 {
    public static void main(String[] args) {
        String s = "ITcastHeiMa";
        char c[] = s.toCharArray();


        StringBuffer s1 = new StringBuffer();

        for (int i = c.length- 1; i >= 0; i--) {
            if(c[i] >= 'A' && c[i] <='Z'){//Character.isUpperCase(c[i]
                s1.append(String.valueOf(c[i]).toLowerCase());
            }else {

                s1.append(String.valueOf(c[i]).toUpperCase());
            }


        }
        System.out.println(s1.toString());
    }

}
