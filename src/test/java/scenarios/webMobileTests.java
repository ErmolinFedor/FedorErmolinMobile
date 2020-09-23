package scenarios;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.web.GoogleHomePage;
import pageObjects.web.GoogleResultsPage;
import setup.BaseTest;
import util.ConfigProperties;

import java.util.List;
import static org.testng.Assert.assertTrue;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Check that google search has no empty results")
    public void simpleWebTest() throws InterruptedException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        String query = ConfigProperties.getProperty("properties/webTest.properties","QUERY");

        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());

        // open Google homepage and make sure that page has been loaded completely
        googleHomePage.open();
        //Typing "EPAM"
        googleHomePage.search(query);
        //Get Results from resultsPage
        GoogleResultsPage googleResultsPage = googleHomePage.getResultPage();
        List<WebElement> results = googleResultsPage.getResults();
        //Assert that list isn't empty
        assertTrue(!results.isEmpty());

        System.out.println("Android Web test done");
    }

}

