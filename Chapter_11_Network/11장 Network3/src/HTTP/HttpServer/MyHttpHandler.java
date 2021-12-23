package HTTP.HttpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class MyHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String responseBody = "Hello, World!\n";
        exchange.getResponseHeaders().add("Content-Type", "text/html; UTF-8");
        exchange.sendResponseHeaders(
                HttpURLConnection.HTTP_OK, responseBody.getBytes("UTF-8").length);
        OutputStream output = exchange.getResponseBody();
        output.write(responseBody.getBytes("UTF-8"));
        output.flush(); exchange.close(); // close the request InputStream and the response OutputStream


        //HttpExchange
        //수신된 HttpRequest와 하나의 Exchange에서 생성 될 Response를 캡슐화
        //Client의 Request를 검사하고
        //Response를 작성 및 전송하는 Method를 제공
    }
}