package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSuccessPage {


    WebDriver driver;
    public LoginSuccessPage(WebDriver driver){
        this.driver = driver;

    }

    By loginSuccessText = By.xpath("//h3[contains(text(),'Login')]");

    public String loginSuccess(){
        String successText = driver.findElement(loginSuccessText).getText();

        return successText;
    }


}
