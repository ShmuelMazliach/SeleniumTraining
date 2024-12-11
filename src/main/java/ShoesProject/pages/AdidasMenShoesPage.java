package ShoesProject.pages;

import org.junit.Assert;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdidasMenShoesPage {
    @FindBy(css = "a.link")
    List<WebElement> allMenShoesNames;
    @FindBy(css = "span.value:not(.productcount)")
    List<WebElement> allMenShoesPrices;

    private ChromeDriver driver;
    public AdidasMenShoesPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void getAllNamesAndPricesOfMenShoes(){
        for(int i=0;i<allMenShoesNames.size();i++){
            String name = allMenShoesNames.get(i).getText();
            String price = allMenShoesPrices.get(i).getText();
            System.out.println("Name:  "+name+"  price:  "+price);
        }
    }
    public void sumOfFirstThreePrices(double expectedSum){
        double sum = 0.0;
        for(int i=0;i<3;i++){
            String priceText = allMenShoesPrices.get(i).getText();
            double price = Double.parseDouble(priceText.replaceAll("[^0-9.]",""));
            sum+=price;
        }
        System.out.println("Calculated sum of the first three prices: " + sum);
        assertEquals("The sum of the first three prices does not match the expected value!",expectedSum,sum,0.01);
    }

    public AdidasProductPage selectMenShoe(int shoeIndex){
        assertTrue("The shoe index " + shoeIndex + " is out of the valid range of 0 to " + (allMenShoesNames.size() - 1), shoeIndex >= 0 && shoeIndex < allMenShoesNames.size());
        WebElement selectedShoe = allMenShoesNames.get(shoeIndex);
        System.out.println("the shoes is: "+allMenShoesNames.get(shoeIndex).getText()+allMenShoesPrices.get(shoeIndex).getText());
        selectedShoe.click();
        return new AdidasProductPage(driver);

    }
    public void verifySixProductNamesAndPrices(List<String> expectedNames,List<String> expectedPrices){
        for(int i = 0 ; i < expectedNames.size() ; i++){
            assertEquals("the names are not equals!",expectedNames.get(i),allMenShoesNames.get(i).getText().trim());
            assertEquals("the prices are not equals!",expectedPrices.get(i),allMenShoesPrices.get(i).getText().trim());
        }
    }


    }

