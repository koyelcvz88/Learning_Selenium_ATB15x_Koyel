package com.thetestingacademy.Trimont.POM_Code.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            // Ensure you specify the correct path to the properties file
            FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}