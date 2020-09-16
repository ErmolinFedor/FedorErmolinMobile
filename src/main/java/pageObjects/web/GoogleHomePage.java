package pageObjects.web;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage {
    AppiumDriver appiumDriver;

    @FindBy(css = "input[name=q]")
    WebElement inputField;

    public GoogleHomePage(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
        this.appiumDriver = appiumDriver;
    }

    public void open() {
        appiumDriver.get("http://google.com");
    }

    public void waiting() {
        new WebDriverWait(appiumDriver, 20).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
    }

    public void search(String string) {
        waiting();
        inputField.sendKeys(string);
        inputField.sendKeys(Keys.ENTER);
    }

    public GoogleResultsPage getResultPage() throws InterruptedException {
        waiting();
        return new GoogleResultsPage(appiumDriver);
    }
}
