import java.util.Objects;

public class Player {
    private String firstName;
    private String lastName;
    private int jerseyNumber;

    Player(String playerFirstName, String playerLastName,int playerJerseyNumber){
        this.firstName=playerFirstName;
        this.lastName=playerLastName;
        this.jerseyNumber=playerJerseyNumber;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){return this.lastName; }
    public int getJerseyNumber(){
        return this.jerseyNumber;
    }

    public String toString(){
        String msg="["+lastName+", "+firstName+ " "+jerseyNumber+"]";
        return msg;
    }
    public boolean equals(Object otherPlayer){
        if(!(otherPlayer instanceof Player)) {
            return false;
        }
        Player p= (Player)otherPlayer;
        return firstName==p.firstName && lastName == p.lastName && jerseyNumber==p.jerseyNumber;
    }
    public int hashCode(){
        int result=1;
        result=31*result + Objects.hashCode(firstName);
        result=31*result + Objects.hashCode(lastName);
        result=31*result + Integer.hashCode(jerseyNumber);
        return result;
    }

}
