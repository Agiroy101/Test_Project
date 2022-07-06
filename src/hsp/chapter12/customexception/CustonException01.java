package hsp.chapter12.customexception;

public class CustonException01 {
    public static void main(String[] args) {

        try {
            if(args.length != 2){
                throw new ArratIndexOutOfBoundsException("参数个数不对");
            }

            int i1 = Integer.parseInt(args[0]);
            int i2 = Integer.parseInt(args[1]);

            double res = i1/i2;
            System.out.println(res);

        }catch (ArratIndexOutOfBoundsException arratIndexOutOfBoundsException){
            System.out.println(arratIndexOutOfBoundsException.getMessage());
        }catch (ArithmeticException arithmeticException){
            System.out.println("除数不能为0");
        }catch (NumberFormatException numberFormatException){
            System.out.println("参数格式不对");
        }
    }


}

class ArratIndexOutOfBoundsException extends RuntimeException{
    public ArratIndexOutOfBoundsException(String message) {
        super(message);
    }
}