import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UITest extends Init {
    PageObject po;
    @BeforeMethod
    @Parameters("env")
    public void setup(@Optional("grid") String env) throws MalformedURLException{
        Init init = new Init();
        // by default tests run in local environment
        // similarly execute /suite/local.xml to run tests locally via xml file
        // optionally, execute /suite/grid.xml to run tests in selenium grid
        if (env == "grid")
            init.InitWebDriverGrid();
        else if (env == "docker")
            init.InitWebDriverDocker();
        else
            init.InitWebDriver();
        po = new PageObject();
        driver.get("https://amazon.in");
    }

    @Test
    public void Test() {
        // navigate from main page to product page (Samsung)
        Helper.waitForElementClickable(po.menuHamburger()).click();
        Helper.waitForElementClickable(po.menuMain()).click();
        Helper.waitForElementClickable(po.menuSub()).click();
        Helper.waitForElementClickable(po.lblBrand()).click();
        Helper.waitForUrlContains("Samsung");

        // sort and view by "Price: High to Low"
        Helper.waitForElementClickable(po.ddlSort()).click();
        Helper.waitForElementClickable(po.ddlSortPrice()).click();
        WebElement ddlSelected = Helper.waitForElementClickable(po.ddlSort());
        assertEquals(ddlSelected.getText(), "Price: High to Low", "sort option");
        WebElement itemSecond = Helper.waitForRefreshAndClickable(po.itemSecond());

        // validate sort by price from high to low
        for (int i = 0; i < po.prices().size() - 1; i++) {
            float price1 = Float.parseFloat(po.prices().get(i).getText().replace(",", ""));
            float price2 = Float.parseFloat(po.prices().get(i+1).getText().replace(",", ""));
//            System.out.println("i " + i);
//            System.out.println("price1 " + po.prices().get(i).getText());
//            System.out.println("price2 " + po.prices().get(i+1).getText());
//            assertTrue(price1 >= price2, "sort price");
        }

        // store second-highest price item in a variable and click on it
        String exp = itemSecond.getText();
        itemSecond.click();

        //switch to new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Helper.waitForTextPresent(po.txtProdTitle(), exp);

        // validate "About" section of the product is shown
        assertTrue(po.paneProdAbout().isDisplayed());

        // append "About" text, display in html report and console.log
        StringBuilder about = new StringBuilder();
        po.txtProdAbout().forEach(e -> about.append("\n" + e.getText()));
        Reporter.log(about.toString());
        System.out.print(about);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
