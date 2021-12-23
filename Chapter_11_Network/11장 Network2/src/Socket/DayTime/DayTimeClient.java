package Socket.DayTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class DayTimeClient {
    public static void main(String[] args){
        //Creates a stream socket and connects it to the port on the host
        try (Socket socket = new Socket("time.nist.gov",13);){
            //Socket(String host, port) throws UnknownHostException, IOException
            System.out.println(socket.getInetAddress()+" "+socket.getPort());
            System.out.println(socket.getLocalAddress().getHostAddress()+" "+socket.getLocalPort());
            try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                int c;
                StringBuilder sb = new StringBuilder();
                while ((c = in.read()) != -1)
                    sb.append((char) c);
                System.out.println(sb);
            }
        }
        catch (UnknownHostException e){
            System.err.println(e);
        }
        catch (IOException e){
            System.err.println(e);
        }

    }
}
