package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class Task3 {
    @Test
    void testDynamicTable() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/expandingdiv.html");

        WebElement expandingDiv = driver.findElement(By.cssSelector(".expand"));
        Actions action = new Actions(driver);
        action.moveToElement(expandingDiv);
        action.perform();

        // trick: szukamy elementu w elemencie
        var linkToClick = expandingDiv.findElement(By.xpath(".//a"));

        // czekamy aż da się w niego kliknąć (rozwijanie trwa milisekundy)
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(linkToClick));

        // klikamy
        linkToClick.click();

        var header = driver.findElement(By.xpath("//h1"));
        assertThat(header.getText()).isEqualTo("You clicked the link in the expanding div");
    }
}
