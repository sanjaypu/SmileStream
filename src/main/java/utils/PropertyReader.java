package utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static Properties prop = new Properties();

    static {
        try {
            InputStream input = PropertyReader.class
                    .getClassLoader()
                    .getResourceAsStream("locators.properties");

            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
