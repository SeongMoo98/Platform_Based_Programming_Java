package com.fm.repository;

import com.fm.unit.Player;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FileRepository implements IRepository{
    private List<Player> players=new ArrayList<>();
    public static final String[] FILE_HEADER = { "sofifa_id", "short_name", "height_cm", "nationality", "club", "overall", "player_positions", "\n" };
    private static FileRepository instance = new FileRepository();
    public final String FILENAME = Thread.currentThread().getContextClassLoader().getResource("com/fm/repository/players_20_short.csv").getFile();
    private boolean loaded = false;

    private FileRepository(){ load(); }
    public static FileRepository getInstance() { return instance; }
    //load Method에서 사용 - File에서 읽은 데이터들로 String[]을 만들고 createAndLoad
    private Player create(String[] fields) { return PlayerFactory.createPlayers(fields); }



    //your code here
    @Override
    public int count(){ return players.size(); }

    //File에서 읽은 데이터를 List에 저장
    private void load() {
        Path path = Paths.get("","src/com/fm/repository/players_20_short.csv");
        String readLine=null;
        //Auto close 해준다
        try(BufferedReader br = Files.newBufferedReader(path)){
            readLine=br.readLine();
            while((readLine = br.readLine())!=null){
                players.add(PlayerFactory.createPlayers(readLine.split(",")));
            }
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


//        BufferedReader br = null;
//        String readLine;
//        try {
//            br = Files.newBufferedReader(path);
//            readLine = br.readLine(); //첫줄 Header
//            while((readLine = br.readLine()) != null){
//                String[] strArr=readLine.split(",");  //split -> "158023,L.Messi,170, Argentina, FC Barcelona, 94," "RW,CF,ST"
//                Player player=create(strArr);
//                players.add(player);
//            }
//        }
//        catch (FileNotFoundException e){
//            System.err.println(e);
//        }
//        catch (IOException e){
//            System.err.println(e);
//        }
//        finally{
//            if(br!=null){
//                try {
//                    br.close();
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }





    }

    @Override
    public void save(Player t){
        players.add(t);
        Path path = Paths.get("","src/com/fm/repository/players_20_short.csv");
        //BufferedWriter bw = null;
        try (BufferedWriter bw = Files.newBufferedWriter(path,StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
            //bw Option으로 Append를 준다 Write를 하면 파일의 내용이 삭제됨
            //bw = Files.newBufferedWriter(path,StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            bw.write(Integer.toString(t.getId())+",");
            bw.write(t.getName()+",");
            bw.write(Integer.toString(t.getHeight())+",");
            bw.write(t.getNationality()+",");
            bw.write(t.getClub()+",");
            bw.write(Integer.toString(t.getOverall())+",");
            String temp="";
            for(int i=0; i<t.getPositions().size(); i++){
                if(i==t.getPositions().size()-1){
                    temp=t.getPositions().get(i);
                    bw.write(temp);
                }
                else{
                    temp=t.getPositions().get(i)+",";
                    bw.write(temp);
                }
            }
            bw.newLine();
        }
        catch (FileNotFoundException e){
            System.err.println(e);
        }
        catch (IOException e) {
            System.err.println(e);
        }
//        finally {
//            if(bw!=null){
//                try {
//                    bw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
    @Override
    public void delete(Player t){

        Path readPath = Paths.get("","src/com/fm/repository/players_20_short.csv");
        Path delPath = Paths.get("","src/com/fm/repository/temp.csv"); //temp.csv에 write하고 copy해서 다시 기록

        //newBufferdReader,Writer의 Option을 적어줘야함
        try(BufferedReader br = Files.newBufferedReader(readPath, StandardCharsets.UTF_8);
            BufferedWriter bw = Files.newBufferedWriter(delPath, StandardCharsets.UTF_8,StandardOpenOption.CREATE);) {
            //첫줄
            String readLine = br.readLine();
            bw.write(readLine);
            bw.newLine();
            while((readLine = br.readLine())!=null){
                String[] temp=readLine.split(",");
                int Id=Integer.parseInt(temp[0]);
                if(t.getId()==Id) {
                    deleteById(Id);
                }
                else {
                    bw.write(readLine);
                    bw.newLine();
                }
            }
            //Files.move(String sourceFile, String destFile, Option)
            //sourceFile을 destFile에 대한 새경로로 옮김
            //StandardCopyOption.REPLACE_EXISTING - dest에 파일이 존재하면 덮어씌운다
            Files.move(delPath,readPath,StandardCopyOption.REPLACE_EXISTING);
        }
        catch (FileNotFoundException e){
            System.err.println(e);
        }
        catch (FileAlreadyExistsException e) {
            System.err.println(e);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteById(int id){
        List<Player> list = players.stream().filter(p->p.getId()==id).collect(Collectors.toList());
        for(Player p : list){
            players.remove(p);
        }
    }
    @Override
    public boolean existsById(int id){
        return players.stream().anyMatch(p->p.getId()==id);
    }
    @Override
    public Iterable<Player> findAll(){
        return players;
    }
    @Override
    public Optional<Player> findById(int id){
        return players.stream().filter(p->p.getId()==id).findAny();
    }
    @Override
    public List<Player> findByConditions(List<Predicate<Player>> conditions){
        return PlayerQuery.query(players, conditions);
    }
}
