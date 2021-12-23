package Socket.DayTime;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DayTimeServer {
    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(1300)){
            while(true){
                //Socket을 만들고 Listening중
                try (Socket socket = serverSocket.accept();){
                    //Writer - BufferedWriter, OutputStreamWriter,FileWriter등등 의 상위 클래스
                    Writer out = new OutputStreamWriter(socket.getOutputStream());
                    Date now = new Date();
                    out.write(now+"\r\n");
                    out.flush();
                }
                catch (IOException e){
                    System.err.println(e);
                }
            }
        }
        catch (IOException e){
            System.err.println(e);
        }

    }
}
