package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Task6 {
    @Test
    void downloadFile() {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", "C:\\downloads\\");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://testpages.herokuapp.com/styled/download/download.html");
        WebElement directDownloadButton = driver.findElement(By.id("direct-download"));
        directDownloadButton.click();

        // trick: musimy poczekać 2 sekundy bo inaczej zamkniemy przeglądarkę zanim skończy pobierać plik ;)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
