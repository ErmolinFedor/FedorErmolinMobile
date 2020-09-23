package scenarios;

import org.testng.annotations.Test;
import pageObjects.nativePages.EpamBudgetActivityPage;
import pageObjects.nativePages.EpamRegistrationPage;
import pageObjects.nativePages.EpamStartPage;
import setup.BaseTest;
import util.ConfigProperties;

import static org.testng.Assert.assertTrue;

public class nativeMobileTests extends BaseTest{
    @Test(groups = {"native"}, description = "Registered new user and logged in as a new user ")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException, InterruptedException {

        String email = ConfigProperties.getProperty("properties/user.properties", "Email");
        String userName = ConfigProperties.getProperty("properties/user.properties", "UserName");
        String password = ConfigProperties.getProperty("properties/user.properties", "Password");
        String expectedPageTitle = ConfigProperties.getProperty("properties/nativeTest.properties", "pageTitle");

        EpamStartPage epamStartPage = new EpamStartPage(getDriver());

        EpamRegistrationPage epamRegistrationPage = epamStartPage.clickRegisterButton();
        epamRegistrationPage.fillForm(email, userName, password);
        EpamBudgetActivityPage epamBudgetActivityPage = epamStartPage.fillForm(email, password);

        assertTrue(
                epamBudgetActivityPage.getNavigationBarElements().stream()
                        .anyMatch(we -> we.getText().contains(expectedPageTitle))
        );

    }
}
