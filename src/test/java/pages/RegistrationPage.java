package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.*;

public class RegistrationPage {
    private WebDriver driver;

    @FindBy(css = "input[type='text']")
    private WebElement userInput;

    @FindBy(css = "input[type='email']")
    private WebElement emailInput;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;

    @FindBy(css = "button.btn-primary")
    private WebElement registerButton;

    @FindBy(xpath = "//img[@class='user-pic']/..")
    private WebElement registeredUser;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage registerAs(String userName, String mail, String password) {
        userInput.sendKeys(userName);
        emailInput.sendKeys(mail);
        passwordInput.sendKeys(password);
        registerButton.click();
        // strona zwraca samą siebie
        return this;
    }

    public void innaFunkcjaWpisujacaTylkoEmail(String badEmail) {
        emailInput.sendKeys(badEmail);
    }

    public void validateThatUserNameIs(String expectedUser) {
        assertThat(registeredUser.getText()).isEqualTo(expectedUser);
    }

    public String getLoggedUserName() {
        return registeredUser.getText();
    }
}
