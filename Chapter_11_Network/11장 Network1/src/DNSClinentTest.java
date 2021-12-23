import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

//Internet ProtocoL(IP) Address - //ex)172.16.254.1
public class DNSClinentTest {
    public static void main(String[] args){
        try {
            //IPv4, IPv6의 High-Level representation
            InetAddress addressss[];
            //도메인 주소에서 모든 IP Address 가져오기
            //여러개의 서버를 사용하고 있을수도 있으므로 AllByName을 쓴다
            addressss = InetAddress.getAllByName("www.google.com");
            //System.out.println(InetAddress.getByName("www.pusan.ac.kr"));
            Arrays.stream(addressss).forEach(System.out::println);
            //LocalHost - 네트워크 상에서 사용자가 현재 접속중인 컴퓨터
            System.out.println("getLocalHost() : "+InetAddress.getLocalHost());

                    InetAddress me = InetAddress.getLocalHost();
            System.out.println("getHostAddress() : "+me.getHostAddress());
            //Canonical - 표준
            System.out.println("getCanonicalHostName() : "+me.getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
