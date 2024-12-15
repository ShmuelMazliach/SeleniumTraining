package ShoesProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class adidasMenPage {
    @FindBy(css = ".richtext h2")
    WebElement menCategoryTitle;
    @FindBy(css = "a[href='https://www.adidas.co.il/en/men-shoes']")
    WebElement shoesPage;
    private ChromeDriver driver;

    public adidasMenPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isMenCategoryPageDisplayed(){
        assertTrue("You have not navigated to men page!!",
                menCategoryTitle.getText().equalsIgnoreCase("men"));
        return true;
    }
    public void clickMenShoesCategory() {
        shoesPage.click();
    }


}