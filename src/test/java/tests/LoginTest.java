package tests;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Retry;
import static org.testng.Assert.assertEquals;

public class LoginTest extends tests.BaseTest {

    @Test(retryAnalyzer = Retry.class)
    @Epic("Autorization")
    @Feature("Login Page")
    @Story("Login")
    @Owner("Artur Kaminski")
    @Link(name = "Documentation", url = "https://www.saucedemo.com/")
    @TmsLink("TMS-7")
    @Issue("TMS-8")
    public void checkSuccessLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test(testName = "Логин без пароля",
            description = "Проверка отображения сообщения не вводя пароль",
            priority = 2,
            groups = "Login Page")
    @Owner("Artur Kaminski")
    @Link(name = "Documentation", url = "https://www.saucedemo.com/")
    @TmsLink("TMS-8")
    @Issue("TMS-9")
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Логин не выполнен");
    }

    @Test(testName = "Логин с валидными данными",
            description = "Проверка логина с валидными данными",
            priority = 1,
            groups = "Login Page")
    @Owner("Artur Kaminski")
    @Link(name = "Documentation", url = "https://www.saucedemo.com/")
    @TmsLink("TMS-9")
    @Issue("TMS-10")
    public void checkLoginWithWrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "1243143143");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Логин не выполнен");
    }

    @Test(testName = "Проверка логина без данных",
            description = "Проверка сообщения без заполнения обязательных полей",
            priority = 2,
            groups = "Login Page")
    @Owner("Artur Kaminski")
    @Link(name = "Documentation", url = "https://www.saucedemo.com/")
    @TmsLink("TMS-10")
    @Issue("TMS-11")
    public void checkLoginWithEmptyUser() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Логин не выполнен");
    }

    @DataProvider(name = "Неrативные тесты для логина")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"standard_user", "1243143143", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Неrативные тесты для логина")
    public void login(String user, String password, String message) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(),message,
                "Unexpected result");
    }
}
