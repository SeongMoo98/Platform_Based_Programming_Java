package Comparable_sorting.Comparator;

import java.util.Comparator;

class Employee2 implements Comparable<Employee2>{
    private int id;
    private String name;
    private int age;
    private long salary;

    public Employee2(int id, String name, int age, long salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String getName(){
        return this.name;
    }
    public long getSalary(){
        return this.salary;
    }
    public int getId(){
        return this.id;
    }
    public int getAge(){
        return this.age;
    }
    @Override
    public int compareTo(Employee2 emp){return ( this.id-emp.id); }


    //3개의 static 멤버변수 Comparable<T>의 anonymous class
    public static Comparator<Employee2> SalaryComparator=new Comparator<Employee2>() {
        public int compare(Employee2 e1,Employee2 e2){
            return (int)(e1.getSalary()-e2.getSalary());
        }
    };
    public static Comparator<Employee2> AgeComparator=new Comparator<Employee2>() {
        public int compare(Employee2 e1,Employee2 e2){
            return (int)(e1.getAge()-e2.getAge());
        }
    };

    public static Comparator<Employee2> NameComparator=new Comparator<Employee2>() {
        public int compare(Employee2 e1,Employee2 e2){
            return e1.getName().compareTo(e2.getName());
        }
    };


    @Override
    public String toString(){
        return String.format("[id=%d, name=%s, age=%d, salary=%d]",getId(),getName(),getAge(),getSalary());
    }

}

