package practice4.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import practice4.pages.LoginPage;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii on 02-Dec-16.
 */
public class LoginTests {

    private static WebDriver driver;
    private LoginPage loginPage;
    private SoftAssert softAssert;

    @BeforeSuite
    public void beforeSuite() {
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
        softAssert = new SoftAssert();
    }

    @Test(groups = "critical")
    public void positiveLoginTest() {
        loginPage.setUsername("admin");
        loginPage.setPassword("123");
        loginPage.logIn();
        Assert.assertEquals(loginPage.getTitle(), "Players", "Wrong title.");
        softAssert.assertEquals(loginPage.getTitle(), "Players", "Wrong title.");
        softAssert.assertEquals(loginPage.getTitle(), "Players", "Wrong title.");
        softAssert.assertEquals(loginPage.getTitle(), "Players", "Wrong title.");
        softAssert.assertEquals(loginPage.getTitle(), "Players", "Wrong title.");
        softAssert.assertEquals(loginPage.getTitle(), "Players", "Wrong title.");
        softAssert.assertAll();
    }


    @DataProvider(name = "negativeLoginTestDP")
    public Object[][] negativeLoginTestDP() {
        return new Object[][] {
                { "admin", "12345", Arrays.asList("Invalid username or password")},
                { "admin", "123457823526", Arrays.asList("Invalid username or password")},
                { "", "", Arrays.asList("Value is required and can't be empty", "Value is required and can't be empty")}
        };
    }

    @Test(dataProvider = "negativeLoginTestDP", dependsOnGroups = "critical", groups = "regression")
    public void negativeLoginTestDP(String username, String password, List<String> errorMsg) {
        loginPage.setUsernameUsingJS(username);
        loginPage.setPassword(password);
        loginPage.logIn();
//        Assert.assertEquals(loginPage.getErrorMessage(), errorMsg, "Wrong error message.");
        Assert.assertEquals(loginPage.getErrorMessages(), errorMsg, "Wrong error message.");
    }


    @Parameters({"myUsername", "myPassword", "errorMsg"})
    @Test(groups = "regression")
    public void negativeLoginTestParameters(String username, String password, String errorMsg) {
        loginPage.setUsernameUsingJS(username);
        loginPage.setPassword(password);
        loginPage.logIn();
        Assert.assertEquals(loginPage.getErrorMessage(), errorMsg, "Wrong error message.");
    }



    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }














}
