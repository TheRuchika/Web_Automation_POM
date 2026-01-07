package pages.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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
    public void setup() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Launch application
            driver.get("https://demo.guru99.com/test/newtours/index.php");
        }
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
