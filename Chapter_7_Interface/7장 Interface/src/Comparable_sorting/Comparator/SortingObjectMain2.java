package Comparable_sorting.Comparator;

import java.util.Arrays;

public class SortingObjectMain2 {
    public static void main(String[] args) {
        Employee2[] empArr = new Employee2[4];
        empArr[0] = new Employee2(10, "Mikey", 25, 10000);
        empArr[1] = new Employee2(20, "Arun", 29, 20000);
        empArr[2] = new Employee2(5, "Lisa", 35, 5000);
        empArr[3] = new Employee2(1, "Pankaj", 32, 50000);;

        //Comparator을 사용한 Sort
        Arrays.sort(empArr,Employee2.SalaryComparator);
        System.out.println("Employee list sorted by salary\n"+Arrays.toString(empArr));

        Arrays.sort(empArr,Employee2.AgeComparator);
        System.out.println("Employee list sorted by age\n"+Arrays.toString(empArr));

        Arrays.sort(empArr,Employee2.NameComparator);
        System.out.println("Employee list sorted by name\n"+Arrays.toString(empArr));
    }
}
