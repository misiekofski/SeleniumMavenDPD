package basicpom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SauceInventoryPage;
import pages.SauceLoginPage;

import static org.assertj.core.api.Assertions.*;

public class Task1 {
    private static WebDriver driver;
    @BeforeClass
    static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void shouldLoginSuccesfully() {
        SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);
        sauceLoginPage.loginAs("standard_user", "secret_sauce");

        SauceInventoryPage sauceInventoryPage = new SauceInventoryPage(driver);
        String firstElement = sauceInventoryPage.getFirstItemNameFromTheList();

        assertThat(firstElement)
                .isEqualToIgnoringCase("Sauce Labs Backpack");
    }
}
