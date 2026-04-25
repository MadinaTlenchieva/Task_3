package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class WebDriverFactory {

    public static WebDriver create(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        }

        if (browser.equalsIgnoreCase("yandex")) {
            System.setProperty("webdriver.chrome.driver", "drivers/yandexdriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Yandex\\YandexBrowser\\Application\\browser.exe");
            return new ChromeDriver(options);
        }

        throw new RuntimeException("Browser not supported");
    }
}