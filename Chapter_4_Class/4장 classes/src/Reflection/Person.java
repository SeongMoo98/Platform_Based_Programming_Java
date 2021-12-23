package Reflection;

class Person
{
    public Person(java.lang.String name , int age , java.lang.String address) { }

    public int getAge() { return 1;}
    public void increaseAge() { }
    public void moveTo(java.lang.String address) { }

    public java.lang.String toString() {return address; }
    public java.lang.String getAddress() {return address; }
    public java.lang.String getName() { return name; }

    public void rename(java.lang.String address) { }

    private java.lang.String name;
    private int age;
    private java.lang.String address;
}