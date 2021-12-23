package BasicMethods.hashCode;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, LocalDate hireDay){
        this.name=name;
        this.salary=salary;
        this.hireDay=hireDay;
    }

    //name이 null인 상황을 고려 x, hashCode 함수를 바로 사용하는 것은 위험하다
    public int hashCode1(){
        int result=1;
        result=31*result+name.hashCode();
        result=31*result+Double.valueOf(salary).hashCode();
        result=31*result+hireDay.hashCode();
        return result;
    }
    //name이 null인 상황 고려 - equals확인
    public int hashCode2(){
        int result=1;
        //이게 null인 것을 고려 해줌
        result=31*result+ Objects.hashCode(name);
        result=31*result+ Double.hashCode(salary);
        result=31*result+ Objects.hashCode(hireDay);
        return result;
    }

    //equals()와 hashCode()를 생성해줌
    public int hashCode3(){
        return Objects.hash(name,salary,hireDay);
    }

    public static void main(String []args){
        var e1=new Employee("Kim",200,LocalDate.of(2021,9,15));
        var e2=new Employee("Kim",200,LocalDate.of(2021,9,15));
        var e3=new Employee("kim",200,LocalDate.of(2021,9,15));
        //e1, e2가 같은 값이므로 hash값이 같아야함

        System.out.println(e1.hashCode()+" : "+ e1.hashCode1()+" : "+e1.hashCode2()+" : "+e1.hashCode3());
        System.out.println(e2.hashCode()+" : "+ e2.hashCode1()+" : "+e2.hashCode2()+" : "+e2.hashCode3());
        System.out.println(e3.hashCode()+" : "+ e3.hashCode1()+" : "+e3.hashCode2()+" : "+e3.hashCode3());
    }

}
