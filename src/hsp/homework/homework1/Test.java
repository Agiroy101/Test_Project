package hsp.homework.homework1;

public class Test {
    public static void main(String[] args) {
        Person[] people = new Person[4];
        people[0] = new Teacher("zs",'男',22,21);
        people[1] = new Teacher("ls",'男',23,22);
        people[2] = new Student("ww",'男',12,"2120");
        people[3] = new Student("zl",'男',10,"2122");
        Person temp = null;

        for (int i = 0; i < people.length - 1; i++) {
            for (int j = i; j <people.length - 1 - i; j++) {
                if(people[j].getAge() < people[j+1].getAge()){
                    temp = people[j];
                    people[j] = people[j+1];
                    people[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);

        }



    }



    static public void live(Person e){
        if(e instanceof Student){
            ((Student) e).study();
        }else if (e instanceof Teacher){
            ((Teacher) e).teach();
        }
    }

}
