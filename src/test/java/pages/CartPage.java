package pages;

import org.openqa.selenium.WebDriver;

import static pages.BasePage.BASE_URL;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }
}
