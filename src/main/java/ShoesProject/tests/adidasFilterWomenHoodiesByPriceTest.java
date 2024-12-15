package ShoesProject.tests;

import ShoesProject.pages.adidasHomePage;
import ShoesProject.pages.adidasWomenHoodiesPage;
import mego.selenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class adidasFilterWomenHoodiesByPriceTest {
    public ChromeDriver driver;

    public static void main(String[] args) throws InterruptedException {
        double targetPrice = 600.0;
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.adidas.co.il/en");
        adidasHomePage adidasHome = new adidasHomePage(driver);
        adidasWomenHoodiesPage womenHoodies = new adidasWomenHoodiesPage(driver);
        adidasHome.acceptTrackingConsent();
        adidasHome.navigateToWomanPage();
        womenHoodies.navigateToWomenHoodies();
        womenHoodies.filterWomenHoodiesByPrice(targetPrice);
        base.seleniumClose(driver);

    }

}
