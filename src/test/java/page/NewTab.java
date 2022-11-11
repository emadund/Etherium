package page;

import base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class NewTab extends BaseTest {

    @FindBy (css = ".MuiSvgIcon-root.jss4")
    WebElement aax;

    @FindBy (xpath="//*[contains(text(),\"Sepolia Testnet Explorer \")]")
    WebElement sepoliaTestnet;

    @FindBy (xpath = "//*[@class=\"_2yYPPW47QxD4lFQTKpfpLQ\"]")
    WebElement reddit;

    public NewTab () {
        PageFactory.initElements(driver, this);
    }
    public void moveToNewTab () {
        wdWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    public void moveToPreviousTab () {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }
    public boolean aaxIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(aax));
        return aax.isDisplayed();
    }
    public boolean sepoliaDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(sepoliaTestnet));
        return sepoliaTestnet.isDisplayed();
    }
    public String sepoliaGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(sepoliaTestnet));
        return sepoliaTestnet.getText();
    }
    public boolean redditDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(reddit));
        return reddit.isDisplayed();
    }
    public String redditGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(reddit));
        return reddit.getText();
    }

}
