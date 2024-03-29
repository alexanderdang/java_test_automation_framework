package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("#login button");
    private By statusAlert = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver; //will utilize the open session WebDriver from calling class
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
        /* This method is to check that the banner for "You logged into a secure area!"
        is there.
         */
    }
}
