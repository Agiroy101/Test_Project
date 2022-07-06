package hsp.chapter12.customexception;

public class CustomException {
    public static void main(String[] args) {

        int age = 190;
        if(age >= 150 || age < 0){
            throw new AgeException("年龄输入有误");
        }
    }
}


class AgeException extends RuntimeException{
    public AgeException(String message) {
        super(message);
    }
}