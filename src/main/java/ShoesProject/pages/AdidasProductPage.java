package ShoesProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

import static java.lang.Thread.sleep;


public class AdidasProductPage {
    @FindBy(css = "input[type='radio'][value*='https://'] ~ span.size-value")
    List<WebElement> availableSizeLabels;
    @FindBy(css = "button.add-to-cart.btn")
    WebElement addToCartButton;
    @FindBy(css = "a.btn.btn-primary.btn-inline")
    WebElement viewBagButton;

    private ChromeDriver driver;

    public AdidasProductPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void selectSizeOfShoes (int indexOfSize) throws InterruptedException {
        availableSizeLabels.get(indexOfSize).click();
        }
    public void addToBag(){
        addToCartButton.click();
    }
    public void viewBag(){
        viewBagButton.click();
    }

    }






