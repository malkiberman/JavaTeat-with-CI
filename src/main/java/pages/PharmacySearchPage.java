package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PharmacySearchPage extends BasePage{
    @FindBy(xpath = "//*[@id=\"ClalitNewMaster_ClalitSearchBoxUC_mainSearchField\"]")
    public WebElement inputSearch;
    @FindBy(className = "type-clinic")
    private List<WebElement> pharmacies;
    public PharmacySearchPage(WebDriver driver) {
        super(driver);
    }
private void searchFor(String inputToSearch){
        type(inputSearch,inputToSearch);
}
   public boolean searchResultsExist(){
        searchFor("בתי מרקחת");
       wait.until(ExpectedConditions.visibilityOfAllElements(pharmacies)) ;
        List<WebElement>results=pharmacies;
       return results.size() > 1;

   }
}
