package Example.Socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {
    public static void main(String[] args){
        try{
            String serverIp = "127.0.0.1";
            System.out.println("IP : "+serverIp+"연결 중입니다.");

            //Socket생성
            Socket socket = new Socket(serverIp,7777);

            //IuputStream
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            //Server데이터 전송 - 양방향
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF("Test Message too");

            System.out.println("Message : "+dis.readUTF());

            dis.close();
            dos.close();
            socket.close();
            System.out.println("연결종료");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
