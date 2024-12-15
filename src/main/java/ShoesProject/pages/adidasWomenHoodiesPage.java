package ShoesProject.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class adidasWomenHoodiesPage {

    @FindBy(css = "span.value:not(.productcount)")
    List<WebElement> HoodiesWomenPriceList;
    @FindBy(css = "a.link")
    List<WebElement> categoryNames;
    @FindBy(css = "a[data-tracking-link*='shop hoodies']")
    private WebElement shopHoodiesLink;


    private ChromeDriver driver;
    public adidasWomenHoodiesPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void filterWomenHoodiesByPrice(double targetPrice){
        System.out.println("The products whose price is less than  " +targetPrice+"  are:");
        for(int i=0;i<HoodiesWomenPriceList.size()-1;i++){
            String priceText = HoodiesWomenPriceList.get(i).getText();
            double price = Double.parseDouble(priceText.replaceAll("[^0-9.]",""));
            String nameProduct = categoryNames.get(i).getText();
            Assert.assertTrue("there are some of items that their price is higher than 600$",price<= targetPrice);
            System.out.println(nameProduct+ " - "+price);


        }

        }
        public void navigateToWomenHoodies(){
            shopHoodiesLink.click();
        }



    }



