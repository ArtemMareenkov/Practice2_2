package practice4.actionstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii on 09-Dec-16.
 */
public class FrameTests {

    private WebDriver driver;
    private FramePage framePage;
    private SoftAssert softAssert;

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        framePage = new FramePage(driver);
        framePage.open();
    }

    @BeforeMethod
    public void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @Test
    public void dragAndDropTest() {
        framePage.switchToFrame();

        softAssert.assertEquals(framePage.getDroppableText(), "Drop here", "Wrong text before drag and drop action.");
        framePage.dragAndDrop();
        softAssert.assertEquals(framePage.getDroppableText(), "Dropped!", "Wrong text after drag and drop action.");
        //todo
        softAssert.assertAll();
    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
