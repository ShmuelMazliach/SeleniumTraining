package ShoesProject.tests;

import ShoesProject.pages.adidasHomePage;
import ShoesProject.pages.adidasMenPage;
import ShoesProject.pages.adidasMenShoesPage;
import ShoesProject.pages.adidasProductPage;
import mego.selenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;

public class adidasMissingSizeMessageTest {

    public static void main(String[] args) throws InterruptedException {
        int indexMenShoes = 3;
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.adidas.co.il/en");
        adidasHomePage adidasHome = new adidasHomePage(driver);
        adidasMenPage adidasMen = new adidasMenPage(driver);
        adidasMenShoesPage menShoes = new adidasMenShoesPage(driver);
        adidasProductPage productPage = new adidasProductPage(driver);
        adidasHome.acceptTrackingConsent();
        adidasHome.navigateToMenCategory();
        adidasMen.clickMenShoesCategory();
        menShoes.navigateToProductPage(indexMenShoes);
        productPage.addToBagWithoutSelectSize();
        base.seleniumClose(driver);
    }
}