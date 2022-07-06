package hsp.chapter25.datesource;

/**
 * @author Agiroy
 * @date 2022/5/10 16:49
 * @effect t1对象和t1表的记录相对应
 */

public class t1 {
    private Integer id;
    private String name;
    private String sex;
    private Double sal;
    private String pwd;

    public t1(){//一定要给一个无参构造器

    }

    public t1(Integer id, String name, String sex, Double sal, String pwd) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.sal = sal;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "t1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", sal='" + sal + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
