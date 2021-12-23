package File.Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
public class BufferedFileNIOTest{
        public static void main(String[] args){
                Path src= Paths.get("", "src", "main", "java", "BufferedFileNIOTest.java");
                Path dst = Paths.get("", "BufferedFileNIOTest.java");
                Charset charset = Charset.forName("UTF-8");

                try(BufferedReader br = Files.newBufferedReader(src,charset);
                    BufferedWriter bw = Files.newBufferedWriter(dst, charset);
                ){
                        String line;
                        while((line = br.readLine()) != null){
                                bw.write(line, 0, line.length());
                                bw.newLine();
                        }
                }
                catch (IOException e){
                        System.err.println(e);
                }
        }

}

