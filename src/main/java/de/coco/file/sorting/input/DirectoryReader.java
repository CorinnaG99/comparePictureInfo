package de.coco.file.sorting.input;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class DirectoryReader implements Reader{
    private ArrayList<File> directoriesToSearch;
    private HashSet<File> allFilesInDirectories;

    public DirectoryReader(ArrayList<String> pathsToSearch){
        directoriesToSearch=InputUtils.createFiles(pathsToSearch);
    }
    public DirectoryReader(String pathToSearch){
        directoriesToSearch=InputUtils.createFiles(Arrays.asList(pathToSearch));
    }
    @Override
    public void readFilesInDirectory() {
        for (File directory:directoriesToSearch) {
           allFilesInDirectories.addAll( Arrays.asList( directory.listFiles()));
        }
    }




}
