package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream input = new FileInputStream("src/test/resources/config.properties");
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Nie można załadować pliku config.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
