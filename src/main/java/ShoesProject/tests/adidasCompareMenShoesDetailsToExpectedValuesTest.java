package ShoesProject.tests;

import ShoesProject.pages.adidasHomePage;
import ShoesProject.pages.adidasMenPage;
import ShoesProject.pages.adidasMenShoesPage;
import mego.selenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;


public class adidasCompareMenShoesDetailsToExpectedValuesTest {
    public ChromeDriver driver;

    public static void main(String[] args) throws InterruptedException {

        List<String> expectedNames = Arrays.asList(
                "COPA PURE 3 ELITE FIRM GROUND BOOTS",
                "PREDATOR ELITE FIRM GROUND BOOTS",
                "PREDATOR FREESTYLE INDOOR BOOTS",
                "PREDATOR LEAGUE FOLD-OVER TONGUE FIRM/MULTI-GROUND BOOTS",
                "PREDATOR ELITE FIRM GROUND BOOTS",
                "PREDATOR ELITE FOLD-OVER TONGUE FIRM GROUND BOOTS");
        List<String> expectedPrices = Arrays.asList("₪ 1,299.90","₪ 1,049.90","₪ 449.90","₪ 349.90","₪ 1,049.90","₪ 1,099.90");


        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.adidas.co.il/en");
        adidasHomePage adidasHome = new adidasHomePage(driver);
        adidasMenPage adidasMen = new adidasMenPage(driver);
        adidasMenShoesPage menShoes = new adidasMenShoesPage(driver);
        adidasHome.acceptTrackingConsent();
        adidasHome.navigateToMenCategory();
        adidasMen.clickMenShoesCategory();
        menShoes.checkShoesNamesAndPrices(expectedNames,expectedPrices);
        base.seleniumClose(driver);

    }

}
