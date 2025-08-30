package de.coco.file.sorting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static final File RESOURCES = new File("src" + File.separator + "main" + File.separator + "resources"
    );

    public static void main(String[] args) throws IOException {

         String filename= "configuration.properties";

        File appConfigPath =new File(RESOURCES,filename);

        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        System.out.println(appProps.getProperty("input.directories"));


    }
}