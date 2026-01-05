package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {


    WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;

    }

    public By firstName_element =   By.xpath("//input[@name='firstName']");
    public By lastName_element =   By.xpath("//input[@name='lastName']");
    public By phone_element =  By.xpath("//input[@name='phone']");
    public By email_element =  By.xpath("//input[@id='userName']");
    public By address_element =     By.xpath("//input[@name='address1']");
    public By city_element =   By.xpath("//input[@name='city']");
    public By state_element =     By.xpath("//input[@name='state']");
    public By postalCode_element =   By.xpath("//input[@name='postalCode']");
    public By country_element =    By.xpath("//select[@name='country']");
    public By userName_element =  By.xpath("//input[@id='email']");
    public By password_element = By.xpath("//input[@name='password']");
    public By confirmPassword_element = By.xpath("//input[@name='confirmPassword']");
    public By submit_element = By.xpath("//input[@name='submit']");

    public void  setFirstName(String firstName){
        driver.findElement(firstName_element).sendKeys(firstName);
    }
    public void  setLastName(String lastName){
        driver.findElement(lastName_element).sendKeys(lastName);
    }
    public void  setPhone(String phone){
        driver.findElement(phone_element).sendKeys(phone);
    }
    public void  setEmail(String email){
        driver.findElement(email_element).sendKeys(email);
    }
    public void  setAddress(String address){
        driver.findElement(address_element).sendKeys(address);
    }
    public void  setCity(String city){
        driver.findElement(city_element).sendKeys(city);
    }
    public void  setState(String state){
        driver.findElement(state_element).sendKeys(state);
    }
    public void  setPostalCode(String postalCode){
        driver.findElement(postalCode_element).sendKeys(postalCode);
    }
    public void  setCountry(String country){
        WebElement countrySelect = driver.findElement(country_element);
        Select dropDownCountry = new Select(countrySelect);
        dropDownCountry.selectByIndex(2);
    }
    public void  setUserName(String userName){
        driver.findElement(userName_element).sendKeys(userName);
    }
    public void  setPassword(String password){
        driver.findElement(password_element).sendKeys(password);
    }
    public void  setConfirmPassword(String confirmPassword){
        driver.findElement(confirmPassword_element).sendKeys(confirmPassword);
    }
    public void  clickSubmit(){
        driver.findElement(submit_element).click();
    }
}
