import java.util.ArrayList;
import java.util.Objects;

public class FootballClub {
    private String name;
    private final int maxSquadSize=25;

    private ArrayList<Player> squad =new ArrayList<Player>();

    public FootballClub(String FootballClubName){
        this.name=FootballClubName;
    }

    public void addPlayer(Player newPlayer) {
        squad.add(newPlayer);
    }

    public void removeAllPlayer(){
        squad.clear();
    }

    public Player findPlayer(String playerFirstName,int jerseyNumber){
        for(int i=0; i < squad.size(); i++){
            final String compFirstName=squad.get(i).getFirstName();
            final int compJerseyNumber=squad.get(i).getJerseyNumber();
            if(( compFirstName.equals(playerFirstName)) && (compJerseyNumber==jerseyNumber)){
                return squad.get(i);
            }
        }
        return null;
    }

    public String toString() {
        String msg = "FootballClub Name: " + name + " Player Count: " + squad.size() + "\n";
        for (int i = 0; i < squad.size(); i++) {
            msg += "\t" + squad.get(i) + "\n";
        }
        return msg;
    }

    public boolean equals(Object otherFootballClub){
        if(!(otherFootballClub instanceof FootballClub)){
            return false;
        }
        FootballClub f= (FootballClub)otherFootballClub;

        return name==f.name && squad.equals(f.squad);
    }

    public int hashCode(){
        int result=1;
        result=31*result + Objects.hashCode(name);
        return result;
    }

}
