package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Task3 extends BaseTest {
    @Test
    public void jakisTest() {
        // logowanie
        WebElement loginInput = driver.findElement(By.id("user-name"));
        loginInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        passwordInput.submit();

        // dodaj sortowanie
        WebElement sortDropdownSelect = driver.findElement(By.cssSelector(".product_sort_container"));

        // możemy wybrać po nazwie albo po value w nodzie <option>
        Select select = new Select(sortDropdownSelect);
        select.selectByValue("hilo");

        // wypisz elementy ze sklepu
        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item_name"));

        for (WebElement e : productList) {
            System.out.println(e.getText());
        }
    }
}
