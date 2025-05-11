package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest{

    @Test
    public void addFourProductsToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.addProduct("Sauce Labs Bolt T-Shirt");
        productsPage.addProduct("Sauce Labs Fleece Jacket");
        productsPage.openCart();
        assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"));
        assertTrue(cartPage.isProductInCart("Sauce Labs Bike Light"));
        assertTrue(cartPage.isProductInCart("Sauce Labs Bolt T-Shirt"));
        assertTrue(cartPage.isProductInCart("Sauce Labs Fleece Jacket"));
    }
}
