package Lambda_Expression.Predicate_T;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//interface에 only one abstract method만 존재할때
@FunctionalInterface
interface CheckPerson{
    //Person을 받아 boolean return
    public abstract boolean test(Person p);
}

@FunctionalInterface
interface ComparePersons{
    public abstract boolean test(Person p1, Person p2);
}

public class Person {
    public enum Gender { MALE, FEMALE }

    String name;
    //LocalDate birthday;
    int age;
    Gender gender;
    String emailAddress;

    public Person(String name, int age, Gender gender, String emailAddress){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.emailAddress=emailAddress;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender(){
        return gender;
    }

    public String getName(){
        return name;
    }

    public void printPerson() {
        System.out.println("이름 : "+name);
        System.out.println("나이 : "+age);
        System.out.println("성별 : "+gender.name());
        System.out.println("이메일 : "+emailAddress);
    }
    //Search for Members - 원래 코딩스타일
    public static void printPersonOlderThan(List<Person> roster, int age){
        for(Person p : roster){
            if(p.getAge() >= age){
                p.printPerson();
            }
        }
    }

    //interface 사용 - anonymous, lambda Expression 사용가능
    public static void printPersons(List<Person> roster, CheckPerson tester){
        for(Person p : roster){
            if(tester.test(p)){
                p.printPerson();
            }
        }
    }

    //Lambda Expression - Predicate<T> - lambda 의 Interface
    //Predicate<T> - parameter로 한개 받고 return boolean
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester){
        for(Person p : roster){
            if(tester.test(p)){
                p.printPerson();
            }
        }
    }

    public static void ComparePersons(Person p1, Person p2, ComparePersons comparePersons){
        if(comparePersons.test(p1,p2)){
            p1.printPerson();
        }
    }


    public static void main(String[] args){
        Person p1 = new Person("철수", 23, Gender.MALE, "abc");
        Person p2 = new Person("영희", 21, Gender.FEMALE, "bcd");
        Person p3 = new Person("민수", 15, Gender.MALE, "cde");

        List<Person> list =new ArrayList<Person>();
        list.add(p1); list.add(p2); list.add(p3);

        System.out.println("원래 코딩 스타일");
        printPersonOlderThan(list, 20);

        System.out.println();
        System.out.println();

        System.out.println("interface, anonymous class 사용");
        printPersons(list, new CheckPersonEligibleForSelectiveService());

        System.out.println();
        System.out.println();

        /*Lambda Expression
        *람다로 넘겨주는게 abstract method의 statement이다
        */
        System.out.println("Lambda Expression 사용");
        //parameter은 p이고  expression을 적는다
        //expression은 하나 존재하는 method의 내용이 된다 ==> return type을 맞춰야 한다
        printPersons(list, (Person p)->p.getAge() >=18);


        System.out.println();
        System.out.println();

        System.out.println("좀 더 간단한 Lambda Expression");
        printPersons(list,
                (p)->p.getGender() == Person.Gender.MALE
                &&p.getAge()>=18
                && p.getAge() <= 25
        );


        System.out.println();
        System.out.println();
        //Predicate<T> - parameter : p 한개, return type : boolean 인 method는 모두 가능
        System.out.println("Predicate<T> 사용 ");
        printPersonsWithPredicate(list,
                (p)->p.getGender() == Gender.MALE
                &&p.getAge() >= 18
                &&p.getAge() <= 25
        );

        System.out.println();
        System.out.println();
        System.out.println("Parameter 2개 사용");
        ComparePersons(p1,p2,(a,b)->a.age>=b.age);
    }

}

class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p){
        return p.gender == Person.Gender.MALE &&
                p.getAge() >= 18 &&
                p.getAge() <=25;
    }

}
