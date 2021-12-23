package com.fm.repository;

import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class PlayerQuery {

    //파일에서 load 된 players
    //입력받은 conditions
    public static List<Player> query(List<Player> players, List<Predicate<Player>> conditions) {
//        List<Player> ret_Players = new ArrayList<>();
//        List<Player> temp = new ArrayList<>();
//        //Condition을 lambda식으로 filter
//        for (Predicate<Player> player : conditions) {
//            if (temp.isEmpty()) {
//                temp = players.stream().filter(p -> player.test(p))
//                        .collect(Collectors.toList());
//            }
//            //Condition이 2개이상인 stream이 존재하므로 다시 filter
//            else {
//                temp = temp.stream().filter(p -> player.test(p)).collect(Collectors.toList());
//            }
//        }
//        //filtering한 List를 copy
//        for (Player copy : temp) {
//            ret_Players.add(copy);
//        }
//        return temp;

        List<Player> ret_Players = new ArrayList<>();
        //Condition을 lambda식으로 filter
        for (Predicate<Player> player : conditions) {
            if (ret_Players.isEmpty()) {
                ret_Players = players.stream().filter(p -> player.test(p))
                        .collect(Collectors.toList());
            }
            //Condition이 2개이상인 stream이 존재하므로 다시 filter
            else {
                ret_Players = ret_Players.stream().filter(p -> player.test(p)).collect(Collectors.toList());
            }
        }
        return ret_Players;
    }
}
