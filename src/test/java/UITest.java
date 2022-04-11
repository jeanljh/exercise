import org.testng.annotations.*;

import java.net.MalformedURLException;

public class UITest extends Setup {
    @BeforeTest
    @Parameters("runGrid")
    public void setup(@Optional("runGrid") String runGrid) throws MalformedURLException{
        Setup setup = new Setup();
        if (runGrid == "grid")
            setup.InitWebDriverGrid();
        else
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
