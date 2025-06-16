package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubMenu extends BasePage{
    @FindBy(xpath = "//a[@id=\"ClalitNewMaster_QuickLinksUC_rptQuickLinks_ctl03_nav_item_link\"]")
    public WebElement searchServices;
    public SubMenu(WebDriver driver) {
        super(driver);
    }

}
