import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class UITest extends Setup {
    @BeforeTest
    public void setup() {
        Setup setup = new Setup();
        setup.InitWebDriver();

    }

    @Test
    public void firstTest() {
        driver.get("https://amazon.in");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
