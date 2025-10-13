package de.coco.file.sorting.dtos;

import java.io.File;
import java.util.*;

public class FileImpl {
    File file;

    public FileImpl(File file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof FileImpl)) return false;

        FileImpl other = (FileImpl) o;
        //Vergleichmethoden
        if (!(other.getFile().length() == this.getFile().length())) {
            return false;
        }
        if (!(other.getFile().lastModified() == this.getFile().lastModified())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        // Hash auf Basis des Filetyps

        int hash = Objects.hash(getFileExtension(file));

        return hash;
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

    public static String getFileExtension(File file) {
        String name = file.getName();
        int lastDot = name.lastIndexOf('.');
        if (lastDot == -1) {
            return ""; // keine Endung vorhanden
        }
        return name.substring(lastDot + 1).toLowerCase();
    }
}
