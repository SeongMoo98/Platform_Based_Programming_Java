package File;

import java.io.File;

public class File_List {
    public static void main(String[] args){
        //String currntDir = System.getProperty("user.dir"); //Working Directory
        //File f = new File(currntDir);

        File f = new File(System.getProperty("user.dir"));


        if(!f.exists() || !f.isDirectory()){
            System.out.println("Invalid Directory");
            System.exit(0);
        }

        File[] files = f.listFiles();

        for(int i=0; i< files.length; i++){
            String fileName = files[i].getName();
            System.out.println(files[i].isDirectory() ? "["+fileName+"]" : fileName);
        }
    }
}
