package de.coco.file.sorting.input;

import de.coco.file.sorting.dtos.FileImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectoryReader implements Reader {
    private ArrayList<FileImpl> directoriesToSearch;
    private ArrayList<FileImpl> allFileImplsInDirectories=new ArrayList<>();

    public DirectoryReader(List<String> pathsToSearch){
        directoriesToSearch= InputUtils.createFiles(pathsToSearch);
    }
    public DirectoryReader(String pathToSearch){
        directoriesToSearch=InputUtils.createFiles(Arrays.asList(pathToSearch));
    }
    @Override
    public void readFileImplsInDirectory() {
        for (FileImpl directory:directoriesToSearch) {
           allFileImplsInDirectories.addAll( directory.listFiles());
        }
    }

    @Override
    public List<FileImpl> getFileImpls() {
        return this.allFileImplsInDirectories.parallelStream().toList();
    }


}
