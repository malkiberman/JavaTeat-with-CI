package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ServicesLocatorPage extends BasePage {

    private Services services;
    private Menu menu;
    @FindBy(xpath = "//label[@for='checkbox10']")
    private WebElement checkbox;
    @FindBy(xpath = "//*[@id=\"lobby_search\"]/div/div/div/fieldset[2]/div/a")
    private WebElement search;
    @FindBy(className = "type-clinic")
    private List<WebElement> pharmacies;
    public ServicesLocatorPage(WebDriver driver) {
        super(driver);
        services = new Services(driver);
        menu =new Menu(driver);
    }

    private void clickPharmacyTab() {
        click(services.pharmacies);
    }

    private void checkOpenNow() {
        click(checkbox);
    }

    private void clickSearchButton() {
        click(search);
    }

    public boolean resultsExist() {
        clickPharmacyTab();
        checkOpenNow();
        clickSearchButton();
        wait.until(ExpectedConditions.visibilityOfAllElements(pharmacies));
        List<WebElement> results = pharmacies;

        return results.size() > 1;

    }
   public PharmacySearchPage openTopSearch(){
         click(menu.search);
       return new PharmacySearchPage(driver);
   }


}
