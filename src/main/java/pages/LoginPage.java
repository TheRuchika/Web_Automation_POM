package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    private LoginPage LoginSuccessPage;

    public LoginPage(WebDriver driver){
        this.driver = driver;

    }

    public By userNameElement =By.xpath("//input[@name='userName']");
    public By passwordElement = By.xpath("//input[@name='password']");
    public By submitButton=By.xpath("//input[@name='submit']");

    public LoginPage setUsername (String username){
        driver.findElement(userNameElement).sendKeys(username);
        return this;

    }

    public LoginPage setPassword (String password){
        driver.findElement(passwordElement).sendKeys(password);
        return this;

    }

    public LoginSuccessPage clickSubmit(){
        driver.findElement(submitButton).click();
        return new LoginSuccessPage(driver);

    }

}
