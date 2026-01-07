package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object representing the Login page.
 *
 * This class contains:
 * - Locators for login form fields
 * - Actions to enter credentials and submit the form
 */
public class LoginPage {

    private WebDriver driver;

    /**
     * Constructor to initialize WebDriver instance.
     *
     * @param driver WebDriver instance passed from test or previous page
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ----------- Locators -----------

    /**
     * Username input field.
     */
    private By userNameInput = By.name("userName");

    /**
     * Password input field.
     */
    private By passwordInput = By.name("password");

    /**
     * Submit/Login button.
     */
    private By submitButton = By.name("submit");

    // ----------- Page Actions -----------

    /**
     * Enters the username into the username field.
     *
     * @param username login username
     * @return current LoginPage instance (for method chaining)
     */
    public LoginPage setUsername(String username) {
        driver.findElement(userNameInput).sendKeys(username);
        return this;
    }

    /**
     * Enters the password into the password field.
     *
     * @param password login password
     * @return current LoginPage instance (for method chaining)
     */
    public LoginPage setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    /**
     * Clicks the submit button and navigates to the Login Success page.
     *
     * @return LoginSuccessPage object
     */
    public LoginSuccessPage clickSubmit() {
        driver.findElement(submitButton).click();
        return new LoginSuccessPage(driver);
    }
}
