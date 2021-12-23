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
    private Long id;
    @Column(name="COUNTRY_NAME")
    private String name;
    @OneToMany(mappedBy = "country")
    private List<Player2> players =
            new ArrayList<>();
    public Country() { }
    public List<Player2> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player2> players) {
        this.players = players;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
}