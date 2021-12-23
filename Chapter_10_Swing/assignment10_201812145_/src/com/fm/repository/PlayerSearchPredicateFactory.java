package com.fm.repository;

import com.fm.view.SearchCondition;
import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.List;

public class PlayerSearchPredicateFactory{
    public static List<Predicate<Player>> makeConditions(List<SearchCondition> searchConditions){
        List<Predicate<Player>> list= new ArrayList<>();

        for(SearchCondition s : searchConditions){
            String search_field = s.getField();
            String search_condition = s.getCondition();
            switch (search_field) {
                case "name":
                    Predicate<Player> p1 = new Predicate<Player>() {
                        @Override
                        public boolean test(Player player) {
                            return player.getName().contains(search_condition);
                        }
                    };
                    list.add(p1);
                    break;
                case "club":
                    Predicate<Player> p2 = new Predicate<Player>() {
                        @Override
                        public boolean test(Player player) {
                            return player.getClub().contains(search_condition);
                        }
                    };
                    list.add(p2);
                    break;
                case "position":
                    Predicate<Player> p3 = new Predicate<Player>() {
                        @Override
                        public boolean test(Player player) {
                            return player.getPositions().contains(search_condition);
                        }
                    };
                    list.add(p3);
                    break;
                case "nationality":
                    Predicate<Player> p4 = new Predicate<Player>() {
                        @Override
                        public boolean test(Player player) {
                            return player.getNationality().contains(search_condition);
                        }
                    };
                    list.add(p4);
                    break;
            }
        }
        return list;
    }

}
