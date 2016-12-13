package practice4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii on 02-Dec-16.
 */
public class LoginPage {

    @FindBy(id = "username")
    private WebElement usernameInput; //null

    @FindBy(id = "password")
    private WebElement passwordInput; // WebElement

    @FindBy(xpath = "//*[@id='logIn']")
    private WebElement logInBtn; // WebElement

    private WebDriver driver;
    private WebDriverWait wait;

    private static final String URL = "http://80.92.229.236:81/auth/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL);
    }

    public void setUsername(String value) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(value);
    }

    public void setPassword(String value) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(value);
    }

    public void logIn() {
        wait.until(ExpectedConditions.visibilityOf(logInBtn));
        logInBtn.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getErrorMessage() {
        WebElement errorElement = driver.findElement(By.xpath(".//ul[@class='errors']/li"));
        return errorElement.getText();
    }

    public List<String> getErrorMessages() {
        List<WebElement> list = driver.findElements(By.xpath(".//ul[@class='errors']/li"));
        List<String> result = new ArrayList<String>();
        for (WebElement element : list) {
            result.add(element.getText());
        }
        return result;
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
