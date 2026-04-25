package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage extends BasePage {

    private final By buns = By.xpath("//span[text()='Булки']/parent::div");
    private final By sauces = By.xpath("//span[text()='Соусы']/parent::div");
    private final By fillings = By.xpath("//span[text()='Начинки']/parent::div");

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

    public void openBuns() {
        click(buns);
    }

    public void openSauces() {
        click(sauces);
    }

    public void openFillings() {
        click(fillings);
    }

    public boolean isBunsTabActive() {
        return driver.findElement(buns).getAttribute("class").contains("current");
    }

    public boolean isSaucesTabActive() {
        return driver.findElement(sauces).getAttribute("class").contains("current");
    }

    public boolean isFillingsTabActive() {
        return driver.findElement(fillings).getAttribute("class").contains("current");
    }
}