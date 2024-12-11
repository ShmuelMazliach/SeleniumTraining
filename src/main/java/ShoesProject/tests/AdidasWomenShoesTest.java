package ShoesProject.tests;

import ShoesProject.pages.adidasHomePage;
import ShoesProject.pages.AdidasWomenHoodiesPage;
import mego.selenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class AdidasWomenShoesTest {
    public ChromeDriver driver;

    public static void main(String[] args) throws InterruptedException {
        double targetPrice = 1999.80;
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.adidas.co.il/en");
        adidasHomePage adidasHome = new adidasHomePage(driver);
        AdidasWomenHoodiesPage womenHoodies = new AdidasWomenHoodiesPage(driver);
        adidasHome.acceptTrackingConsent();
        adidasHome.navigateToWomanPage();
        womenHoodies.navigateToWomenHoodies();
        womenHoodies.filterWomenHoodiesByPrice(targetPrice);
        base.seleniumClose(driver);

    }

}
