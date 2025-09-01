package de.coco.file.sorting;

import de.coco.file.sorting.dtos.FileImpl;
import de.coco.file.sorting.input.DirectoryReader;
import de.coco.file.sorting.input.Reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Main {

    public static final String FILENAME_PROPERTIES = "configuration.properties";
    private static final File RESOURCES = new File("src" + File.separator + "main" + File.separator + "resources"
    );


    public static void main(String[] args) throws IOException {

        Properties properties = readProperties();

        List<String> inputPaths = readPropertyAndSplit(properties, "input.directories");
        String outputPath = readPropertyAndSplit(properties, "output.directory").get(0);
        String overrideString = readPropertyAndSplit(properties, "existing.files.override").get(0);
        boolean override =Boolean.parseBoolean(overrideString);


        Reader reader = new DirectoryReader(inputPaths);
        reader.readFileImplsInDirectory();
        List<FileImpl> files=reader.getFileImpls();
        System.out.println(files.size());


    }

    private static List<String> readPropertyAndSplit(Properties properties, String property) {
        List<String> inputPaths=new ArrayList<>();
        String valueInputPaths = properties.getProperty(property);
        if(valueInputPaths.contains("/")) {
          inputPaths = Arrays.asList(valueInputPaths.split(","));
            inputPaths.replaceAll(path -> convertIfNeeded(path));
        }else{
            inputPaths.add(valueInputPaths);
        }
        return inputPaths;
    }
    public static String convertIfNeeded(String path) {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return Paths.get(path).toString();
        }
        return path;
    }
    private static Properties readProperties() throws IOException {
        Properties properties;

        File appConfigPath = new File(RESOURCES, FILENAME_PROPERTIES);
        System.out.println(appConfigPath);
        properties = new Properties();
        properties.load(new FileInputStream(appConfigPath));
        if (properties.isEmpty()) {
            System.out.println("Properties sind leer. Beende Programm");
            System.exit(0);
        }
        return properties;
    }
}