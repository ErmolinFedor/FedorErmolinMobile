package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.nativePages.EpamBudgetActivityPage;
import pageObjects.nativePages.EpamRegistrationPage;
import pageObjects.nativePages.EpamStartPage;
import setup.BaseTest;
import util.ConfigProperties;

public class nativeMobileTests extends BaseTest{
    @Test(groups = {"native"}, description = "Registered new user and logged in as a new user ")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException, InterruptedException {

        String email = ConfigProperties.getProperty("user.properties", "Email");
        String userName = ConfigProperties.getProperty("user.properties", "UserName");
        String password = ConfigProperties.getProperty("user.properties", "Password");
        String expectedPageTitle = ConfigProperties.getProperty("nativeTest.properties", "pageTitle");

        EpamStartPage epamStartPage = new EpamStartPage(getDriver());

        EpamRegistrationPage epamRegistrationPage = epamStartPage.clickRegisterButton();
        epamRegistrationPage.fillForm(email, userName, password);
        EpamBudgetActivityPage epamBudgetActivityPage = epamStartPage.fillForm(email, password);

        String pageText = epamBudgetActivityPage.getPageText();

        Assert.assertEquals(pageText, expectedPageTitle);

        System.out.println("Registered User Android native test done");

    }
}
