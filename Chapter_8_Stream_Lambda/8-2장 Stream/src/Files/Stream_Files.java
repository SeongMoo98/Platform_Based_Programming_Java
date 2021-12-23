package Files;


import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.IOException;

public class Stream_Files {
    public static void main(String[] args){
        //Stream<String> Files.lines(Path path)

        try(Stream<String> lines =
                Files.lines(Paths.get("data.txt"), Charset.defaultCharset()) ){
            lines.forEach(System.out::print);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }


}
