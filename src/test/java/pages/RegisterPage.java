package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private final By nameInput = By.xpath("//label[text()='Имя']/following::input[1]");
    private final By emailInput = By.xpath("//label[text()='Email']/following::input[1]");
    private final By passwordInput = By.xpath("//input[@type='password']");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By passwordError = By.xpath("//*[contains(text(),'Некорректный пароль')]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void register(String name, String email, String password) {
        type(nameInput, name);
        type(emailInput, email);
        type(passwordInput, password);
        click(registerButton);
    }

    public boolean isPasswordErrorVisible() {
        try {
            return waitVisible(passwordError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}