package com.fm.repository;

import com.fm.game.SearchCondition;
import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.List;

public class PlayerSearchPredicateFactory{

    //이름, 클럽, 포지션, 국적별로 Predicate (인자를 하나 받아 boolean 을 반환하는 람다를 작성해 보세요!) 생성하여 반환합니다.
    //List<SearchCondition>을 받아 Predicate작성
    //Predicate<T> - boolean test(T t)
    //parameter로 T를 받아 test Method의 statement에 따라 boolean return
    public static List<Predicate<Player>> makeConditions(List<SearchCondition> searchConditions){
        List<Predicate<Player>> list= new ArrayList<>();

        for(SearchCondition s : searchConditions){
            String search_field = s.getField();
            String search_condition = s.getCondition();
            //SearchCondition의 String으로 Predicate<Player>생성
            switch (search_field) {
                case "name":
                    Predicate<Player> condition1 = new Predicate<Player>() {
                        @Override
                        public boolean test(Player player) {
                            return player.getName().contains(search_condition);
                        }
                    };
                    list.add(condition1);
                    break;
                case "club":
                    Predicate<Player> condition2 = new Predicate<Player>() {
                        @Override
                        public boolean test(Player player) {
                            return player.getClub().contains(search_condition);
                        }
                    };
                    list.add(condition2);
                    break;
                case "position":
                    Predicate<Player> condition3 = new Predicate<Player>() {
                        @Override
                        public boolean test(Player player) {
                            return player.getPositions().contains(search_condition);
                        }
                    };
                    list.add(condition3);
                    break;
                case "nationality":
                    Predicate<Player> condition4 = new Predicate<Player>() {
                        @Override
                        public boolean test(Player player) {
                            return player.getNationality().contains(search_condition);
                        }
                    };
                    list.add(condition4);
                    break;
            }
        }
        return list;
    }

}
