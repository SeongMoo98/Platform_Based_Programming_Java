package IOStream;

import java.io.*;

public class Buffered_IO_Stream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = null;
        BufferedOutputStream out = null;
        byte[] data = {1,2,3,4,5,6,7,8,9};

        FileInputStream fis = null;
        BufferedInputStream in = null;

        try{
            fos = new FileOutputStream("test.txt");
            out = new BufferedOutputStream(fos, 4); //Wrapping
            //Buffered로 File을 감싼다

            for(int i=0; i<data.length; i++)
                out.write(data[i]);

            fis = new FileInputStream("test.txt");
            in = new BufferedInputStream(fis);//Wrapping
            //Buffer로 File을 감싼다
            int b=0;
            while((b = in.read()) != -1)
                System.out.print(b);
        }
        finally {
            //if (out != null) out.close(); // fos is automatically closed.
            //if (in != null) in.close(); // fis is automatically closed.
        }
    }
}
