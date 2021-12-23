package RESTfulAPI;

public class User {
    private int ID;
    private String name;
    private int age;
    private static int COUNTER = 1;
    public User() { this.ID = COUNTER++; }

    public int getID() { return ID; }
    public String getName() { return name;}
    public int getAge(){ return age; }
    public static int getCOUNTER() { return User.COUNTER; }

    public void setID(int ID) { this.ID =ID; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age;}
}
