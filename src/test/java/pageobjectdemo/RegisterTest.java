package pageobjectdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;
public class RegisterTest {
    private static WebDriver driver;
    @BeforeClass
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://react-redux.realworld.io/#register");
    }

    @Test
    void userShouldRegisterSuccessfully() {
        // warunki początkowe - utwórz obiekt
        RegistrationPage regPage = new RegistrationPage(driver);

        // wygenerowanie emaila i nazwy użytkownika
        String emailAndUser = "michal+" + System.currentTimeMillis() + "@gmail.com";

        // rejestracja
        regPage.registerAs(emailAndUser, emailAndUser, "password")
                .validateThatUserNameIs(emailAndUser);

//        // asercja - sprawdź czy się zarejestrował
//        assertThat(regPage.getLoggedUserName())
//                .isEqualTo(emailAndUser);
    }

    @AfterClass
    static void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


}
