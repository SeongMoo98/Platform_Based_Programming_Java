import java.net.URL;

public class ParseURLTest {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://www.google.com/search?q=java");

        System.out.println("protocol = : "+ url.getProtocol());
        System.out.println("authority = : "+ url.getAuthority());
        System.out.println("host = : "+ url.getHost());
        System.out.println("port = : "+ url.getPort());
        System.out.println("default port = : "+ url.getDefaultPort());
        System.out.println("path = : "+ url.getPath());
        System.out.println("query = : "+ url.getQuery());
        System.out.println("filename = : "+ url.getFile());
        System.out.println("ref = : "+ url.getRef());



    }
}
