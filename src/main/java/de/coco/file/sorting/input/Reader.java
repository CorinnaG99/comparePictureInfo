package de.coco.file.sorting.input;

import de.coco.file.sorting.dtos.FileImpl;

import java.util.List;

public interface Reader {


    void readFileImplsInDirectory();

    List<FileImpl> getFileImpls();
}
