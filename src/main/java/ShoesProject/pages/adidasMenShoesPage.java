package ShoesProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class adidasMenShoesPage {
    @FindBy(css = "a.link")
    List<WebElement> allMenShoesNames;
    @FindBy(css = "span.value:not(.productcount)")
    List<WebElement> allMenShoesPrices;



    private ChromeDriver driver;

    public adidasMenShoesPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void printAllNamesAndPricesOfMenShoes() {
        for (int i = 0; i < allMenShoesNames.size(); i++) {
            String name = allMenShoesNames.get(i).getText();
            String price = allMenShoesPrices.get(i).getText();
            System.out.println("Name:  " + name + "  price:  " + price);
        }
    }

    public void calculateTotalPriceOfMenShoesAndCompareToExpectedSum(double expectedSum, int QuantityOfShoes) {
        double sum = 0.0;
        for (int i = 0; i < QuantityOfShoes; i++) {
            String priceText = allMenShoesPrices.get(i).getText();
            double price = Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));
            sum += price;
        }
        System.out.println("The total price of the first  " + QuantityOfShoes + "  men's shoes is:  " + sum);
        assertEquals("The total price of the men's shoes does not match the expected value!", expectedSum, sum, 0.01);
    }
    public void checkShoesNamesAndPrices(List<String> expectedNames,List<String> expectedPrices){
        for(int i = 0 ; i < expectedNames.size() ; i++){
            assertEquals("the names are not equals!",expectedNames.get(i),allMenShoesNames.get(i).getText().trim());
            assertEquals("the prices are not equals!",expectedPrices.get(i),allMenShoesPrices.get(i).getText().trim());
        }
    }
    public void navigateToProductPage(int shoesIndexNumber){
        assertTrue("The shoe index " + shoesIndexNumber + " is out of the valid range of 0 to " + (allMenShoesNames.size() - 1), shoesIndexNumber >= 0 && shoesIndexNumber < allMenShoesNames.size());
        System.out.println("the shoes is:  "+allMenShoesNames.get(shoesIndexNumber).getText()+"the price is:  "+allMenShoesPrices.get(shoesIndexNumber).getText());
        allMenShoesNames.get(shoesIndexNumber).click();
    }
    }


