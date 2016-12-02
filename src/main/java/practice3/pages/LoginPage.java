package practice3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Serhii on 02-Dec-16.
 */
public class LoginPage {

    private WebDriver driver;
    private static final String URL = "http://80.92.229.236:81/auth/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public void setUsername(String value) {
        //create element and clear and sendKeys
        waitForPresenceOfElementLocated(By.id("username"));
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.clear();
        usernameInput.sendKeys(value);
    }

    public void setPassword(String value) {
        //create element and clear and sendKeys
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.clear();
        passwordInput.sendKeys(value);
    }

    public void logIn() {
        //find logIn button and click
        WebElement logInBtn = driver.findElement(By.id("logIn"));
        logInBtn.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getErrorMessage() {
        WebElement errorElement = driver.findElement(By.xpath(".//ul[@class='errors']/li"));
        return errorElement.getText();
    }

    public void setUsernameUsingJS(String value) {
        String script = "document.getElementById('username').value = '" + value + "'";
        ((JavascriptExecutor) driver).executeScript(script);
    }

    /**
     * Method waits for presence of element.
     * @param locator - locator of element which was found by id, xpath or etc.
     */
    public void waitForPresenceOfElementLocated(By locator) {
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}
