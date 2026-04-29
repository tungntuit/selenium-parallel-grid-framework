package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        try {
            prop = new Properties();
            prop.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Cannot load config file", e);
        }
    }

    public static String get(String key){
        return System.getProperty(key, prop.getProperty(key));
    }

    public static String getBrowser(String testngBrowser){
        return System.getProperty("browser",
                (testngBrowser != null && !testngBrowser.isEmpty())
                        ? testngBrowser
                        : prop.getProperty("browser"));
    }
}