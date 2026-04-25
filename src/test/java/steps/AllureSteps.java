package steps;

import io.qameta.allure.Step;

public class AllureSteps {

    @Step("Открыть главную страницу")
    public void openMainPage() {}

    @Step("Войти в аккаунт")
    public void login(String email) {}

    @Step("Проверить переход в личный кабинет")
    public void checkProfile() {}
}
