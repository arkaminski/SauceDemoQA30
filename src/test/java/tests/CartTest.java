package tests;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends tests.BaseTest {

    @Test
    @Epic("Корзина")
    @Feature("Добавление товара")
    @Story("Отображения товара в корзине")
    @Severity(SeverityLevel.CRITICAL)
    @Owner ("Артур Каминский")
    @Description("Проверка добавление товара в корзину")
    @Link(name = "документация", url = "https://www.saucedemo.com/")
    @TmsLink("TMS_1")
    @Issue("TMS_2")
    public void checkCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.openCart();
        assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"),
                "Товар не добавлен в корзину");
    }

    @Test(testName = "Добавление товара в корзину", priority = 2, groups = "Cart Page")
    @Owner("Artur Kaminski")
    @Link(name = "Documentation", url = "https://www.saucedemo.com/")
    @TmsLink("TMS-2")
    @Issue("TMS-3")
    public void deleteFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.openCart();
        assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"),
                "Товар не добавлен в корзину");
        cartPage.removeProduct("Sauce Labs Backpack");
        assertTrue(cartPage.checkEmptyState(), "Корзина не пуста");
    }

    @Test(testName = "Возврат на страницу Products из корзины", priority = 2, groups = "Cart Page")
    @Owner("Artur Kaminski")
    @Link(name = "Documentation", url = "https://www.saucedemo.com/")
    @TmsLink("TMS-3")
    @Issue("TMS-4")
    public void checkContinueShoppingButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.openCart();
        assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"),
                "Товар не добавлен в корзину");
        cartPage.continueShopping();
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test(testName = "Проверка добавленного товара по стоимости", priority = 3, groups = "Cart Page")
    @Owner("Artur Kaminski")
    @Link(name = "Documentation", url = "https://www.saucedemo.com/")
    @TmsLink("TMS-5")
    @Issue("TMS-6")
    public void checkAddedProductsPrice() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.openCart();
        assertEquals(cartPage.getProductPrice(0), 29.99);
    }
}
