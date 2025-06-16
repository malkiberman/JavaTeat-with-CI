package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu extends BasePage {

    @FindBy(xpath = "//*[@id=\"DeltaPlaceHolderMain\"]/header/div[1]/div/div/div[3]/ul/li[3]/a")
    public WebElement search;

    public Menu(WebDriver driver) {
        super(driver);
    }
}
