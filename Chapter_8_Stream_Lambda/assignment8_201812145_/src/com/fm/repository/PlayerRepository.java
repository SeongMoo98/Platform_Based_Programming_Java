package com.fm.repository;

import com.fm.unit.Player;

import java.io.File;
import java.util.function.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PlayerRepository {
    private static PlayerRepository instance = new PlayerRepository();
    private boolean loaded = false;
    private List<Player> players;

    private PlayerRepository(){}

    //Repository를 static으로 만들고 static 객체를 사용
    public static PlayerRepository getInstance(){
        return instance;
    }

    //csv 파일에서 한 줄씩 읽는다
    //==>String배열로 만든 후 Player객체를 만들고
    //List에 저장하고 List를 반환
    public List<Player> load(){
        if(!isLoaded()){
            List<Player> players= new ArrayList<>();
            String resourceFileName = Thread.currentThread()
                    .getContextClassLoader()
                    .getResource("com/fm/repository/players_20_short.csv")
                    .getPath();

            try(Scanner scanner=new Scanner(new File(resourceFileName))){
                if(scanner.hasNext())
                    scanner.nextLine();
                while(scanner.hasNext()){
                    String line = scanner.nextLine();
                    Player p = createPlayer(line.split(","));
                    players.add(p);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
            this.players=players;
        }
        loaded = true;
        return players;
    }

    //Predicate<Player>을 사용해 size > 0 즉 존재하는지 && players.size()>0 - load 된 상태
    public List<Player> query(List<Predicate<Player>> conditions){
        if (conditions.size() > 0 && players.size() > 0)
            return PlayerQuery.query(players, conditions);
        else
            return new ArrayList<Player>();
    }

    public boolean isLoaded(){
        return loaded;
    }


    //load함수에서 file로부터 만든 String배열로 Player생성
    private Player createPlayer(String[] fields){
        Player player = new Player(getId(fields), getName(fields), getHeight(fields),
                getNationality(fields), getClub(fields), getOverall(fields), getPosition(fields));
        return player;
    }

    private int getId(String[] fields){
        return Integer.parseInt(fields[Player.ID]);
    }
    private String getName(String[] fields) {
        return fields[Player.NAME];
    }
    private int getHeight(String[] fields) {
        return Integer.parseInt(fields[Player.HEIGHT]);
    }
    private String getNationality(String[] fields) {
        return fields[Player.NATIONALITY];
    }
    private String getClub(String[] fields) {
        return fields[Player.CLUB];
    }
    private int getOverall(String[] arr) {
        return Integer.parseInt(arr[Player.OVERALL]);
    }
    private List<String> getPosition(String[] fields){
        List<String> positions = new ArrayList<>();
        if(fields[Player.POSITION].startsWith("\"")){
            for(int i = Player.POSITION; i < fields.length; i++){
                positions.add(fields[i].replace("\"",""));
            }
        }
        else{
            positions.add(fields[Player.POSITION]);
        }
        return positions;
    }



}

