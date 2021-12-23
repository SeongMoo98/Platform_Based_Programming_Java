import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

//URL은 String으로 생성하는게 readalbe하고 좋다
//근데 relative URL, variable components(protocol, host..)로도 생성가능
public class CreatingURLTest {
    public static void main(String[] args) {
        try {
            //String
            URL urlFromString = new URL("https://docs.oracle.com/javase/tutorial/networking/urls/creatingUrls.html");

            //relative URL
            URL urlBase = new URL("https://docs.oracle.com/javase/tutorial/");
            URL urlWithRelative = new URL(urlBase,"networking/urls/creatingUrls.html");

            //여러 components들로 생성
            URL urlFromSpec = new URL("https", "docs.oracle.com", "/javase/tutorial/networking/urls/creatingUrls.html");
            URL urlFromSpec2 = new URL("https", "docs.oracle.com", 80,"/javase/tutorial/networking/urls/creatingUrls.html");
        }
        catch (MalformedURLException e) {
            System.err.println(e);

        }
    }
}
