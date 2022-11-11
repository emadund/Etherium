package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterNewAccount extends BaseTest {
    @FindBy (css=".alert.alert-info")
    WebElement submitted;

    public RegisterNewAccount () {

        PageFactory.initElements(driver, this);
    }

    public String getSubmittingText () {
        wdWait.until(ExpectedConditions.visibilityOf(submitted));
        return submitted.getText();
    }
    public boolean submittingTextIsDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(submitted));
        return submitted.isDisplayed();
    }
}
