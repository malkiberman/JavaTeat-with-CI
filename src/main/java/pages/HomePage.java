package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private Menu menu;
    private SubMenu subMenu;
    public HomePage(WebDriver driver) {
        super(driver);
        menu = new Menu(driver);
        subMenu =new SubMenu(driver);
    }

    public  ServicesLocatorPage clickServiceLocator(){
        click(subMenu.searchServices);
        return new ServicesLocatorPage(driver);
    }
}
