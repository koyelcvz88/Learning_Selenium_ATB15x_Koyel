package com.thetestingacademy.FileReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader  {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        String fileName = System.getProperty("user.dir")+"/src/test/java/com/thetestingacademy/FileReader/data.properties";
        properties.load(new FileInputStream(fileName));
        String url = properties.getProperty("url");
        System.out.println(url);
    }
}
