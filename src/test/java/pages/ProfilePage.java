package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage {

    private final By logoutButton = By.xpath("//*[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void logout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton))
                .click();
    }
}