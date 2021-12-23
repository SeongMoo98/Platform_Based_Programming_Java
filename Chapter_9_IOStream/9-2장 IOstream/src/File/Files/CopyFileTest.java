package File.Files;

import java.io.IOException;
import java.nio.file.*;

public class CopyFileTest {
    public static void main(String[] args){
        Path src = Paths.get("", "src", "main", "java", "CopyFileTest.java");
        Path dst = Paths.get("","CopyFileTest.java");

        CopyOption[] options = {StandardCopyOption.REPLACE_EXISTING};

        if(!Files.isDirectory(src) && Files.exists(src)){
            try{
                Files.copy(src,dst,options);

            }
            catch (FileAlreadyExistsException e) {
                System.err.println(e);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
