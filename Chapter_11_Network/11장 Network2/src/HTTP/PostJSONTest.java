package HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class PostJSONTest {

    public static void main (String []args) throws IOException {
        //Change the URL with any other publicly accessible POST resource, which accepts JSON request body
        URL url = new URL ("https://reqres.in/api/users");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();

        conn.setRequestMethod("POST");

        //to send the request content in JSON form
        conn.setRequestProperty("Content-Type", "application/json; urf-8");

        //to read the response in the desired format
        conn.setRequestProperty("Accept", "application/json");

        //to send request content
        conn.setDoOutput(true);

        //JSON String need to be constructed for the specific resource.
        //We may construct complex JSON using any third-party JSON libraries such as jackson or org.json
        String jsonInputString = "{\"name\": \"Upendra\", \"job\": \"Programmer\"}";

        try(OutputStream os = conn.getOutputStream()){
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int code = conn.getResponseCode();
        System.out.println(code);

        try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))){
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }

}
