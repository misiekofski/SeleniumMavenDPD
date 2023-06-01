package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SauceInventoryPage {
    private WebDriver driver;

    @FindBy(css = ".inventory_item_name")
    List<WebElement> productList;

    public SauceInventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstItemNameFromTheList() {
        return productList.get(0).getText();
    }


}
