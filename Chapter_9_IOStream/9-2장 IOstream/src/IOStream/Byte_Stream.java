package IOStream;

import java.io.*;
import java.nio.file.Files;

//1byte의 데이터를 입출력하는 Stream
public class Byte_Stream {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;
            //1Byte 형태로 읽고 쓴다
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
        finally {
            if(in != null)
                in.close();
            if(out != null)
                out.close();
        }
    }
}
