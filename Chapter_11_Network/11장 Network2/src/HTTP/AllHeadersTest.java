package HTTP;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AllHeadersTest {
    public static void main(String[] args){
        try{
            URL url = new URL("https://www.google.com");
            URLConnection conn = url.openConnection();
            for(int i=0; ; i++){
                String headerKey = conn.getHeaderFieldKey(i);
                String headerField = conn.getHeaderField(i);
                if(headerField ==null)
                    break;
                System.out.printf("%s=%s\n",headerKey,headerField);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
