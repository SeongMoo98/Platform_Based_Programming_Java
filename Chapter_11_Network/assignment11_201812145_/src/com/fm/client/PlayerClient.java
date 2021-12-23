package com.fm.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fm.unit.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;

public class PlayerClient {
    private static final String baseURL = "http://localhost:9000/players?";
    public static void main(String[] args) throws IOException, InterruptedException {
        String str="";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String InputStr;
        while((InputStr = in.readLine()) != null) {
            String[] tempArr = InputStr.split(" ");
            for(String temp : tempArr){
                if(temp.toUpperCase().equals("NAME")||
                        temp.toUpperCase().equals("CLUB")||
                        temp.toUpperCase().equals("NATIONALITY")||
                        temp.toUpperCase().equals("POSITION")){
                    str+=temp+"=";
                }
                else{
                    str+=temp+"&";
                }
            }
        }
        //client생성
//        HttpClient client = HttpClient.newBuilder()
//            .version(HttpClient.Version.HTTP_1_1)
//            .followRedirects(HttpClient.Redirect.NORMAL)
//            .build();
        HttpClient client = HttpClient.newHttpClient();

        //URI를 통해 Request생성
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseURL + str))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type","application/json")
                .GET()
                .build();

        //client로 request를 보내 Body를 reponse로 받는다
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //Json을 통해 Player객체로 반환 받음
        String result = response.body();
        ObjectMapper mapper = new ObjectMapper();
        CollectionType playerListType = mapper.getTypeFactory().constructCollectionType(List.class, Player.class);
        List<Player> players = mapper.readValue(result, playerListType);
        players.forEach(System.out::println);
    }
}

