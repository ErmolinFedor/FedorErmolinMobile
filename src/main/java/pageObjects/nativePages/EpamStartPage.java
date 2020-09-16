package pageObjects.nativePages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EpamStartPage {
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement registerButton;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private WebElement loginEmail;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private WebElement loginPassword;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    private WebElement signInButton;
    private AppiumDriver appiumDriver;

    public EpamStartPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public EpamRegistrationPage clickRegisterButton() {
        registerButton.click();
        return new EpamRegistrationPage(appiumDriver);
    }

    public EpamBudgetActivityPage fillForm(String email, String password) {
        loginEmail.sendKeys(email);
        loginPassword.sendKeys(password);
        signInButton.click();
        return new EpamBudgetActivityPage(appiumDriver);
    }
}
