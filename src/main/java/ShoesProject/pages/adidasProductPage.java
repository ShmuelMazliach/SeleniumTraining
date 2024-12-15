package ShoesProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static org.junit.Assert.assertEquals;


public class adidasProductPage {

    @FindBy(css = "button.add-to-cart.btn")
    WebElement addToCartButton;
    @FindBy(css = ".selectsize-error.pdp.error-color")
    WebElement errorMessage;


    private ChromeDriver driver;

    public adidasProductPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void addToBagWithoutSelectSize(){
        addToCartButton.click();
        assertEquals("The message displayed does not match the expected text","Please select a size",errorMessage.getText());

    }

}






