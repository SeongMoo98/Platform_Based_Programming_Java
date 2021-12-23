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
    private Long id;
    @Column(name = "CLUB_NAME")
    private String name;
    @OneToMany(mappedBy = "club")
    private List<Player2> players = new ArrayList<>();

    public Club() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Player2> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player2> players) {
        this.players = players;
    }
}