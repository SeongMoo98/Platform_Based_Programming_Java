package MutilThreadedHttpServer.MultiThreaded_SocketExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Multi-Threaded Server
 * 둘 이상의 Thread 가 존재하는 Server
 * Client가 Request ==> Client와 Server가 통신할 수 있는 Thread 생성된다
 * 여러 Client의 Request를 동시에 accept하기 위해서 여러 Thread를 생성해야한다
 * ==> Each Request를 처리하기 위한 Thread가 생성된다
 *
 *
 * ***** 장점  *****
 * 1. Quick and Efficient : request가 많아지면 효율적이고 빠르게 response 가능
 * 2. Client의 Waiting Time이 줄어든다  : 단일 Thread는 다른 Client가 실행 중인 process가 완료될 때까지 기다려야 했지만
 *    모든 Client가 한번에 응답을 받을 수 있다. ==> 다른 process가 완료될 때까지 기다릴 필요가 없다
 * 3. Thread가 서로 독립적이다  - client가 연결되면 매번 새 Thread 생성
 * 4. 한 Thread의 문제는 다른 Thread에 영향을 주지 않는다 ==> 오류가 발생해도 다른 Thread는 중단되지 않는다
 *
 * ***** 단점 *****
 * 1. 코드가 복잡하다
 * 2. 디버깅이 어려워 오류의 원인을 찾기 힘들다*/

/*Multi Threaded Server*/
public class Server {
    public static void main(String[] args){
        ServerSocket server = null;
        try{
            //server is listening on port 1234
            server = new ServerSocket(1234);
            server.setReuseAddress(true);

            //client request
            while(true){
                //socket object to receive incoming client request
                Socket client = server.accept();

                //Displaying that new client is connected to server
                System.out.println("New Client connected "+client.getInetAddress().getHostAddress());


                //Create a new Thread object
                //This Thread will handle the client separately
                ClientHandler clientSock = new ClientHandler(client);
                new Thread(clientSock).start();


            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            PrintWriter out = null;
            BufferedReader in = null;
            try {
                //get the OutputStream of client
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                //get the InputStream of client
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String line;
                while ((line = in.readLine()) != null) {
                    //writing the received message from client
                    System.out.printf("Sent from the client %s\n", line);
                    out.println(line);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
