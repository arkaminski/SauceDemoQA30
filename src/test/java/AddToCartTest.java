import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddToCartTest extends BaseTest {

    @Test
    public void checkAddToCart() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@data-test='username']"))
                .sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@data-test='password']"))
                .sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        //String products = driver.findElement(By.xpath("//span[@data-test='title']")).getText();
        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(products, "Products");
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']")).click();
        //String cartPage = driver.findElement(By.cssSelector(".title")).getText();
        //softAssert.assertEquals(cartPage, "Your Cart");
        String nameOfItem = driver.findElement(By.xpath(
                "//*[@id=\"item_0_title_link\"]/div")).getText();
        softAssert.assertEquals(nameOfItem, "Sauce Labs Bike Light");
        String priceForItem = driver.findElement(By.xpath(
                "//div[@data-test='inventory-item-price']")).getText();
        softAssert.assertEquals(priceForItem, "$9.99");
        softAssert.assertAll();
    }
}
