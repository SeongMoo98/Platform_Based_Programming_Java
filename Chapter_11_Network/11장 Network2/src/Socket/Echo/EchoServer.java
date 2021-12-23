package Socket.Echo;

import com.sun.source.tree.Scope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
    public static void main(String[] args){
        //exception that should probably shut down the server
        try (ServerSocket serverSocket = new ServerSocket(7777)){
            //iterator server
            while(true){
                //Exception within the scope of a particular connection should close
                try (Socket clientSocket = serverSocket.accept();){
                    //print(), println()을 사용하는 Writer의 하위 클래스
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String inputLine;
                    while((inputLine = in.readLine())!=null){
                        out.println(inputLine);
                    }
                }
                catch (IOException e){
                    System.err.println(e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
