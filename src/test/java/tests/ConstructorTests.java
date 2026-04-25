package tests;
import org.junit.Assert;
import org.junit.Test;
import pages.ConstructorPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ConstructorTests extends BaseTest {

    @Test
    public void checkSaucesTab() {
        ConstructorPage page = new ConstructorPage(driver);
        page.openSauces();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> page.isSaucesTabActive());
        Assert.assertTrue(page.isSaucesTabActive());
    }

    @Test
    public void checkFillingsTab() {
        ConstructorPage page = new ConstructorPage(driver);
        page.openFillings();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> page.isFillingsTabActive());
        Assert.assertTrue(page.isFillingsTabActive());
    }

    @Test
    public void checkBunsTab() {
        ConstructorPage page = new ConstructorPage(driver);

        page.openSauces(); // уходим с дефолтной вкладки
        page.openBuns();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> page.isBunsTabActive());
        Assert.assertTrue(page.isBunsTabActive());
    }
}