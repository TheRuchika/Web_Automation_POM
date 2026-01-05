package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePagePageFactory {
    WebDriver driver;

    public HomePagePageFactory(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //More ways to catch elements
    // 1st way
    @FindBy(how = How.LINK_TEXT, using = "REGISTER")
    public WebElement registerBtn_ele;

    //2nd way
    @FindBy(linkText = "REGISTER")
    public WebElement registerBtn_elee;

    public void clickRegisterMenu(){
        registerBtn_ele.click();

    }


}
