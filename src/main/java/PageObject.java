import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObject extends Init {
    public By menuHamburger() {
        return By.id("nav-hamburger-menu");
    }

    public By menuMain() {
        return By.xpath("//div[text()='TV, Appliances, Electronics']");
    }

    public By menuSub() {
        return By.xpath("//a[text()='Televisions']");
    }

    public By lblBrand() {
        return By.xpath("//span[text()='Samsung']");
    }

    public By ddlSort() {
        return By.cssSelector("#a-autoid-0-announce > span.a-dropdown-prompt");
    }

    public By ddlSortPrice() {
        return By.xpath("//a[text()='Price: High to Low']");
    }

    public By itemSecond() {
        return By.cssSelector("div[data-index='2'] span.a-text-normal");
    }

    public By txtProdTitle() {
        return By.id("productTitle");
    }

    public List<WebElement> prices() {
        return driver.findElements(By.cssSelector("div[cel_widget_id] > div.s-card-container span.a-price-whole"));
    }

    public WebElement paneProdAbout() {
        return driver.findElement(By.cssSelector("#feature-bullets > ul"));
    }

    public List<WebElement> txtProdAbout() {
        return driver.findElements(By.cssSelector("#feature-bullets span.a-list-item"));
    }
}
