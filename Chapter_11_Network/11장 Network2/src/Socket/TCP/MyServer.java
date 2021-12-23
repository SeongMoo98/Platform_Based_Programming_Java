package Socket.TCP;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args){
        try{
            //port number로 ServerSocket을 생성하고
            //Socket으로 accept
            //Socket을 생성하고 Listening
            ServerSocket ss =new ServerSocket(6666);
            Socket s = ss.accept(); // connection을 형성
            //socket(client)에서 InputStream을 받아서 DataInputStream을 형성
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str =(String) dis.readUTF();
            System.out.println("Message = "+str);
            ss.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
