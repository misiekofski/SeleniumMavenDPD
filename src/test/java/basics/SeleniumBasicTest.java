package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumBasicTest {
    @Test
    public void openBing(){
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.bing.com/");

        WebElement inputText = driver.findElement(By.name("q"));
        inputText.click();
        inputText.sendKeys("DPD lider dostaw na świecie");
        inputText.submit();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();
    }
}