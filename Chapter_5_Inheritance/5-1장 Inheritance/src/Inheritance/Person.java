package Inheritance;

class Person {
    //private - subclass에서 접근불가
    //protected - subclass에서 super.name으로 접근이 가능함
    protected String name ;
    private int age ;
    private String address ;

    public Person(String name, int age, String address) {
        this.name = name ; this.age = age ; this.address = address ;
    }
    public String getName() { return name ; }
    public int getAge() { return age ; }
    public String getAddress() { return address ; }

    public void rename(String name) { this.name = name ; }
    public void increaseAge() { age ++; }
    public void moveTo(String address) { this.address = address ; }

    //override하다 오탈자가 나면 완전 새로운 메소드 이므로 Override할때는
    //@Override를 적어주자
    @Override
    public String toString(){
        return String.format("%s, %d, %s",name,age,address);
    }
    // override hashCode() and equals()
}
