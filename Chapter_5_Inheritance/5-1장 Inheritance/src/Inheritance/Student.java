package Inheritance;

public class Student extends Person{
    private String schoolName ;
    private Grade grade = new Grade();

    public Student(String name, int age, String address, String schoolName){
        //부모 생성자 호출(super)
        //동일 클래스내에서 overloading된 생성자는 this(.....)
        super(name,age,address);
        this.schoolName=schoolName;
    }

    public String getSchoolName(){ return this.schoolName; }
    public void setSchoolName(String schoolName){ this.schoolName=schoolName; }

    public Grade getGrade() { return grade ; }
    public void upGrade(){ grade.upGrade(); }

    @Override
    public String toString(){
        return String.format("%s, %d, %s, %s, %s",super.name, getAge(),getAddress(),schoolName,grade);
    }
    // override hashCode() and equals()
}
