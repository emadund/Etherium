package page;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailinatorPage extends BaseTest {

    @FindBy (xpath = "(//*[@aria-label=\"Enter public inbox\"])[1]")
    WebElement publicInbox;

    @FindBy (xpath = "//*[contains(text(),\"Please confirm your email\")]")
    WebElement inbox;

    @FindBy (id="html_msg_body")
    WebElement iframe;

    @FindBy (partialLinkText="https://etherscan.io/confirmemail?")
    WebElement linkConfirmation;


    public MailinatorPage () {
        PageFactory.initElements(driver, this);
    }

    public void enterEmail (String x) {
        wdWait.until(ExpectedConditions.visibilityOf(publicInbox));
        publicInbox.clear();
        publicInbox.sendKeys(x);
        publicInbox.sendKeys(Keys.ENTER);
    }

    public void clickInbox () {
        wdWait.until(ExpectedConditions.elementToBeClickable(inbox));
        inbox.click();
    }

    public void confirmLink () {
        wdWait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
        js.executeScript("window.scrollBy(0,500)");
        wdWait.until(ExpectedConditions.visibilityOf(linkConfirmation));
        linkConfirmation.click();
        driver.switchTo().defaultContent();
    }

}
