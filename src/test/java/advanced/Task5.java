package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Task5 {
    @Test
    void uploadFile(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");
        WebElement fileInput = driver.findElement(By.id("fileinput"));
        String pathToFile = "C:\\downloads\\cat.jpg";
        fileInput.sendKeys(pathToFile);

        WebElement imageCheckbox = driver.findElement(By.id("itsanimage"));
        imageCheckbox.click();
        WebElement uploadButton = driver.findElement(By.name("upload"));
        uploadButton.click();

        //todo: add assertion
    }
}
