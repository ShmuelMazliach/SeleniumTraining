package ShoesProject.tests;

import ShoesProject.pages.adidasHomePage;
import ShoesProject.pages.AdidasMenPage;
import ShoesProject.pages.AdidasMenShoesPage;
import ShoesProject.pages.AdidasProductPage;
import mego.selenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.lang.Thread.sleep;

public class AdidasAddToBagTest {
    public static void main(String[] args) throws InterruptedException {
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.adidas.co.il/en");
        adidasHomePage adidasHome = new adidasHomePage(driver);
        AdidasMenPage adidasMen = new AdidasMenPage(driver);
        AdidasMenShoesPage menShoes = new AdidasMenShoesPage(driver);
        AdidasProductPage productPage = new AdidasProductPage(driver);
        adidasHome.acceptTrackingConsent();
        adidasHome.navigateToMenCategory();
        adidasMen.clickMenShoesCategory();
        menShoes.selectMenShoe(3);
        productPage.selectSizeOfShoes(2);
        productPage.addToBag();
        productPage.viewBag();
        base.seleniumClose(driver);
    }
}