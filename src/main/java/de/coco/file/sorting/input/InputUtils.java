package de.coco.file.sorting.input;

import de.coco.file.sorting.dtos.FileImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputUtils {

    public static ArrayList<FileImpl> createFiles(List<String> pfade){
        ArrayList<FileImpl> files= new ArrayList<FileImpl>();

            for (String pfad:pfade) {
                try {
                    Path path = Paths.get(pfad);
                    File neu = new File(path.toUri());
                    if(!neu.exists()){
                        throw new FileNotFoundException("Pfad existiert nicht:"+pfad);
                    }
                    files.add(new FileImpl(neu));
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
