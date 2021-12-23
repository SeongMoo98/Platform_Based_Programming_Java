package Inheritance;

public class StudentTest {
    public static void main(String[] args){
        Student s1=new Student("Ford",19,"Kimhae","PNU");
        System.out.println(s1);
        s1.setSchoolName("한국대학교");
        s1.upGrade();
        System.out.println(s1);

        Student s2=new Student("Poter",20,"Ulsan","PNU");
        System.out.println(s2);
        s2.rename("Harrison");
        s2.increaseAge();
        System.out.println(s2);
    }
}
