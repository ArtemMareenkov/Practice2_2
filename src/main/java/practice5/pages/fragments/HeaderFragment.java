package practice5.pages.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import practice5.pages.helper.HeaderLinksEnum;

/**
 * Created by Serhii on 16-Dec-16.
 */
public class HeaderFragment extends AbstractFragment{

    @FindBy(xpath = ".//div[@id='navbar']")
    private WebElement parentElement;

    public HeaderFragment(WebDriver driver) {
        super(driver);
    }

    public HeaderFragment clickOnLink(HeaderLinksEnum link) {
        parentElement.findElement(By.xpath(".//a[contains(text(),'" + link.getLinkText() + "')]")).click();
        return this;
    }

    // a[contains(text(),'Deals')]
}
