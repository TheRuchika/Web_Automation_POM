package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Page Object representing the User Registration page.
 *
 * This class contains:
 * - Locators for registration form fields
 * - Actions to enter user details
 * - Form submission that navigates to RegisterSuccessPage
 */
public class RegisterPage {

    private WebDriver driver;

    /**
     * Constructor to initialize WebDriver instance.
     *
     * @param driver WebDriver instance passed from HomePage
     */
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // ----------- Locators -----------

    private By firstNameInput       = By.name("firstName");
    private By lastNameInput        = By.name("lastName");
    private By phoneInput           = By.name("phone");
    private By emailInput           = By.id("userName");
    private By addressInput         = By.name("address1");
    private By cityInput            = By.name("city");
    private By stateInput           = By.name("state");
    private By postalCodeInput      = By.name("postalCode");
    private By countryDropdown      = By.name("country");
    private By userNameInput        = By.id("email");
    private By passwordInput        = By.name("password");
    private By confirmPasswordInput = By.name("confirmPassword");
    private By submitButton         = By.name("submit");

    // ----------- Page Actions -----------

    /**
     * Enters first name.
     */
    public RegisterPage setFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }

    /**
     * Enters last name.
     */
    public RegisterPage setLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    /**
     * Enters phone number.
     */
    public RegisterPage setPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
        return this;
    }

    /**
     * Enters email address.
     */
    public RegisterPage setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    /**
     * Enters address.
     */
    public RegisterPage setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
        return this;
    }

    /**
     * Enters city.
     */
    public RegisterPage setCity(String city) {
        driver.findElement(cityInput).sendKeys(city);
        return this;
    }

    /**
     * Enters state.
     */
    public RegisterPage setState(String state) {
        driver.findElement(stateInput).sendKeys(state);
        return this;
    }

    /**
     * Enters postal code.
     */
    public RegisterPage setPostalCode(String postalCode) {
        driver.findElement(postalCodeInput).sendKeys(postalCode);
        return this;
    }

    /**
     * Selects country from dropdown.
     *
     * @param countryIndex index value of country dropdown
     */
    public RegisterPage selectCountryByIndex(int countryIndex) {
        WebElement countryElement = driver.findElement(countryDropdown);
        Select select = new Select(countryElement);
        select.selectByIndex(countryIndex);
        return this;
    }

    /**
     * Enters username.
     */
    public RegisterPage setUserName(String userName) {
        driver.findElement(userNameInput).sendKeys(userName);
        return this;
    }

    /**
     * Enters password.
     */
    public RegisterPage setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    /**
     * Enters confirm password.
     */
    public RegisterPage setConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
        return this;
    }

    /**
     * Submits the registration form.
     *
     * @return RegisterSuccessPage object
     */
    public RegisterSuccessPage clickSubmit() {
        driver.findElement(submitButton).click();
        return new RegisterSuccessPage(driver);
    }
}
