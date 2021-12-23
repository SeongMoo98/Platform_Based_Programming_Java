package Polymorphism;

public class PolymorphismText {
    public static void main(String[] args){
        Person p1= new Person("Brown", 19, "Busan");
        Person p2= new Person("James", 20, "Masan");
        Student s1=new Student("Ford", 19, "Kimhae","PNU");
        Student s2=new Student("Porter", 20, "Ulsna","PNU");
        //부모 클래스는 자식클래스를 참조 할수있다
        Person[] list={p1,p2,s1,s2};

        for(Person p:list){
            //p.getSchoolName불가능 - p는 Person type이다!
            System.out.printf("%s, %d%n",p.getName(),p.getAge());
            if(p instanceof Student){
                //Person의 p로 참조하고있지만 Student 이므로
                //Student로 explicit casting
                Student s=(Student) p;
                System.out.printf("School : %s, %s%n",s.getSchoolName(), s.getGrade());
            }

        }

    }
}
