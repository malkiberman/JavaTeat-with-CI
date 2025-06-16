package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Services extends BasePage{
    @FindBy(xpath = "//a[@id=\"pharmacies\"]")
    public WebElement pharmacies;
    public Services(WebDriver driver) {
        super(driver);
    }
}
