package Example;


import HTTP.HttpClient.Fact;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpClientExample {
    private static final String POSTS_API_URL ="https://jsonplaceholder.typicode.com/posts";
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept","application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();

        HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());

        //request를 통해 받은 json형태의 response(String)
        System.out.println(response.body());

        //Parse the Json to Object
        ObjectMapper objectMapper = new ObjectMapper();

        //String을 읽고 ==> Post객체로 반환
        List<Post> post = objectMapper.readValue(response.body(), new TypeReference<List<Post>>() {});
        post.forEach(System.out::println);



    }
}
