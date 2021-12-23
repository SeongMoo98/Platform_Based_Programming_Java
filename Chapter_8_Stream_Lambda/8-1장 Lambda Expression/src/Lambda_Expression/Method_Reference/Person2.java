package Lambda_Expression.Method_Reference;
/**
 * Lambda Expression
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Person2 {
    String name;
    int age;

    public Person2(String name, int age){
        this.name=name;
        this.age =age;
    }

    public String getName(){ return name; }
    public int getAge(){
        return age;
    }

    public static int compareByName(Person2 a, Person2 b){
        return a.getName().compareTo(b.getName());
    }

    public static void main(String[] args){
        List<Person2> rosterAsList =
                Arrays.asList(new Person2("Lee",15), new Person2("Park",23), new Person2("Kim",19));

        //anonymous class
        //나이로 정렬
        rosterAsList.sort( new PersonNameComparator() );
        System.out.println(rosterAsList.toString());

        // 이름으로 정렬
        //anonymous class - 바로 정의
        rosterAsList.sort(new Comparator<Person2>() {
            @Override
            public int compare(Person2 o1, Person2 o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(rosterAsList.toString());


        //lambda Expression
        rosterAsList.sort( (a, b) -> a.getName().compareTo( b.getName() ) );
        System.out.println(rosterAsList.toString());

        //Method reference
        rosterAsList.sort(Person2::compareByName);
        System.out.println(rosterAsList.toString());
    }


    @Override
    public String toString(){
        return "이름 : " +getName()+ " 나이 : "+getAge()+" ";
    }

}

class PersonNameComparator implements Comparator<Person2> {
    @Override
    public int compare(Person2 a, Person2 b){
        if( a.getAge() > b.getAge() ){
            return 1;
        }
        else if(a.getAge() == b.getAge()){
            return 0;
        }
        return -1;
    }
}

