import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii on 25-Nov-16.
 */
public class LoginTests {


    public static void main(String[] args) {
        //comment
        WebDriver driver = new FirefoxDriver(); // open browser
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("http://80.92.229.236:81/auth/login"); // open Poker

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("admin");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("123");

        System.out.println(usernameInput.getText());

        WebElement loginButton = driver.findElement(By.id("logIn"));
        loginButton.click();

        String expectedTitle = "Players";

        String actualTitle = driver.getTitle();

        assertString(actualTitle, expectedTitle);

        WebElement usernameField = driver.findElement(By.id("723a925886__login"));

        String username = "user10";
        usernameField.sendKeys(username);

        driver.findElement(By.xpath(".//input[@value='Search']")).click();

        driver.findElement(By.xpath(".//tr[.//a[text()='" + username + "']]//img[@title='Edit']")).click();

        WebElement emailField = driver.findElement(By.xpath(".//input[contains(@id,'us_email')]"));
        String actualEmailValue = emailField.getAttribute("value");
        assertString(actualEmailValue, "bbb1111113@gmail.com");

        driver.quit();

    }

    public static void assertString(String actualResult, String expectedResult) {
        if(expectedResult.equals(actualResult)) {
            System.out.println("Passed");
        } else {
            System.err.println("Failed. Expected: " + expectedResult
                    + ". Actual: " + actualResult);
        }
    }

}
