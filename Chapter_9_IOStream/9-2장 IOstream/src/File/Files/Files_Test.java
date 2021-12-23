package File.Files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Files_Test {
    public static void main(String[] args){
        //경로 get
        Path path = Paths.get("","src","main","java","Files_Test.java");
        if(Files.exists(path) && !Files.notExists(path))
            System.out.println("File is existed!");
        if(Files.isDirectory(path))
            System.out.println("It is a Directory");
        if(Files.isRegularFile(path))
            System.out.println("It is a file!");
        if(Files.isReadable(path))
            System.out.println("It is readable!");
        if(Files.isWritable(path))
            System.out.println("It is writable!");


    }
}
