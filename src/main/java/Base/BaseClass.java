package Base;

import com.aventstack.chaintest.service.ChainPluginService;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.PropertyFileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * BaseClass
 *
 * Responsibilities:
 * - Initialize WebDriver based on configuration
 * - Launch application before test execution
 * - Manage browser lifecycle across the test suite
 * - Configure reporting and logging
 * - Provide reusable utilities (screenshots)
 *
 * All test classes should extend this class.
 */
public class BaseClass {

    private static final Logger logger = LogManager.getLogger(BaseClass.class);

    protected static WebDriver driver;

    /**
     * Pre-suite setup:
     * - Add system info to ChainTest report
     * - Clean screenshot directory
     * - Reset or create log file
     */
    @BeforeSuite
    public void beforeSuite() {

//         Add system details to ChainTest report
        ChainPluginService.getInstance()
                .addSystemInfo("Tester", System.getProperty("user.name"));
        ChainPluginService.getInstance()
                .addSystemInfo("Browser", "chrome");

        // Clean screenshot directory
        try {
            String screenshotPath =
                    System.getProperty("user.dir") + "/test-output/chaintest/resources";
            FileUtils.cleanDirectory(new File(screenshotPath));
            logger.info("Screenshot directory cleaned");
        } catch (IOException e) {
            throw new RuntimeException("Failed to clean screenshot directory", e);
        }

        // Clean or create log file
        try {
            String logFilePath = "logs/automation.log";
            File logFile = new File(logFilePath);

            if (logFile.exists()) {
                FileUtils.write(logFile, "", false);
                logger.info("Log file cleaned: " + logFilePath);
            } else {
                FileUtils.touch(logFile);
                logger.info("Log file created: " + logFilePath);
            }
        } catch (IOException e) {
            logger.error("Error while preparing log file", e);
        }
    }

    /**
     * Initializes WebDriver once before executing the test suite.
     * Reads browser type and application URL from config file.
     */
    @BeforeSuite
    public void setup() throws IOException {

        // Load configuration properties
        FileInputStream fileInputStream =
                new FileInputStream(System.getProperty("user.dir")
                        + "\\src\\test\\resources\\config.properties");


        Properties prop = new Properties();
        prop.load(fileInputStream);

        // Read values using Singleton PropertyFileReader
        String browser =
                PropertyFileReader.getInstance().getProperty("config", "browser");
        String appURL =
                PropertyFileReader.getInstance().getProperty("config", "App_url");

        // Initialize WebDriver based on browser type
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
                throw new RuntimeException("Browser not supported: " + browser);
        }

        logger.info("Executing tests on browser: " + browser);

        // Browser configuration
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Long.parseLong(prop.getProperty("implicit_wait")))
        );

        // Launch application
        driver.get(appURL);
    }

    /**
     * Terminates WebDriver after all tests are executed.
     */
    @AfterSuite
    public void tearDown() {

        if (driver != null) {
            driver.quit();
            driver = null;
            logger.info("Browser closed and WebDriver cleaned up");
        }
    }

    /**
     * Captures screenshot in byte format.
     * Useful for attaching screenshots to reports.
     *
     * @return screenshot as byte array
     */
    public byte[] takeScreenshot() {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }
}
