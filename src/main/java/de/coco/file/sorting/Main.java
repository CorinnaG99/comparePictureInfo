package de.coco.file.sorting;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static final String ROOT_PATH = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    public static void main(String[] args) throws IOException {
        System.out.println(ROOT_PATH);
        String appConfigPath = ROOT_PATH + "configuration.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        System.out.println(appProps.getProperty("input.directories"));


    }
}