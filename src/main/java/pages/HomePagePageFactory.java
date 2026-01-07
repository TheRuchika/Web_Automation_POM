package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object representing the Home page using PageFactory approach.
 *
 * This class demonstrates:
 * - Element initialization using @FindBy
 * - PageFactory usage
 * - Page actions without exposing WebElements to test classes
 */
public class HomePagePageFactory {

    WebDriver driver;

    /**
     * Constructor initializes PageFactory elements.
     *
     * @param driver WebDriver instance passed from test or BasePage
     */
    public HomePagePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ----------- Locators (PageFactory style) -----------

    /**
     * REGISTER menu link (using How + using).
     */
    @FindBy(how = How.LINK_TEXT, using = "REGISTER")
    private WebElement registerButton;

    /**
     * Alternative way to locate the same element (for learning purposes).
     * Not used in actions.
     */
    @FindBy(linkText = "REGISTER")
    private WebElement registerButtonAlternative;

    // ----------- Page Actions -----------

    /**
     * Clicks on the REGISTER menu.
     * Navigation to Register page can be handled here if needed.
     */
    public void clickRegisterMenu() {
        registerButton.click();
    }
}
