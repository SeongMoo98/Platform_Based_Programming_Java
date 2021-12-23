package com.fm.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fm.search.SearchField;
import com.fm.search.SearchCondition;
import com.fm.server.model.PlayerRepository;
import com.fm.server.model.PlayerSearchPredicateFactory;
import com.fm.unit.Player;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class PlayerHandler implements HttpHandler {
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final Charset CHAR_SET = StandardCharsets.UTF_8;
    private static final int STATUS_OK = 200;
    private static final String GET = "GET";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Headers headers = exchange.getResponseHeaders();
        //GET, POST, DELETE, PUT
        String requestMethod = exchange.getRequestMethod().toUpperCase();

        switch (requestMethod) {
            case GET:
                URI requestURI = exchange.getRequestURI();
                System.out.println("request received : " + requestURI);

                Map<String, List<String>> requestParameters = getRequestParameters(requestURI);

                String responseBody = toResponseBody(PlayerRepository.getInstance().query(
                        PlayerSearchPredicateFactory.makeConditions(getSearchCondition(requestParameters))));
                headers.set(HEADER_CONTENT_TYPE, String.format("application/json; charset=%s", CHAR_SET));
                byte[] rawResponseBody = responseBody.getBytes(CHAR_SET);
                exchange.sendResponseHeaders(STATUS_OK, rawResponseBody.length);
                exchange.getResponseBody().write(rawResponseBody);
                break;
            default:
                break;
        }
    }
    //클라이언트에서 조회를 요청하면 서버에서 선수 정보를 검색하여 클라이언트에 반환합니다.
    private List<SearchCondition> getSearchCondition(Map<String, List<String>> requestParameters) {
        List<SearchCondition> newInstance = new ArrayList<>();
        // NAME("name"), CLUB("club"), POSITION("position"), NATIONALITY("nationality"), INVALID("invalid");
        for (String field : requestParameters.keySet()) {
            for (String condition : requestParameters.get(field)) {
                SearchField playerField = SearchField.fromString(field);
                if (playerField != SearchField.INVALID)
                    newInstance.add(new SearchCondition(playerField, condition));
            }
        }
        System.out.println("SearchCondition: " + newInstance);
        return newInstance;
    }

    //List<Player> (Request에 따라 찾은 데이터 리스트)를 String으로
    private String toResponseBody(List<Player> players) {
        ObjectMapper obm = new ObjectMapper();
        String responseBody = players.toString();
        try {
            responseBody = obm.writeValueAsString(players);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("responseBody: " + responseBody);
        return responseBody;
    }

    //URL을 http://localhost:9000/players?name=Son&club=Tottenham 이런식으로 &으로 나타내서 Request
    //& 으로 split ==> = 으로 split ==> hostName, port, path를 가지게 됨
    //Key(String) - name, club등등 Search Field
    //Value(List<String>)- Son,Tottenham 등등 Search Condition
    private Map<String, List<String>> getRequestParameters(final URI requestUri) {
        Map<String, List<String>> requestParameters = new LinkedHashMap<>();
        String requestQuery = requestUri.getRawQuery();
        if (requestQuery != null) {
            final String[] rawRequestParameters = requestQuery.split("[&;]", -1);
            for (String rawRequestParameter : rawRequestParameters) {
                String[] requestParameter = rawRequestParameter.split("=", 2);
                if (requestParameter.length > 1) {
                    String requestParameterName = decodeUrlComponent(requestParameter[0]);
                    requestParameters.putIfAbsent(requestParameterName, new ArrayList<>());
                    String requestParameterValue = decodeUrlComponent(requestParameter[1]);
                    requestParameters.get(requestParameterName).add(requestParameterValue);
                }
            }
        }
        System.out.println("requestParameters: " + requestParameters);
        return requestParameters;
    }

    //Request에서 Encoding된 값을 Decode
    private String decodeUrlComponent(final String urlComponent) {
        try {
            return URLDecoder.decode(urlComponent, CHAR_SET.name());
        } catch (UnsupportedEncodingException ex) {
            throw new InternalError(ex);
        }
    }
}
