package IOStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Print_Stream {
    public static void main(String[] args){
        FileOutputStream fos = null;
        PrintStream ps =null;

        try{
            ps = new PrintStream(new FileOutputStream("standard.txt"));
            System.setOut(ps);
            System.out.println("Hello World!");
            ps.close();
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
        }
        finally {
            if(ps!=null)
                ps.close();
        }
    }
}
