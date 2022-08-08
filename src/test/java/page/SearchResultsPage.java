package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".products-grid .product-name a")
    private List<WebElement> listOfProducts;


    public boolean isProductInList(String productName){
        for (WebElement element : listOfProducts){
            if (element.getText().equalsIgnoreCase(productName)){
                return true;
            }
        }
        return false;
    }

    public boolean isProductInListAndSelect(String productName){
        for (WebElement element : listOfProducts){
            if (element.getText().equalsIgnoreCase(productName)){
                element.click();
                return true;
            }
        }
        return false;
    }
}
