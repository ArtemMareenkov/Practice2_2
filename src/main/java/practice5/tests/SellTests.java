package practice5.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import practice5.pages.MainPage;
import practice5.pages.fragments.HeaderFragment;
import practice5.pages.helper.HeaderLinksEnum;

import java.util.ResourceBundle;

/**
 * Created by Serhii on 16-Dec-16.
 */
public class SellTests extends BaseTest{
    private MainPage mainPage;
    private static final String login = ResourceBundle.getBundle("application").getString("login");
    private static final String password = ResourceBundle.getBundle("application").getString("password");

    @BeforeTest
    public void beforeTest() {
        super.beforeTest();
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test(dependsOnMethods = "testForFun")
    public void openSellsPageTest() {
        mainPage.getHeaderFragment()
                .clickOnLink(HeaderLinksEnum.SELL)
                .clickOnLink(HeaderLinksEnum.DEALS)
                .clickOnLink(HeaderLinksEnum.GIFT_CARDS)
                .clickOnLink(HeaderLinksEnum.SELL);
        softAssert.assertEquals(mainPage.getTitle(), "Amazon.com: Sell Products Online with Selling on Amazon", "Wrong title");
        //softAssert.assertEquals(mainPage.getCurrentUrl(), "", "Wrong url");
        softAssert.assertAll();
    }

    @Test
    public void testForFun() {
        Assert.fail("FUUUUUN!!!");
    }

    @Test
    public void applicationPropertiesTest() {
        softAssert.assertEquals(login, "amazon", "Wrong login.");
        softAssert.assertEquals(password, "password example", "Wrong password.");
        softAssert.assertAll();
    }
}
