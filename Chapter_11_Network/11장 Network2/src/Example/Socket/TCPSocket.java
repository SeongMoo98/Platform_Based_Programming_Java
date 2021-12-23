package Example.Socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

//Socket은 Client와 Server에서 양방향으로 IO을 할 수 있다
public class TCPSocket {

    public static void main(String[] args){
        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket(7777);
            System.out.println("Listening");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            try{
                System.out.println(getTime()+"연결 대기중");

                Socket socket = serverSocket.accept();
                System.out.println(getTime()+"연결 요청 : "+socket.getInetAddress());

                //Output Stream
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);
                dos.writeUTF("Test Message");
                System.out.println(getTime()+"데이터 전송");

                //InputStream
                InputStream in = socket.getInputStream();
                DataInputStream dis =new DataInputStream(in);
                System.out.println("Message : "+dis.readUTF());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}
