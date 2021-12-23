package HTTP.HttpServer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class HttpServerTest {
    public static void main(String[] args) throws IOException {
        //$> curl http://127.0.0.1:8080/api/hello
        //Server를 실행시키고 저 Address로 가면 Hello World가 나와있다
        //==>Server구축
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/api/hello", new MyHttpHandler());
        server.setExecutor(null); // creates a default executor
        server.start();

    }
}

/*
* createContext(URI, HttpHandler)
* A HttpContext represents a mapping from a URI path to a exchange handler
* on this HttpServer
* path에 대해 server가 수신하는 모든 request는 handler객체를 호출함으로써 처리된다
* Context는 경로로 식별되고, 나중에 removeContext를 사용해 서버에서 제거
*/



/*
* setExecutor(Executor)
* Server의 Executor 객체를 set
* start를 실행하기전 Executor를 설정해야함
* 모든 HttpRequest는 Executor에게 주어진 Task에서 처리됨
* setExecutor를 호출하지않거나 null을 넣고 start()를 호출하면
* default implementation이 사용됨
 */


