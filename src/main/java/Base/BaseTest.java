package pages.Base;

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

import java.io.File;
import java.io.FileInputStream;
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

   private static final Logger logger = LogManager.getLogger(BaseTest.class);

    protected static WebDriver driver;


    @BeforeSuite
    public void beforeSuite(){

        ChainPluginService.getInstance().addSystemInfo("Tester",System.getProperty("user.name"));
        ChainPluginService.getInstance().addSystemInfo("Browser", "chrome");

        try{
            String screenShotPath = System.getProperty("user.dir") + "/test-output/chainset/resources";
            FileUtils.cleanDirectory(new File(screenShotPath));
            logger.info("Screenshot folder cleaned : test-output/chaintest");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            String logFilePath = "logs/automation.log";
            File logFile = new File(logFilePath);
            if(logFile.exists()){
                FileUtils.write(logFile,"",false);
                logger.info("Log file cleaned: " + logFilePath);
            }else {
                FileUtils.touch(logFile);
                logger.info("Log file created hence not exist: "+logFilePath);
            }
        } catch (IOException e) {
                logger.error("Error cleaning of creating the log file: "+e.getMessage());        }
    }

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
        logger.info("Test case automation with: " +browser);

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

    public byte[] takeScreenshot(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte[] screenShot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return screenShot;
    }

}