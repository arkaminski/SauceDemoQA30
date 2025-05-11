package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    
    public final By REMOVE_BUTTON = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    public final By CONTINUE_SHOPPING = By.xpath("//button[@id='continue-shopping']");
    private static final By PRODUCTS_PRICE = By.xpath(
            "//div[@class= 'cart_item']/descendant::div[@class = 'inventory_item_price']");
    
    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }
    
    public void remove() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING).click();
    }

    public boolean isProductInCart(String product) {
        return driver.findElement(By.xpath(String.format("//*[@class = 'cart_item']//*[text() = '%s']", product)))
                .isDisplayed();
        }
    public Double getProductPrice(int index) {
        List<WebElement> productsName = driver.findElements(PRODUCTS_PRICE);
        return Double.parseDouble(productsName.get(index).getText()
                .substring(productsName.get(index).getText().indexOf('$') + 1));
    }
    }
