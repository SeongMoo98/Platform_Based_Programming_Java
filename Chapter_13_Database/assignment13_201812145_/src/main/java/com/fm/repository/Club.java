package com.fm.repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CLUB")
public class Club {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private int id;
    @Column(name = "CLUB_NAME")
    private String name;
    @OneToMany(mappedBy = "club")
    private List<Player> players = new ArrayList<>();

    public Club() { }
    public int getId() { return id; }
    public String getName() { return name; }
    public List<Player> getPlayers() {
        return players;
    }

    public void setId(int id) { this.id = id; }
    public void setName(String name) {
        this.name = name;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}