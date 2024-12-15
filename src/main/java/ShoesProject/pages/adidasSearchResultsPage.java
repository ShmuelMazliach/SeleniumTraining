package ShoesProject.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adidasSearchResultsPage {
    @FindBy(className = "categoryName")
    WebElement headerName;
    private ChromeDriver driver;
    public adidasSearchResultsPage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void titleVerification(String patternToFound){
        Assert.assertTrue("Title found not as expected",headerName.getText().contains(patternToFound));
        System.out.println("Title found is as expected!");
    }
}
