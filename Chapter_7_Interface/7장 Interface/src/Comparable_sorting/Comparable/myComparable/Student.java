package Comparable_sorting.Comparable.myComparable;

public class Student implements MyComparable {
    private int studentID;
    private String name;
    private float gpa;

    public Student(int id, String name, float gpa) {
        studentID = id;
        this.name = name;
        this.gpa = gpa;
    }


    @Override
    public int compareTo(Object other) {
        Student otherStudent = (Student) other;
        int returnValue = 0;
        if (gpa < otherStudent.gpa) returnValue = -1;
        if (gpa == otherStudent.gpa) returnValue = 0;
        if (gpa > otherStudent.gpa) returnValue = 1;
        return returnValue;
    }

    @Override
    public boolean equal(Object other) {
        return studentID == ((Student) other).studentID;
    }

    public String toString() {
        return String.format("ID: %5d, Name: %15s, GPA: %5.2f", studentID, name, gpa);
    }
}
