package Comparable_sorting.Comparable;

import java.util.ArrayList;
import java.util.Arrays;

public class SortingObjectMain {
    public static void main(String[] args){
        Employee[] empArr=new Employee[4];
        empArr[0] = new Employee(10, "Mikey", 25, 10000);
        empArr[1] = new Employee(20, "Arun", 29, 20000);
        empArr[2] = new Employee(5, "Lisa", 35, 5000);
        empArr[3] = new Employee(1, "Pankaj", 32, 50000);;

        //Employee는 Comparable<Employee> interface를 implement
        Arrays.sort(empArr);
        System.out.println("Default Sorting of Employees list : \b"+Arrays.toString(empArr));
    }
}
