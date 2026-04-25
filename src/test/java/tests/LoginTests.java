package tests;
import api.UserApi;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTests extends BaseTest {

    String email;
    String password;

    @Before
    public void createUser() {
        String[] user = UserApi.createUser();
        email = user[0];
        password = user[1];
    }

    @Test
    public void loginFromMainButton() {

        MainPage main = new MainPage(driver);
        main.clickLogin();

        new LoginPage(driver).login(email, password);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.not(
                        ExpectedConditions.urlContains("login")));

        Assert.assertFalse(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void loginFromProfileButton() {

        MainPage main = new MainPage(driver);
        main.openProfile();

        new LoginPage(driver).login(email, password);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.not(
                        ExpectedConditions.urlContains("login")));

        Assert.assertFalse(driver.getCurrentUrl().contains("login"));
    }
}