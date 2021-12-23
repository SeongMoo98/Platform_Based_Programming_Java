package IOStream;

import java.io.*;
import java.nio.Buffer;

public class Character_Stream {
    //IOException을 catch 해야한다
    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            outStream = new PrintWriter(new FileWriter("characteroutput.txt"));

            String I;
            while ((I = inputStream.readLine()) != null) {
                outStream.println(I);
            }
        }
        finally{
            if(inputStream != null)
                inputStream.close();
            if(outStream != null)
                outStream.close();
        }


    }
}
