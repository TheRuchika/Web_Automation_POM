package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object representing the Registration Success page.
 *
 * This page is displayed after a successful user registration
 * and provides confirmation text and navigation to Login page.
 */
public class RegisterSuccessPage {

    private WebDriver driver;

    /**
     * Constructor to initialize WebDriver instance.
     *
     * @param driver WebDriver instance passed from RegisterPage
     */
    public RegisterSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    // ----------- Locators -----------

    /**
     * Locator for registration success confirmation message.
     */
    private By successMessage = By.xpath("//b[contains(text(),'Dear')]");

    /**
     * Locator for Sign-In link.
     */
    private By signInLink = By.xpath("//a[contains(text(),'sign-in')]");

    // ----------- Page Actions -----------

    /**
     * Retrieves the registration success confirmation message.
     *
     * @return success message text
     */
    public String getRegisterSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    /**
     * Clicks on the Sign-In link and navigates to Login page.
     *
     * @return LoginPage object
     */
    public LoginPage clickSignIn() {
        driver.findElement(signInLink).click();
        return new LoginPage(driver);
    }
}
