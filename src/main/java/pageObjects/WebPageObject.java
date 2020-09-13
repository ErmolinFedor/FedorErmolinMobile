package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject {
    @FindBy(xpath = "//input[@name='q']")
    WebElement searchField;
    @FindBy(xpath = "//button[@class='Tg7LZd']")
    WebElement searchButton;
    @FindBy(css = "div[id='rso']>div")
    WebElement results;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);

    }
}
