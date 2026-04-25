package tests;
import api.UserApi;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;
import pages.RegisterPage;
import java.util.UUID;

public class AuthTests extends BaseTest {

    private String email;
    private final String password = "Qwerty123!";

    @Test
    public void successRegister() {
        MainPage main = new MainPage(driver);
        main.clickLogin();
        driver.findElement(org.openqa.selenium.By.xpath("//a[text()='Зарегистрироваться']")).click();
        RegisterPage register = new RegisterPage(driver);

        email = "user_" + UUID.randomUUID() + "@mail.com";
        register.register("Madina", email, password);
        register.waitUrlContains("login");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @After
    public void cleanUp() {
        if (email != null) {
            String token = UserApi.getToken(email, password);
            UserApi.deleteUser(token);
        }
    }

    @Test
    public void invalidPassword() {

        MainPage main = new MainPage(driver);
        main.clickLogin();
        driver.findElement(org.openqa.selenium.By.xpath("//a[text()='Зарегистрироваться']")).click();
        RegisterPage register = new RegisterPage(driver);
        register.register("Madina", "test@mail.com", "123");
        Assert.assertTrue(register.isPasswordErrorVisible());
    }
}