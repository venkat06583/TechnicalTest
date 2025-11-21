package com.johnlewis.util;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties loadConfig() {
        Properties properties = new Properties();

        // Try to load the properties from the classpath
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return null;
            }

            // Load properties from the input stream
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return properties;
    }
}

