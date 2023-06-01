package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class Task1 {

    By categorySelectBy = By.id("combo1");

    @Test
    public void testBasicAjaxWeb() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");

        WebElement categoryElement = driver.findElement(categorySelectBy);
        Select selectCategory = new Select(categoryElement);
        selectCategory.selectByVisibleText("Web");

        // czekamy na zniknięcie spinnera
        WebElement loader = driver.findElement(By.id("ajaxBusy"));

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOf(loader));


        WebElement languageElement = driver.findElement(By.id("combo2"));
        Select selectLanguage = new Select(languageElement);
        selectLanguage.selectByVisibleText("Javascript");


        WebElement codeInItButton = driver.findElement(By.name("submitbutton"));
        codeInItButton.click();

        WebElement submittedCategory = driver.findElement(By.id("_valueid"));
        assertThat(submittedCategory.getText()).isEqualTo("1");

        WebElement submittedLanguage = driver.findElement(By.id("_valuelanguage_id"));
        assertThat(submittedLanguage.getText()).isEqualTo("1");

        WebElement backToForm = driver.findElement(By.id("back_to_form"));
        backToForm.click();

        driver.quit();
    }

    @Test
    public void testBasicAjaxDesktop() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");

        WebElement categoryElement = driver.findElement(categorySelectBy);
        Select selectCategory = new Select(categoryElement);
        selectCategory.selectByVisibleText("Desktop");

        // czekamy na zniknięcie spinnera
        WebElement loader = driver.findElement(By.id("ajaxBusy"));

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOf(loader));


        WebElement languageElement = driver.findElement(By.id("combo2"));
        Select selectLanguage = new Select(languageElement);
        selectLanguage.selectByVisibleText("C");


        WebElement codeInItButton = driver.findElement(By.name("submitbutton"));
        codeInItButton.click();

        WebElement submittedCategory = driver.findElement(By.id("_valueid"));
        assertThat(submittedCategory.getText()).isEqualTo("2");

        WebElement submittedLanguage = driver.findElement(By.id("_valuelanguage_id"));
        assertThat(submittedLanguage.getText()).isEqualTo("12");

        WebElement backToForm = driver.findElement(By.id("back_to_form"));
        backToForm.click();

        driver.quit();
    }

    @Test
    public void testBasicAjaxServer() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");

        WebElement categoryElement = driver.findElement(categorySelectBy);
        Select selectCategory = new Select(categoryElement);
        selectCategory.selectByVisibleText("Server");

        // czekamy na zniknięcie spinnera
        WebElement loader = driver.findElement(By.id("ajaxBusy"));

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOf(loader));


        WebElement languageElement = driver.findElement(By.id("combo2"));
        Select selectLanguage = new Select(languageElement);
        selectLanguage.selectByVisibleText("Java");


        WebElement codeInItButton = driver.findElement(By.name("submitbutton"));
        codeInItButton.click();

        WebElement submittedCategory = driver.findElement(By.id("_valueid"));
        assertThat(submittedCategory.getText()).isEqualTo("3");

        WebElement submittedLanguage = driver.findElement(By.id("_valuelanguage_id"));
        assertThat(submittedLanguage.getText()).isEqualTo("23");

        WebElement backToForm = driver.findElement(By.id("back_to_form"));
        backToForm.click();

        driver.quit();
    }
}
