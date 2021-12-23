package Comparable_sorting.Comparable;

public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int age;
    private long salary;

    public Employee(int id, String name, int age, long salary) {
        this.id=id;
        this.name=name;
        this.age=age;
        this.salary=salary;
    }

    //Comparable interface는 Override CompareTO
    //Comparable은 Sort할때 쓰인다
    @Override
    public int compareTo(Employee emp){
        return (this.id-emp.id);
    }
}
