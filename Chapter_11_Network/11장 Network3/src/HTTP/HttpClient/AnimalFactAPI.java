package HTTP.HttpClient;



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;
import com.google.gson.*;

public class AnimalFactAPI {
    private static final String baseURL = "https://cat-fact.herokuapp.com";
    private static final Gson gson = new Gson();
    //HttpClient 생성
//    private static final HttpClient client = HttpClient.newBuilder()
//            .version(HttpClient.Version.HTTP_1_1)
//            .followRedirects(HttpClient.Redirect.NORMAL)
//            .build();
//    //Default setting
        private static final HttpClient client = HttpClient.newHttpClient();

    public static Optional<Fact> getRandomFact(String animal_type, int amount){
        String path ="/facts/random?";
        QueryString qs = new QueryString();
        qs.add("animal_type",animal_type); //animal_type&
        qs.add("amount",String.valueOf(amount));
        //Request생성 ==> Server(URI)로 보내지고 ==> Server의 Response를 받아
        //==>표준화 된 방법(Json)으로 결과값을 받는 형태
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseURL+path+qs))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type","application/json")
                .GET()      //REST API
                .build();

        Optional<Fact> fact = Optional.empty();
        try {
            //Request를 Server로 보냄
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode()==200){
                //gson을 통해 Json데이터를 Fact객체로 반환
                fact = Optional.ofNullable(gson.fromJson(response.body(), Fact.class));
            }
        }
        catch (IOException e){
            System.err.println(e);
        }
        catch (InterruptedException e){
            System.err.println(e);
        }
        return fact;
    }
}
