package tests;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductsTest extends tests.BaseTest {

    @Test(testName = "Проверка добавления нескольких товаров в корзину",
            description = "Проверка добавления 4 товаров в корзину",
            priority = 1,
            groups = "Products Page")
    @Owner("Artur Kaminski")
    @Link(name = "Documentation", url = "https://www.saucedemo.com/")
    @TmsLink("TMS-11")
    @Issue("TMS-12")
    public void addFourProductsToCart() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.addProduct("Sauce Labs Bolt T-Shirt");
        productsPage.addProduct("Sauce Labs Fleece Jacket");
        productsPage.openCart();
        softAssert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"));
        softAssert.assertTrue(cartPage.isProductInCart("Sauce Labs Bike Light"));
        softAssert.assertTrue(cartPage.isProductInCart("Sauce Labs Bolt T-Shirt"));
        softAssert.assertTrue(cartPage.isProductInCart("Sauce Labs Fleece Jacket"));
        softAssert.assertAll();
    }
}
