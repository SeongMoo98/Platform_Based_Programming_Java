package com.fm.server.model;

import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class PlayerQuery {

    public static List<Player> query(List<Player> players, List<Predicate<Player>> conditions) {
        List<Player> ret_Players = new ArrayList<>();
        List<Player> temp = new ArrayList<>();
        //Condition을 lambda식으로 filter
        for (Predicate<Player> p : conditions) {
            if (temp.isEmpty()) {
                temp = players.stream().filter((Player player) -> p.test(player))
                        .collect(Collectors.toList());
            }
            //Condition이 2개이상인 stream이 존재하므로 다시 filter
            else {
                temp = temp.stream().filter((Player player) -> p.test(player)).collect(Collectors.toList());
            }
        }
        //filtering한 List를 copy
        for (Player copy : temp) {
            ret_Players.add(copy);
        }
        return ret_Players;
    }
}
