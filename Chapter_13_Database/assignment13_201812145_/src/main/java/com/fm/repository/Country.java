package com.fm.repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="COUNTRY")
public class Country {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private int id;
    @Column(name="COUNTRY_NAME")
    private String name;
    @OneToMany(mappedBy = "country")
    private List<Player> players = new ArrayList<>();
    public Country() { }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<Player> getPlayers() { return players; }

    public void setPlayers(List<Player> players) { this.players = players; }
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}