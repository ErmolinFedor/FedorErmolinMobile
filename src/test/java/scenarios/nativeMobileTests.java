package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;
import util.ConfigProperties;

public class nativeMobileTests extends BaseTest{
    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException, InterruptedException {

        getPo().getWelement("registerButton").click();
        getPo().getWelement("registrationEmail").sendKeys(ConfigProperties.getProperty("Email"));
        getPo().getWelement("registrationUserName").sendKeys(ConfigProperties.getProperty("UserName"));
        getPo().getWelement("registrationPassword").sendKeys(ConfigProperties.getProperty("Password"));
        getPo().getWelement("registrationConfirmPassword").sendKeys(ConfigProperties.getProperty("Password"));
        getPo().getWelement("registerNewAccountButton").click();
        getPo().getWelement("loginEmail").sendKeys(ConfigProperties.getProperty("Email"));
        getPo().getWelement("loginPassword").sendKeys(ConfigProperties.getProperty("Password"));
        getPo().getWelement("signInButton").click();
        String pageText = getPo().getWelement("pageText").getText();
        System.out.println(pageText);
        Assert.assertEquals(pageText, "BudgetActivity");
        System.out.println("Simple Android native test done");

    }
}
