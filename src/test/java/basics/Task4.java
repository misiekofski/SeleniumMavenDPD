package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Task4 extends BaseTest {
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

        // sprawdź czy pierwsze dwa to:
//        Sauce Labs Fleece Jacket
//        Sauce Labs Backpack

        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item_name"));
        String firstProduct = productList.get(0).getText();
        String secondProduct = productList.get(1).getText();

        assertThat(firstProduct).isEqualTo("Sauce Labs Fleece Jacket");
        assertThat(secondProduct).isEqualTo("Sauce Labs Backpack");

        // jeszcze raz wyszukaj element
        sortDropdownSelect = driver.findElement(By.cssSelector(".product_sort_container"));
        select = new Select(sortDropdownSelect);
        // bez dwóch linijek powyżej nie działa, bo strona się przeładowała
        select.selectByValue("za");


        productList = driver.findElements(By.cssSelector(".inventory_item_name"));
        firstProduct = productList.get(0).getText();
        secondProduct = productList.get(1).getText();

        assertThat(firstProduct).isEqualTo("Test.allTheThings() T-Shirt (Red)");
        assertThat(secondProduct).isEqualTo("Sauce Labs Onesie");
    }
}
