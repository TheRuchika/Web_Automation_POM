package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object representing the Home page of the application.
 *
 * This class contains:
 * - Locators related to Home page
 * - Actions that can be performed on Home page
 */
public class HomePage {

    WebDriver driver;

    /**
     * Constructor to initialize WebDriver instance.
     *
     * @param driver WebDriver instance passed from test or BasePage
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ----------- Locators -----------

    /**
     * Locator for REGISTER menu link.
     */
    private By registerButton = By.linkText("REGISTER");

    // ----------- Page Actions -----------

    /**
     * Clicks on the REGISTER menu and navigates to Register page.
     *
     * @return RegisterPage object
     */
    public RegisterPage clickRegisterMenu() {
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }
}
