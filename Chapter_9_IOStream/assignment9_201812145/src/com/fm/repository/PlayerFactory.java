package com.fm.repository;

import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerFactory {
    //main에서 사용
    //create: ......
    //입력받은 fields로 Player생성하고
    //Main에서 등록
    public static Player createPlayersWithoutID(String[] fields){
        //Position이 하나이거나 여러개
        List<String> temp = new ArrayList<>();
        for(int i=5; i<fields.length; i++){
            temp.add(fields[i].replace("\"",""));
        }
        return  new Player(fields[0], Integer.parseInt(fields[1]), fields[2], fields[3], Integer.parseInt(fields[4]), temp);

        /*
        int len=fields.length;
        if(len==6){
            return new Player(fields[0], Integer.parseInt(fields[1]), fields[2], fields[3], Integer.parseInt(fields[4]), Collections.singletonList(fields[5]));
        }
        else{
            List<String> temp = new ArrayList<>();
            for(int i=5; i<len; i++){
                    temp.add(fields[i]);
            }
            return new Player(fields[0], Integer.parseInt(fields[1]), fields[2], fields[3], Integer.parseInt(fields[4]), temp);
        }
         */

    }

    //FileRepository에서 csv파일에서 읽은 후 fields로 parameter를 줌
    public static Player createPlayers(String[] fields){

        List<String> temp = new ArrayList<>();
        for(int i=6; i<fields.length; i++){
            temp.add(fields[i].replace("\"",""));
        }
        return new Player(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), fields[3], fields[4],Integer.parseInt(fields[5]), temp);

        /*
        int len = fields.length;
        return  new Player(fields[0], Integer.parseInt(fields[1]), fields[2], fields[3], Integer.parseInt(fields[4]), temp);
        if(len==7){
            return new Player(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), fields[3], fields[4],Integer.parseInt(fields[5]), Collections.singletonList(fields[6]));
        }
        else{
            List<String> temp = new ArrayList<>();
            for(int i=6; i<len; i++){
                temp.add(fields[i]);
            }
            return new Player(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), fields[3], fields[4],Integer.parseInt(fields[5]), temp);
        }
        */
    }
}
