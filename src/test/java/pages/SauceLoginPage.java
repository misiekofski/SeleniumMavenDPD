package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {
    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    public SauceLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SauceInventoryPage loginAs(String username, String password) {
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        passwordInput.submit();
        return new SauceInventoryPage(driver);
    }

}
