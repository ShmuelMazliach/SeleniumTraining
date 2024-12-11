package ShoesProject.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class adidasHomePage {

    @FindBy(id = "men")
    WebElement menCategory;
    @FindBy(id="women")
    WebElement womenCategory;
    @FindBy(css = "span:contains('SHOP BRAS')")
    WebElement shopBrasText;
    @FindBy(css = "#megaMenu ul.nav.navbar-nav > li > a")
    List<WebElement> navBarItems;
    @FindBy(name = "q")
    WebElement searchBox;
    @FindBy(name = "search-button")
    WebElement searchButton;
    @FindBy(className = "search_keyword")

    private  ChromeDriver driver;

    public adidasHomePage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void acceptTrackingConsent() {
        try {
            WebElement acceptButton = this.driver.findElement(By.cssSelector(".affirm.btn.btn-primary.btn-inline"));

            if (acceptButton.isDisplayed()) {
                acceptButton.click();
                System.out.println("Tracking consent accepted.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No tracking consent button found.");
        }
    }
    public void verifyNavBarItems(List<String> expectedNavBarItems) {
        Assert.assertEquals("Number of nav bar items does not match.",navBarItems.size(),expectedNavBarItems.size());
        System.out.println("Number of nav bar items is as expected!");
        for(int i=0;i<navBarItems.size();i++){
            String itemText = navBarItems.get(i).getText();
            String expectedText = expectedNavBarItems.get(i);
            Assert.assertEquals("NavBar item at index " + i + " does not match expected text.",itemText,expectedText);
        }
        System.out.println("The nav bar contains all the expected names!");

    }
    public String searchBox (String text){
            searchBox.clear();
            searchBox.sendKeys(text);
            searchButton.click();
            return text;
    }
    public void navigateToMenCategory(){
        menCategory.click();
    }

    public void navigateToWomanPage(){womenCategory.click();}





}
