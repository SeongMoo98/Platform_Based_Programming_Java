package Initialization;

import java.util.Random;

class Employee {
    // 5. constructors
    public Employee(String n, double s) {
        name = n; salary = s;
    }
    public Employee(double s) {
        this("Employee #" + nextId, s);
    }
    public Employee() {
        //name = "“, salary =1000, id initialized in initialization block
    }


    public String getName() { return name; }
    public int getId() { return id; }
    public double getSalary() { return salary ; }


    private static int nextId; //1. static field (default value)
    private int id; // = 0; // 3. instance field (default value)
    private String name = ""; // 3.1 instance field initialization
    private double salary = 1000 ; // 3.2 instance field initialization

    // 2. static initialization block
    static {
        Random generator = new Random();
        nextId = generator.nextInt(10000);
    }
    // 4 object initialization block
    { id = nextId; nextId++; }
}

public class Initialization {
    public static void main(String[]args){
        Employee[] staff=new Employee[3];
        staff[0]=new Employee("Rovert",40000);
        staff[1]=new Employee(60000);
        staff[2]=new Employee();

        for(var e :staff){
            System.out.printf("name = %-15s, id = %6d, salary = %-10.1f%n",e.getName(),e.getId(),e.getSalary());
        }
    }


}
