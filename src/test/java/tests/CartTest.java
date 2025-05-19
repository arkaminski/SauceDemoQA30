package tests;
import org.testng.annotations.Test;
import pages.CartPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class CartTest extends tests.BaseTest {

    @Test
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
    public void checkAddedProductsPrice() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.openCart();
        assertEquals(cartPage.getProductPrice(0), 29.99);
    }
}
