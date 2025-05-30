package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage extends BasePage {

    public final By REMOVE_BUTTON = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    public final By CONTINUE_SHOPPING = By.xpath("//button[@id='continue-shopping']");
    private static final By PRODUCTS_PRICE = By.xpath(
            "//div[@class= 'cart_item']/descendant::div[@class = 'inventory_item_price']");

    public CartPage(WebDriver driver) {
        super(driver);
        }

    @Step("Открытие страницы Корзина")
    public void open() {
        driver.get(BASE_URL + "/cart.html");
        }

    @Step("Нажатие 'удалить' на странице корзины")
    public void remove() {
        driver.findElement(REMOVE_BUTTON).click();
        }

    @Step("Нажатие 'Continue Shopping' на странице корзины")
    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING).click();
    }

    public boolean isProductInCart(String product) {
        return driver.findElement(By.xpath(String.format("//*[@class = 'cart_item']//*[text() = '%s']", product)))
                .isDisplayed();
        }

    public Double getProductPrice(int index) {
        List<WebElement> productsName = driver.findElements(PRODUCTS_PRICE);
        return Double.parseDouble(productsName.get(index)
                .getText()
                .substring(productsName.get(index)
                        .getText()
                        .indexOf('$') + 1));
        }

    public void removeProduct(String product) {
        driver.findElement(By.xpath(String.format("//button[@id='remove-sauce-labs-backpack']", product))).click();
        }

    public boolean checkEmptyState() {
        return driver.findElements(By.xpath("//div[@class='cart_item']")).isEmpty();
        }
    }
