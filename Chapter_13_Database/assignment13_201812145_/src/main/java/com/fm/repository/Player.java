package com.fm.repository;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name="PLAYER")
public class Player {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private int id;
    @Column(name="SHORT_NAME")
    private String name;
    @Column(name="HEIGHT_CM")
    private int height;
    @ManyToOne(optional = false)
    @JoinColumn(name="COUNTRY_ID")
    private Country country;
    @ManyToOne(optional = false)
    @JoinColumn(name="CLUB_ID")
    private Club club;
    @Column(name="OVERALL")
    private int overall;
    @Column(name="PLAYER_POSITIONS")
    private String positions;
    private static int MAXID = 0;
    public Player() {}

    //Getter
    public int getId() { return id;}
    public String getName() {
        return name;
    }
    public int getHeight() {
        return height;
    }
    public Country getCountry() {
        return country;
    }
    public Club getClub() {
        return club;
    }
    public int getOverall() {
        return overall;
    }
    public List<String> getPositions() {
        return Arrays.asList(positions.replaceAll("\"", "").split(","));
    }
    //Setter
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setCountry(Country country) { this.country = country; }
    public void setClub(Club club) {
        this.club = club;
    }
    public void setOverall(int overall) {
        this.overall = overall;
    }
    public void setPositions(String positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%d,%s,%s,%d,\"%s\"", id, name, height,club.getName(), country.getName(), overall, positions.replaceAll("\\[|\\]", ""));
    }
}
