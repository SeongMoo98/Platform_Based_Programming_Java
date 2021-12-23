package Process;
/*
 * Process를 생성해서 Main Program과 통신
 */
import java.io.File;
import java.io.InputStream;


public class ProcessBuilderTest {
    public static void main(String[] args){
        try {
//            String param = "C:"+ File.separator; //separator - "\"
//            Process proc = Runtime.getRuntime().exec("cmd /c dir " + param);
//
//            List<String> value = new ArrayList<>();
//            value.add("cmd"); value.add("/c"); value.add("dir");
//            ProcessBuilder processBuilder = new ProcessBuilder(value);
//            processBuilder.start();

            String param = "C:"+ File.separator; //separator - "\"
            Process proc = new ProcessBuilder("cmd", "/c", "dir", param).start();
            //getInputStream() - 생성된 process에서 Java Program으로 data 전송
            InputStream in = proc.getInputStream();
            //BufferedInputStream in = new BufferedInputStream(proc.getInputStream());
            byte[] buffer = new byte[1024];
            int n = -1;
            while ((n = in.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, n));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



    //ProcessBuilder(List<T>command),ProcessBuilder(String command)
    //OS 명령어를 리스트나 String으로 받아 명령수행을 위한 process 생성
    //start()로 실행
    //Process proc = new ProcessBuilder("cmd", "/c", "dir", param).start();
    //cmd에서 dir한 명령어를 실행한 결과를 가져온다

}
