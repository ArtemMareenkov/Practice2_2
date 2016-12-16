package practice5.pages;

import org.openqa.selenium.WebDriver;
import practice5.pages.fragments.HeaderFragment;

/**
 * Created by Serhii on 16-Dec-16.
 */
public class MainPage extends AbstractPage {

    private final static String URL = "https://www.amazon.com/";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return URL;
    }

    public HeaderFragment getHeaderFragment() {
        return new HeaderFragment(driver);
    }

    //go to Header

    //fo to Footer
}
