package de.coco.file.sorting.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class InputUtils {

    public static ArrayList<File> createFiles(List<String> pfade){
        ArrayList<File> files= new ArrayList<File>();

            for (String pfad:pfade) {
                try {
                    File neu = new File(pfad);
                    if(!neu.exists()){
                        throw new FileNotFoundException("Pfad existiert nicht:"+pfad);
                    }
                    files.add(neu);
                }catch (Exception n){
                    System.out.println("Pfad ist falsch:"+n.getMessage());
                }
            }

     if(files.isEmpty()){
         throw new RuntimeException("Pfade leer oder alle inkorrekt!");
     }
        return files;
    }
}
