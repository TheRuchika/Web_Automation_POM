package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;

    }

    public By userNameElement =By.xpath("//input[@name='userName']");
    public By passwordElement = By.xpath("//input[@name='password']");
    public By submitButton=By.xpath("//input[@name='submit']");

    public void setUsername (String username){
        driver.findElement(userNameElement).sendKeys(username);
    }

    public void setPassword (String password){
        driver.findElement(passwordElement).sendKeys(password);
    }

    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }

}
