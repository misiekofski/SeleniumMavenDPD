package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Task2 extends BaseTest {
    @Test
    public void shouldLoginSuccesfully() {
        // logowanie
        WebElement loginInput = driver.findElement(By.id("user-name"));
        loginInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        passwordInput.submit();

        // weź liste elementów
        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item_name"));

        for (WebElement e : productList) {
            System.out.println(e.getText());
        }
    }
}
