package ShoesProject.tests;

import ShoesProject.pages.adidasHomePage;
import ShoesProject.pages.adidasMenPage;
import ShoesProject.pages.adidasMenShoesPage;
import mego.selenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;

public class adidasCompareMenShoesTotalPriceTest {
    public ChromeDriver driver;

    public static void main(String[] args) {
        double expectedSum = 2799.70;
        int QuantityOfShoes = 4;
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.adidas.co.il/en");
        adidasHomePage adidasHome = new adidasHomePage(driver);
        adidasMenPage adidasMen = new adidasMenPage(driver);
        adidasMenShoesPage menShoes = new adidasMenShoesPage(driver);
        adidasHome.acceptTrackingConsent();
        adidasHome.navigateToMenCategory();
        adidasMen.clickMenShoesCategory();
        menShoes.calculateTotalPriceOfMenShoesAndCompareToExpectedSum( expectedSum,QuantityOfShoes);
        base.seleniumClose(driver);

    }

}
