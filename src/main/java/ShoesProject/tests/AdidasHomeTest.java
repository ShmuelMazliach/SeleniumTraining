package ShoesProject.tests;

import ShoesProject.pages.adidasHomePage;
import mego.selenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class AdidasHomeTest {
    public static void main(String[] args) {
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.adidas.co.il/en");
        adidasHomePage adidasHome = new adidasHomePage(driver);
        adidasHome.acceptTrackingConsent();
        List<String> expectedNavBarItems = Arrays.asList("MEN","WOMEN","KIDS","NEW","SPORTS","BRANDS","LIFESTYLE","OUTLET");
        adidasHome.verifyNavBarItems(expectedNavBarItems);
        base.seleniumClose(driver);


    }
}
