package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object representing the Login Success page.
 *
 * This page is displayed after a successful login
 * and contains confirmation messages for validation.
 */
public class LoginSuccessPage {

    private WebDriver driver;

    /**
     * Constructor to initialize WebDriver instance.
     *
     * @param driver WebDriver instance passed from LoginPage
     */
    public LoginSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    // ----------- Locators -----------

    /**
     * Locator for login success confirmation text.
     */
    private By loginSuccessMessage = By.xpath("//h3[contains(text(),'Login')]");

    // ----------- Page Actions -----------

    /**
     * Retrieves the login success confirmation message.
     *
     * @return login success message text
     */
    public String getLoginSuccessMessage() {
        return driver.findElement(loginSuccessMessage).getText();
    }
}
