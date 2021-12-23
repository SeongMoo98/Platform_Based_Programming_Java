package com.fm.repository;

import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlayerQuery {
    public static List<Player> query(List<Player> players, List<Predicate<Player>> conditions) {
        List<Player> ret_Players = new ArrayList<>();
        List<Player> temp = new ArrayList<>();
        for (Predicate<Player> p : conditions) {
            if (temp.isEmpty()) {
                temp = players.stream().filter((Player player) -> p.test(player))
                        .collect(Collectors.toList());
            }
            else {
                temp = temp.stream().filter((Player player) -> p.test(player)).collect(Collectors.toList());
            }
        }
        for (Player copy : temp) {
            ret_Players.add(copy);
        }
        return ret_Players;
    }
}
