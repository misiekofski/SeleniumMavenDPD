package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class Task4 {
    @Test
    void testDynamicButtons() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement startButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("button00")));
        startButton.click();

        var oneButton = driver.findElement(By.id("button01"));
        wait.until(ExpectedConditions.elementToBeClickable(oneButton));
        oneButton.click();

        var twoButton = driver.findElement(By.id("button02"));
        wait.until(ExpectedConditions.elementToBeClickable(twoButton));
        twoButton.click();

        var threeButton = driver.findElement(By.id("button03"));
        wait.until(ExpectedConditions.elementToBeClickable(threeButton));
        threeButton.click();


        var buttonMessage = driver.findElement(By.id("buttonmessage"));
        assertThat(buttonMessage.getText())
                .isEqualToIgnoringCase("All Buttons Clicked");
    }
}
