package File;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Path_Test {
    public static void main(String[] args){
        //Path를 지정
        Path path = Paths.get("C:\\home\\joe\\foo");

        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());
        //File이 존재하지 않아도 Path를 사용할 수 있다
        System.out.format("File exists: %s%n", Files.exists(path));
    }
}
