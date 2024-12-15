package ShoesProject.tests;

import ShoesProject.pages.adidasHomePage;
import ShoesProject.pages.adidasMenPage;
import mego.selenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class adidasCheckIfPageTitleDisplaysMenTest {
public ChromeDriver driver;

    public static void main(String[] args) throws InterruptedException {
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.adidas.co.il/en");
        adidasHomePage adidasHome = new adidasHomePage(driver);
        adidasMenPage adidasMen = new adidasMenPage(driver);
        adidasHome.acceptTrackingConsent();
        adidasHome.navigateToMenCategory();
        adidasMen.isMenCategoryPageDisplayed();
        base.seleniumClose(driver);

    }

}
