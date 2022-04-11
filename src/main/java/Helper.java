import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Helper extends Init {

    public static WebElement waitForElementClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static Boolean waitForUrlContains(String text) {
        return wait.until(ExpectedConditions.urlContains(text));
    }

    public static WebElement waitForRefreshAndClickable(By by) {
        return wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
    }

    public static Boolean waitForTextPresent(By by, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
    }
}
