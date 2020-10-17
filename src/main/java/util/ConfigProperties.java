package util;

import setup.BaseTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    private static final String propertyFile = "properties/testsProperties.properties";
    private static final Properties properties = new Properties();

    static {
        Properties properties = new Properties();
        try (InputStream inputStream = BaseTest.class.getClassLoader()
                .getResourceAsStream(propertyFile)) {
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
