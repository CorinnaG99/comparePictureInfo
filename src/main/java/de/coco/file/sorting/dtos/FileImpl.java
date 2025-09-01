package de.coco.file.sorting.dtos;

import java.io.File;
import java.util.*;

public class FileImpl {
File file;
    public FileImpl(File file) {
        this.file=file;
    }


    public boolean equals(FileImpl obj) {
        return Objects.equals(this.file.hashCode(), obj.hashCode());
    }

    public File getFile() {
        return file;
    }

    public List<FileImpl> listFiles() {
        ArrayList<FileImpl> fileimplList = new ArrayList<>();
        Iterator<File> fileIterator = Arrays.stream(file.listFiles()).iterator();
        while (fileIterator.hasNext()) {
            fileimplList.add(new FileImpl(fileIterator.next()));
        }
        return fileimplList;
    }
}
