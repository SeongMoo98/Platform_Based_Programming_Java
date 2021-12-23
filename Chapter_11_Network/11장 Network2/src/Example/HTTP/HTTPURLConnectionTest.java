package Example.HTTP;

import javax.swing.plaf.ViewportUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//Http는 단방향 통신
public class HTTPURLConnectionTest {
    public static void main(String[] args){
        try{
            URL url = new URL("http://www.google.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

            String line;
            while((line = in.readLine())!=null){
                //response를 차례대로 출력
                System.out.println(line+"\n");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
