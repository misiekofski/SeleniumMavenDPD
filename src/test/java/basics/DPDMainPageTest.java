package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DPDMainPageTest {
    @Test
    public void slowTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.dpdgroup.com/lv/mydpd/?lang=en");

        // zamiast implicit wait - możemy dokładnie powiedzieć na co czekam
        WebElement acceptCookieButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id("popin_tc_privacy_button")));
        acceptCookieButton.click();

        WebElement getHelp = driver.findElement(By.cssSelector("#row1-2"));
        getHelp.click();

        WebElement sendParcels = driver.findElement(By.cssSelector("#faq-page > div > div > div:nth-child(6) > div > div > div:nth-child(2) > a"));
        sendParcels.click();
    }
}
