package util;

import setup.BaseTest;

import java.io.IOException;
import java.io.InputStream;

public class ConfigProperties {
    private static java.util.Properties properties;

    static {
        properties = new java.util.Properties();
        try (InputStream inputStream = BaseTest.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private ConfigProperties() {}

    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
