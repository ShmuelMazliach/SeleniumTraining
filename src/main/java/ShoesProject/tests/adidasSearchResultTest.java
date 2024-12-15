package ShoesProject.tests;

import ShoesProject.pages.adidasHomePage;
import ShoesProject.pages.adidasSearchResultsPage;
import mego.selenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;

public class adidasSearchResultTest {
    public ChromeDriver driver;

    public static void main(String[] args) {
        String text= "Shoes";

        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.adidas.co.il/en");
        adidasHomePage adidasHome = new adidasHomePage(driver);
        adidasSearchResultsPage shoesPage = new adidasSearchResultsPage(driver);
        adidasHome.acceptTrackingConsent();
        adidasHome.searchBox(text);
        shoesPage.titleVerification(text);
        base.seleniumClose(driver);
    }
}
