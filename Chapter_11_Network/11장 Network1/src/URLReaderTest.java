import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLReaderTest {
    public static void main(String[] args){
        URL url =null;
        try {
            url = new URL("https://www.pusan.ac.kr");
            //URL contents를 Stream을 이용하여 Read
            try(BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))){
//                int c;
//                while((c = in.read()) != -1){
//                    System.out.print((char) c);
//                }

                String r;
                while((r = in.readLine()) != null){
                    System.out.println(r);
                }
            }
            catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (MalformedURLException e){
            System.err.println(e);
        }
        catch (RuntimeException e){
            System.err.println(e);
        }

    }
}
