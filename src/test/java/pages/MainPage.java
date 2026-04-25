package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By profileButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By logo = By.xpath("//a[contains(@href,'/')]");

    private final By bunsTab = By.xpath("//span[text()='Булки']/parent::div");
    private final By saucesTab = By.xpath("//span[text()='Соусы']/parent::div");
    private final By fillingsTab = By.xpath("//span[text()='Начинки']/parent::div");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void openProfile() {
        jsClick(profileButton);
    }

    public void clickLogo() {
        jsClick(logo);
    }

    public void clickBuns() {
        jsClick(bunsTab);
    }

    public void clickSauces() {
        jsClick(saucesTab);
    }

    public void clickFillings() {
        jsClick(fillingsTab);
    }
}