import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Init {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private ChromeOptions options;

    public WebDriver InitWebDriver() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--headless");
//        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        InitWebDriverWait();
        return driver;
    }

    public WebDriver InitWebDriverGrid() throws MalformedURLException {
        options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
//        driver.manage().window().maximize();
        InitWebDriverWait();
        return driver;
    }

    public WebDriver InitWebDriverDocker() throws MalformedURLException {
        options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
//        driver.manage().window().maximize();
        InitWebDriverWait();
        return driver;
    }

    public void InitWebDriverWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
