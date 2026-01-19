package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertyFileReader
 *
 * Utility class to read values from .properties files.
 * Implements Singleton Design Pattern to ensure only one instance is used.
 *
 * Example usage:
 * PropertyFileReader.getInstance().getProperty("config", "browser");
 */
public class PropertyFileReader {

    // Single instance of PropertyFileReader
    private static PropertyFileReader instance;

    /**
     * Returns the single instance of PropertyFileReader.
     * Creates the instance if it does not already exist.
     *
     * @return PropertyFileReader instance
     */
    public static PropertyFileReader getInstance() {

        if (instance == null) {
            instance = new PropertyFileReader();
            System.out.println("Creating new PropertyFileReader instance");
        } else {
            System.out.println("Using existing PropertyFileReader instance");
        }

        return instance;
    }

    /**
     * Loads a properties file from src/test/resources folder.
     *
     * @param fileName name of the properties file (without extension)
     * @return Properties object
     */
    private Properties getData(String fileName) {

        File file = new File(
                System.getProperty("user.dir")
                        + "\\src\\test\\resources\\"
                        + fileName
                        + ".properties"
        );

        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Property file not found: " + file.getAbsolutePath());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error loading property file: " + file.getAbsolutePath());
            e.printStackTrace();
        }

        return properties;
    }

    /**
     * Fetches a value for the given key from a properties file.
     *
     * @param fileName name of the properties file (without extension)
     * @param key      property key
     * @return property value
     */
    public String getProperty(String fileName, String key) {
        return getData(fileName).getProperty(key);
    }
}
