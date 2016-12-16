package practice5.pages.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Serhii on 16-Dec-16.
 */
public abstract class AbstractFragment {

    protected WebDriver driver;

    public AbstractFragment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
