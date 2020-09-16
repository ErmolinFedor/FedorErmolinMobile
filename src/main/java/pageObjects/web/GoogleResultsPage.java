package pageObjects.web;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleResultsPage {
    @FindBy(css = "div[id='rso']>div")
    private List<WebElement> results;

    public GoogleResultsPage(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean resultIsDisplayed() {
        return results != null;
    }

    public List<WebElement> getResults() {
        return results;
    }
}
