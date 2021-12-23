package Initialization;

import java.util.Objects;

public class Employee_null {
    //default : null
    private final String name;

    public Employee_null(String name){
        //if(name==null){
        //    throw new NullPointerException("Employee name should be given");
        //}
        //this.name=name;


        this.name= Objects.requireNonNull(name,"Employee name should be given");
        //this.name=Objects.requireNonNullElse(name,"Unknown");

    }

    public String getName(){
        return name;
    }

    public static void main(String[] args){
        Employee_null e1=new Employee_null("Brown");
        System.out.println(e1.getName());

        Employee_null e2=new Employee_null(null);
        System.out.println(e2.getName());
    }
}
