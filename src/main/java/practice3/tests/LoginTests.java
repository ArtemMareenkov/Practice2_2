package practice3.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import practice3.pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii on 02-Dec-16.
 */
public class LoginTests {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        //wait while driver find element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @Test
    public void positiveLoginTest() {
        loginPage.setUsername("admin");
        loginPage.setPassword("123");
        loginPage.logIn();
        Assert.assertEquals(loginPage.getTitle(), "Players", "Wrong title.");
    }

    @Test
    public void negativeLoginTest() {
        loginPage.setUsernameUsingJS("admin");
        loginPage.setPassword("12345");
        loginPage.logIn();
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid username or password", "Wrong error message.");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
