package pageObjects.nativePages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EpamBudgetActivityPage {
    @AndroidFindBy(xpath = "//*[contains(@text, 'BudgetActivity')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/*")
    private List<WebElement> navigationBarElements;

    public EpamBudgetActivityPage(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public List<WebElement> getNavigationBarElements() {
        return navigationBarElements;
    }
}
