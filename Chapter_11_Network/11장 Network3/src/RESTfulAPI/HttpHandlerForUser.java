package RESTfulAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;


public class HttpHandlerForUser implements HttpHandler {
    //Json을 객체로 readValue
    ObjectMapper objectMapper = new ObjectMapper(); // jackson library
    List<User> users = new ArrayList<>(); // replace it with your repository
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        OutputStream output = exchange.getResponseBody();
        //HttpExchange - Response를 다룬다
        if ("GET".equals(exchange.getRequestMethod())){
            //writeValueAsString - 객체를 String으로 돌려준다
            //Client에서 response의 Body(String) 를 Json을 통해 객체로 변환한다
            String responseBody = objectMapper.writeValueAsString(users);
            //ResponseHeader - Response의 추가정보
            exchange.getResponseHeaders().add("Content-Type", "application/json; UTF-8");
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, responseBody.getBytes("UTF-8").length);
            output.write(responseBody.getBytes("UTF-8"));
            output.flush();
        }
        else if ("POST".equals(exchange.getRequestMethod())){
            //String으로 받은 RequestBody를 User객체로 반환
            User newUser = objectMapper.readValue(exchange.getRequestBody(), User.class);
            users.add(newUser); // save a new user to the repository
            String responseBody = objectMapper.writeValueAsString(newUser);
            exchange.getResponseHeaders().add("Content-Type", "application/json; UTF-8");
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, responseBody.getBytes("UTF-8").length);
            output.write(responseBody.getBytes("UTF-8"));
            output.flush();
        }
        else {
            exchange.getResponseHeaders().add("Content-Type", "text/html; UTF-8");
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_METHOD,
                    Constants.NOT_ALLOWED.getBytes("UTF-8").length);
            output.write(Constants.NOT_ALLOWED.getBytes("UTF-8"));
            output.flush();
        }
        exchange.close();
    }

}
