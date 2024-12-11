package ShoesProject.tests;

import ShoesProject.pages.adidasHomePage;
import ShoesProject.pages.AdidasSearchResultsPage;
import mego.selenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdidasSearchResultTest {
    public ChromeDriver driver;

    public static void main(String[] args) {
        String text= "Shoes";

        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.adidas.co.il/en");
        adidasHomePage adidasHome = new adidasHomePage(driver);
        AdidasSearchResultsPage shoesPage = new AdidasSearchResultsPage(driver);
        adidasHome.acceptTrackingConsent();
        adidasHome.searchBox(text);
        shoesPage.titleVerification(text);
        base.seleniumClose(driver);
    }
}
