package pages.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * BaseTest class is responsible for:
 * - Initializing the WebDriver
 * - Opening the application URL
 * - Managing browser lifecycle across the test suite
 *
 * All test classes should extend this class.
 */
public class BaseTest {

    protected static WebDriver driver;


    /**
     * Initializes WebDriver once before the entire test suite.
     */
    @BeforeSuite
    public void setup() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");

        Properties prop = new Properties();
        prop.load(fileInputStream);


        String browser = prop.getProperty("browser");


        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Browser not supported: " + browser);
                return;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("implicit_wait"))));

        // Launch application
        driver.get(prop.getProperty("App_url"));
    }


    /**
     * Quits WebDriver after the entire test suite execution.
     */
    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}