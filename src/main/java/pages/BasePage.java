package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    protected void click(WebElement locator) {
        locator.click();
    }

    protected void type(WebElement locator, String text) {
       locator.sendKeys(text);
    }
    protected String getText(WebElement locator) {
        return locator.getText();
    }
}
