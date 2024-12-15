package ShoesProject.tests;

import ShoesProject.pages.adidasHomePage;
import mego.selenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class adidasCheckNavBarCategoryNamesTest {
    public static void main(String[] args) {

        List<String> expectedNavBarItems = Arrays.asList("MEN","WOMEN","KIDS","NEW","SPORTS",
                                                                "BRANDS","LIFESTYLE","OUTLET");

        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.adidas.co.il/en");
        adidasHomePage adidasHome = new adidasHomePage(driver);
        adidasHome.acceptTrackingConsent();
        adidasHome.checkNavbarCategoriesMatch(expectedNavBarItems);
        base.seleniumClose(driver);


    }
}
