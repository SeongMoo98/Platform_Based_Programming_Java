package HTTP.HttpClient;

import java.util.Optional;

public class HttpClientTest {
    public static void main(String[] args){
        Optional<Fact> fact = AnimalFactAPI.getRandomFact("cat",1);
        fact.ifPresent(System.out::println);
    }
}
