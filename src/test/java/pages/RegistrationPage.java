package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerAs(String userName, String mail, String password) {
        WebElement userInput = driver.findElement(By.cssSelector("input[type='text']"));
        userInput.sendKeys(userName);

        WebElement emailInput = driver.findElement(By.cssSelector("input[type='email']"));
        emailInput.sendKeys(mail);

        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
        passwordInput.sendKeys(password);

        WebElement registerButton = driver.findElement(By.cssSelector("button.btn-primary"));
        registerButton.click();
    }

    public String getLoggedUserName() {
        WebElement registeredUser = driver.findElement(By.xpath("//img[@class='user-pic']/.."));
        return registeredUser.getText();
    }
}
