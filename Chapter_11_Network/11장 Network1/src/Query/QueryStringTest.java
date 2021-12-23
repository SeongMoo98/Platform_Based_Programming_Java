package Query;

public class QueryStringTest {
    public static void main(String[] args) {
        QueryString qs = new QueryString();
        qs.add("query", "자바");
        //qs(Query)를 Encoding해서 사용한다
        String url = "https://search.naver.com/search.naver?"+qs;
        System.out.println(url);
    }
}
