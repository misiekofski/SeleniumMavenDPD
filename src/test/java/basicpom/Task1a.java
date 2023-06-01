package basicpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SauceInventoryPage;
import pages.SauceLoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1a {
    private static WebDriver driver;
    @BeforeClass
    static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void shouldLoginSuccesfully() {
        SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);

        String firstElement = sauceLoginPage
                                .loginAs("standard_user", "secret_sauce")
                                .getFirstItemNameFromTheList();

        assertThat(firstElement)
                .isEqualToIgnoringCase("Sauce Labs Backpack");
    }
}
