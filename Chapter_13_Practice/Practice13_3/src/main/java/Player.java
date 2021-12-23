import java.util.Arrays;
import java.util.List;

public class Player {
    private int ID;
    private String SHORT_NAME;
    private int HEIGHT_CM;
    private String COUNTRY_NAME;
    private String CLUB_NAME;
    private int OVERALL;
    private List<String> POSITIONS;

    public Player(int id, String name, int heightCM, String countryName, String clubName, int overall, List<String> positions){
        this.ID = id;
        this.SHORT_NAME = name;
        this.HEIGHT_CM = heightCM;
        this.COUNTRY_NAME = countryName;
        this.CLUB_NAME = clubName;
        this.OVERALL = overall;
        this.POSITIONS = positions;
    }

    public int getId() {
        return ID;
    }

    public String getName() {
        return SHORT_NAME;
    }

    public int getHeight() {
        return HEIGHT_CM;
    }

    public String getNationality() {
        return COUNTRY_NAME;
    }

    public String getClub() {
        return CLUB_NAME;
    }

    public int getOverall() {
        return OVERALL;
    }

    public List<String> getPositions() {
        return this.POSITIONS;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public void setName(String name) {
        this.SHORT_NAME = name;
    }

    public void setHeight(int height) {
        this.HEIGHT_CM = height;
    }

    public void setNationality(String country) {
        this.COUNTRY_NAME = country;
    }

    public void setClub(String club) {
        this.CLUB_NAME = club;
    }

    public void setOverall(int overall) {
        this.OVERALL = overall;
    }

    public void setPositions(List<String> positions) {
        this.POSITIONS = positions;
    }

    @Override
    public String toString(){
        return String.format("%d,%s,%d,%s,%s,%d,\"%s\"", getId(), getName(), getHeight(), getNationality(), getClub(), getOverall(), POSITIONS.toString().replaceAll("\\[|\\]", ""));

    }
}
