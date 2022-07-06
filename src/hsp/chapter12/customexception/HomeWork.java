package hsp.chapter12.customexception;

public class HomeWork {
    public static void main(String[] args) {
        new Person("asd","123321","asd@.com");

    }
}

class Person{
    String name;
    String pwd;
    String email;

    public Person(String name, String pwd, String email) {
        setName(name);
        setEmail(email);
        setPwd(pwd);
        System.out.println("恭喜你注册成功");
    }

    public void setName(String name) {
        if(name.length()>=4 || name.length()<=2){
            throw new RuntimeException("用户名长度异常");
        }
        this.name = name;
    }

    public void setPwd(String pwd) {
        for (int i = 0; i < pwd.length(); i++) {
            if(pwd.charAt(i)>=57 || pwd.charAt(i) <= 48){
                throw new RuntimeException("密码必须为数字");
            }
            if(pwd.length()>6){
                throw new RuntimeException("长度不能大于6");
            }
        }
        this.pwd = pwd;
    }

    public void setEmail(String email) {
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if(i == -1 || j == -1){
            throw new RuntimeException("邮箱必须包含@和.");
        }
        if(i > j)
            throw new RuntimeException("@必须在.的前面");
        this.email = email;
    }
}
