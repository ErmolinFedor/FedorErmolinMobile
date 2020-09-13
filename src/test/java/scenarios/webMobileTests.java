package scenarios;

import org.openqa.selenium.JavascriptExecutor;;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;
import util.ConfigProperties;

import java.util.List;
import static org.testng.Assert.assertTrue;

public class webMobileTests extends BaseTest {

    public static final String QUERY_TEXT = "EPAM";

    @Test(groups = {"web"}, description = "Make sure that we've opened Google homepage")
    public void simpleWebTest() throws InterruptedException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        // open Google homepage
        getDriver().get(ConfigProperties.getProperty("URL"));

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        getPo().getWelement("searchField").sendKeys(QUERY_TEXT);
        getPo().getWelement("searchButton").click();
        List<WebElement> actualResults = getPo().getWelements("results");
        //check that result is not empty
        assertTrue(!actualResults.isEmpty());

    }

}
