package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterSuccessPage {



    WebDriver driver;
    public RegisterSuccessPage(WebDriver driver){
        this.driver = driver;

    }

    public By successTextElement= By.xpath("//b[contains(text(),'Dear')]");
    public By signInElement = By.xpath("//a[contains(text(),'sign-in')]");

    public String registerSuccess (){
        String successText = driver.findElement(successTextElement).getText();

        return successText;
    }

    public LoginPage clickSignIn(){

    driver.findElement(signInElement).click();
    return new LoginPage(driver);
    }
}
