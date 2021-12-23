package MutilThreadedHttpServer.MultiThreaded_SocketExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//Client 단순히 Server와 연결
public class Client1 {
    public static void main(String[] args){
        try (Socket socket = new Socket("localhost",1234)){

            //Writing to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            //Reading from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            String line = null;

            while(!"exit".equalsIgnoreCase(line)){
                //reading from user
                line=scanner.nextLine();

                //sending the user input to server
                out.println(line);
                out.flush();

                //displaying server response
                System.out.println("Server replied : "+in.readLine());
            }
            scanner.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
