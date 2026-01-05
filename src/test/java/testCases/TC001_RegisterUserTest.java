package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegisterSuccessPage;

import java.time.Duration;

public class TC001_RegisterUserTest {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/index.php");
    }

    @Test
    public void TC001(){

        HomePage homePage = new HomePage(driver);

        homePage.clickRegisterMenu();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setFirstName("Ruchika");
        registerPage.setLastName("Kaludewa");
        registerPage.setPhone("0719368140");
        registerPage.setEmail("ruchikapromodya@gmail.com");
        registerPage.setUserName("TheRuchika");
        registerPage.setPassword("Ruchika123");
        registerPage.setConfirmPassword("Ruchika123");
        registerPage.clickSubmit();

        RegisterSuccessPage registerSuccessPage = new RegisterSuccessPage(driver);
        String actualText = registerSuccessPage.registerSuccess();
        Assert.assertTrue(actualText.contains("Dear"),"Registration failed");

    }

    @AfterMethod
    public void closeBrowser(){

    }
}
