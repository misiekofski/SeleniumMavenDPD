package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Task2 {
    @Test
    public void tableTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

        List<WebElement> tableRows = driver.findElements(By.cssSelector("tr"));
        assertThat(tableRows).hasSize(3);

        WebElement tableData = driver.findElement(By.cssSelector("summary"));
        tableData.click();

        WebElement jsonDataInput = driver.findElement(By.id("jsondata"));
        jsonDataInput.click();
        jsonDataInput.clear();
//        jsonDataInput.sendKeys(Keys.CONTROL + "a");
//        jsonDataInput.sendKeys(Keys.BACK_SPACE);
        jsonDataInput.sendKeys("[{\"imię\": \"Bob\", \"wiek\" : 20}, {\"imię\": \"George\", \"wiek\" : 42}, {\"imię\": \"Jan\", \"wiek\" : 7} ]");

        WebElement refreshTableButton = driver.findElement(By.id("refreshtable"));
        refreshTableButton.click();

        tableRows = driver.findElements(By.cssSelector("tr"));
        assertThat(tableRows).hasSize(4);

        driver.quit();
    }
}
