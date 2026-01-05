package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterSuccessPage {



    WebDriver driver;
    public RegisterSuccessPage(WebDriver driver){
        this.driver = driver;

    }

    public By successTextElement= By.xpath("//b[contains(text(),'Dear')]");


    public String registerSuccess (){
        String successText = driver.findElement(successTextElement).getText();

        return successText;
    }
}
