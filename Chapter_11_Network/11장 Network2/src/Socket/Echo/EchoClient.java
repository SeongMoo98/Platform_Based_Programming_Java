package Socket.Echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    public static void main(String[] args){
        try (
                Socket echoSocket = new Socket("localhost", 7777);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                //client의 console 입력
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                )
        {
         String userInput;
         while((userInput = stdIn.readLine()) != null){
             out.println(userInput);
             System.out.println("echo : "+in.readLine());
         }


        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
