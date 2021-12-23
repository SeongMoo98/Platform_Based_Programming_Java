package RESTfulAPI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;

//curl -X POST --location "http://localhost:8080/api/v1/users" ^
//        -H "Content-Type: application/json" ^
//        -d "{ \"name\": \"Lee\", \"age\": 22 }"

public class HttpServerPostTest {
    public static void main(String[] args) {
        HttpServer server;
        try {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
            HttpHandler handler = new HttpHandlerForUser();
            //"http://localhost:8080/api/v1/hello"
            //HttpHandler의 handle(HttpExchange exchange) { }
            //Lambda식으로 FunctionalInterface : handle(){ statement } statement를 적음
            server.createContext("/api/v1/hello", (exchange) -> {
                OutputStream output = exchange.getResponseBody();
                if ("GET".equals(exchange.getRequestMethod())){
                    String responseBody = "Hello, World!\n";
                    exchange.getResponseHeaders().add("Content-Type", "text/html; UTF-8");
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK,
                            responseBody.getBytes("UTF-8").length);
                    output.write(responseBody.getBytes("UTF-8")); output.flush();
                } else {
                    exchange.getResponseHeaders().add("Content-Type", "text/html; UTF-8");
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_METHOD,
                            Constants.NOT_ALLOWED.getBytes("UTF-8").length);
                    output.write(Constants.NOT_ALLOWED.getBytes("UTF-8")); output.flush();
                }
                exchange.close();
            });

            //"http://localhost:8080/api/v1/users"
            //HttpHandlerForUsers로 정dmlgks Handler
            server.createContext("/api/v1/users", handler);
            server.setExecutor(null); // creates a default executor
            server.start();

        } catch (IOException ex) { System.err.println(ex); }
    }
}



