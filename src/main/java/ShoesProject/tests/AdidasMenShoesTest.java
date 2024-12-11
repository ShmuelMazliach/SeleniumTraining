package ShoesProject.tests;

import ShoesProject.pages.adidasHomePage;
import ShoesProject.pages.AdidasMenPage;
import ShoesProject.pages.AdidasMenShoesPage;
import mego.selenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;


public class AdidasMenShoesTest {
    public ChromeDriver driver;

    public static void main(String[] args) throws InterruptedException {
        double expectedSum = 2799.70;
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
        AdidasMenPage adidasMen = new AdidasMenPage (driver);
        AdidasMenShoesPage menShoes = new AdidasMenShoesPage(driver);
        adidasHome.acceptTrackingConsent();
        adidasHome.navigateToMenCategory();
        adidasMen.clickMenShoesCategory();
        menShoes.getAllNamesAndPricesOfMenShoes();
        menShoes.sumOfFirstThreePrices(expectedSum);
        menShoes.verifySixProductNamesAndPrices(expectedNames,expectedPrices);
        base.seleniumClose(driver);

    }

}
