package practice4.actionstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Serhii on 09-Dec-16.
 */
public class FramePage {

    //findBy

    @FindBy(id = "draggable")
    private WebElement draggableElement;

    @FindBy(id = "droppable")
    private WebElement droppableElement;

    @FindBy(xpath = ".//*[@class='demo-frame']")
    private WebElement frame;

    private WebDriver driver;
    private String url = "https://jqueryui.com/droppable/";

    //constructor

    public FramePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //methods
    public void open() {
        driver.get(url);
    }

    public void switchToFrame() {
        driver.switchTo().frame(frame);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void dragAndDrop() {
        Actions builder = new Actions(driver);
        builder.dragAndDrop(draggableElement, droppableElement)
                .perform();
    }

    public String getDroppableText() {
        return droppableElement.findElement(By.xpath(".//p")).getText();
    }
}
