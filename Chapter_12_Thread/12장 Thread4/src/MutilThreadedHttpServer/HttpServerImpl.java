package MutilThreadedHttpServer;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerImpl{

    public static void main(String[] args) throws IOException{
        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
        server.createContext("/api/hello", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                OutputStream output = null;
                //HttpExchange - Response를 다룬다
                if ("GET".equals(exchange.getRequestMethod())){


                }

            }
        });

        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        server.setExecutor(executor);
        server.start();
    }
}

