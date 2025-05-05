import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LocatorTest extends BaseTest {

    @Test
    public void checkLocatorsLoginPage() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("user-name"));
        driver.findElement(By.className("error-message-container"));
        driver.findElement(By.tagName("div"));

        driver.findElement(By.linkText("Sauce Labs Bike Light"));
        driver.findElement(By.partialLinkText("Sauce"));
        driver.findElement(By.xpath("//div[@data-test='inventory-item-desc']"));
        driver.findElement(By.xpath("//div[text()='9.99']"));
        driver.findElement(By.xpath("//a[contains(@data-test,'test')]"));
        driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs')]"));
        driver.findElement(By.xpath("//*[@id='item_0_title_link']//ancestor::a"));
        driver.findElement(By.xpath("//*[@id='item_0_title_link']//descendant::div"));
        driver.findElement(By.xpath("//div[@id='header_container']" +
                "/following::div[@class='inventory_item_price']"));
        driver.findElement(By.xpath("//button[@type='button']/parent::*"));


        driver.findElement(By.cssSelector(".inventory_item_name"));
        driver.findElement(By.cssSelector(".inventory_item .inventory_item_name"));
        driver.findElement(By.cssSelector("#inventory_container"));
        driver.findElement(By.cssSelector("div.pricebar"));
        driver.findElement(By.cssSelector("div[data-test='inventory-item-name']"));
        driver.findElement(By.cssSelector("div[data-test~='inventory-item-name']"));
        driver.findElement(By.cssSelector("[data-test|='item-1']"));
        driver.findElement(By.cssSelector("[data-test^='inventory']"));
        driver.findElement(By.cssSelector("[class$='item']"));
        driver.findElement(By.cssSelector("[data-test*='item']"));
    }
}
