package tests;

import org.junit.Test;
import org.junit.Before;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;
import api.UserApi;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationTests extends BaseTest {

    String email;
    String password;

    @Before
    public void createUser() {
        String[] user = UserApi.createUser();
        email = user[0];
        password = user[1];
    }

    @Test
    public void logoutFromProfile() {

        MainPage main = new MainPage(driver);
        LoginPage login = new LoginPage(driver);
        ProfilePage profile = new ProfilePage(driver);

        main.clickLogin();

        login.login(email, password);

        // ждём НЕ login страницу, но аккуратно
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.not(
                        ExpectedConditions.urlContains("login")));

        main.openProfile();

        profile.logout();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("login"));
    }
}