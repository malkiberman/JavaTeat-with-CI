package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ClalitPharmacyTest {
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.clalit.co.il/he/Pages/default.aspx");
    }
    @Test
    public void testServices()  {
      HomePage homePage = new HomePage(driver);
        ServicesLocatorPage servicesLocatorPage =  homePage.clickServiceLocator();
       assertEquals(servicesLocatorPage.resultsExist(),true);
        System.out.println("bravooooo");
    }
    @Test
    public void search()  {
        testServices();
        ServicesLocatorPage servicesLocatorPage = new ServicesLocatorPage(driver);
        PharmacySearchPage pharmacySearchPage =  servicesLocatorPage.openTopSearch();
        assertEquals(pharmacySearchPage.searchResultsExist(),true);
        System.out.println("bravooooo");
    }
}
