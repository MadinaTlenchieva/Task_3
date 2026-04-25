package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        waitOverlayDisappear();
        waitClickable(locator).click();
    }

    protected void jsClick(By locator) {
        waitOverlayDisappear();
        WebElement el = waitVisible(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    protected void type(By locator, String text) {
        WebElement el = waitVisible(locator);
        el.clear();
        el.sendKeys(text);
    }

    public void waitUrlContains(String part) {
        wait.until(ExpectedConditions.urlContains(part));
    }

    protected void waitOverlayDisappear() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.className("Modal_modal_overlay__x2ZCr")));
        } catch (Exception ignored) {}
    }
}