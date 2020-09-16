package util;

import setup.BaseTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    private ConfigProperties() {}

    private static Properties readProperty(String propertyFile) {
        Properties properties = new Properties();
        try (InputStream inputStream = BaseTest.class.getClassLoader()
                .getResourceAsStream(propertyFile)) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println(e);
        }
        return properties;
    }

    public static String getProperty(String propertyFile, String propertyName) {
        return readProperty(propertyFile).getProperty(propertyName);
    }
}
