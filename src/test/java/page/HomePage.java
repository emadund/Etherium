package page;

import base.BaseTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BaseTest {

    Actions hover = new Actions (driver);   // for hovering Webelements through dropdown menu

    @FindBy (id="ContentPlaceHolder1_txtUserName")
    WebElement username;

    @FindBy (id="ContentPlaceHolder1_txtEmail")
    WebElement email;

    @FindBy (id="ContentPlaceHolder1_txtConfirmEmail")
    WebElement mailConfirmation;

    @FindBy (css="[name=\"ctl00$ContentPlaceHolder1$txtPassword\"]")
    WebElement password;

    @FindBy (css="#ContentPlaceHolder1_txtPassword2")
    WebElement passwordConfirmation;

    @FindBy (xpath="//*[contains(text(),\"I agree to the\")] ")
    WebElement termsConditions;

    @FindBy (xpath="//*[contains(text(),\"I agree to receive\")]")
    WebElement newsletter;

    @FindBy (css="[title=\"reCAPTCHA\"]")
    WebElement iframe;

    @FindBy (xpath = "//*[contains(text(),\"I'm not a robot\")] ")
    WebElement robot;

    @FindBy (xpath = "//*[@value='Create an Account']")
    WebElement createAccount;

    @FindBy (id="btnCookie")
    WebElement cookie;

    @FindBy (css="#ContentPlaceHolder1_txtUserName-error")
    WebElement userNameText;

    @FindBy (css="#ContentPlaceHolder1_txtEmail-error")
    WebElement emailText;

    @FindBy (css="#ContentPlaceHolder1_txtConfirmEmail-error")
    WebElement confirmEmailText;

    @FindBy (css="#ContentPlaceHolder1_txtPassword-error")
    WebElement passwordText;

    @FindBy (css="#ContentPlaceHolder1_txtPassword2-error")
    WebElement confirmPasswordText;

    @FindBy (xpath = "//*[contains(text(),\"Please accept our Terms and Conditions.\")]")
    WebElement acceptTermsText;

    @FindBy (css="[class=\"text-nowrap\"]")
    WebElement signin;

    @FindBy (xpath = "(//*[contains(text(),\"API Documentation\")])[2]")
    WebElement apiDocumentation;

    @FindBy (css = ".alert.alert-danger")
    WebElement error;

    @FindBy (css=".fad.fa-gas-pump.ml-1 ")
    WebElement gasIcon;
    @FindBy (xpath = "(//*[contains(text(),\"Ethereum Gas Tracker\")])[2]")
    WebElement gasTracker;

    @FindBy (css="[class=\"nav-item u-header__nav-item\"]")
    WebElement home;

    @FindBy (css="[class=\"h4 text-white mb-3\"]")
    WebElement blockchain;

    @FindBy (id="LI_resources")
    WebElement resources;

    @FindBy (xpath = "(//*[@href=\"/apis\"])[1]")
    WebElement api1;

    @FindBy (css = ".js-go-to.btn.btn-sm.btn-primary.font-size-base")
    WebElement apiPrice;

    @FindBy (css="[name=\"f\"]")
    WebElement allFilters;

    @FindBy (css="[value=\"2\"]")
    WebElement tokens;

    @FindBy (xpath = "(//*[@class=\"mr-2\"])[2]")
    WebElement temporary;

    @FindBy (css=".u-xs-avatar.btn-icon__inner")
    WebElement ice;

    @FindBy (xpath = "//*[contains(text(),\"Sepolia Testnet\")]")
    WebElement sepolia;

    @FindBy (css=".fab.fa-reddit-alien.btn-icon__inner")
    WebElement reddit;

    public HomePage () {
        PageFactory.initElements(driver, this);
    }

    public void clickCookie () {
        if (cookie.isDisplayed()) {
        cookie.click(); }
    }
    public void inputUsername (char x) {
        wdWait.until(ExpectedConditions.visibilityOf(username));
        username.clear();
        username.sendKeys(String.valueOf(x));
            }
    public void inputUsername (String x) {
        wdWait.until(ExpectedConditions.visibilityOf(username));
        username.clear();
        username.sendKeys(x);

    }

    public void inputEmail (String x) {
        wdWait.until(ExpectedConditions.visibilityOf(email));
        email.clear();
        email.sendKeys(x);

    }
    public void inputConfirmationMail (String x) {
        wdWait.until(ExpectedConditions.visibilityOf(mailConfirmation));
        mailConfirmation.clear();
        mailConfirmation.sendKeys(x);

    }
    public void inputPassword (String x) {
        wdWait.until(ExpectedConditions.visibilityOf(password));
        password.clear();
        password.sendKeys(x);

    }
    public void inputConfirmationPassword (String x) {
        wdWait.until(ExpectedConditions.visibilityOf(passwordConfirmation));
        passwordConfirmation.clear();
        passwordConfirmation.sendKeys(x);

    }

    public void checkTermsAndCondition () {
        wdWait.until(ExpectedConditions.visibilityOf(termsConditions));
        if (!termsConditions.isSelected()) termsConditions.click();
    }
    public void checkNewsletters () {
        wdWait.until(ExpectedConditions.elementToBeClickable(newsletter));
        if (!newsletter.isSelected()) newsletter.click();
    }
    public void scrollDown () {
        js.executeScript("window.scrollBy(0,300)");
            }
    public void checkRobot () {
        wdWait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
        wdWait.until(ExpectedConditions.elementToBeClickable(robot));
        robot.click();
        driver.switchTo().defaultContent();
    }

   public void clickCreateAnAccount () {
        wdWait.until(ExpectedConditions.elementToBeClickable(createAccount));
        createAccount.click();
    }
    public boolean isUserNameTextDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(userNameText));
        return username.isDisplayed();
    }
    public String userNameTextGetText () {
        wdWait.until(ExpectedConditions.visibilityOf(userNameText));
        return userNameText.getText();

    }
    public boolean isEmailTextDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(emailText));
        return emailText.isDisplayed();
    }
    public String emailTextGetText () {
        wdWait.until(ExpectedConditions.visibilityOf(emailText));
        return emailText.getText();

    }
    public boolean isEmailConfirmartionTextDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(confirmEmailText));
        return confirmEmailText.isDisplayed();
    }
    public String emailConfirmationTextGetText () {
        wdWait.until(ExpectedConditions.visibilityOf(confirmEmailText));
        return confirmEmailText.getText();

    }
    public boolean isPasswordTextDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(passwordText));
        return passwordText.isDisplayed();
    }
    public String passwordTextGetText () {
        wdWait.until(ExpectedConditions.visibilityOf(passwordText));
        return passwordText.getText();
    }
    public boolean isConfirmPasswordTextDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(confirmPasswordText));
        return confirmPasswordText.isDisplayed();
    }
    public String confirmPasswordTextGetText () {
        wdWait.until(ExpectedConditions.visibilityOf(confirmPasswordText));
        return confirmPasswordText.getText();
    }
    public boolean isAcceptTermsTextDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(acceptTermsText));
        return acceptTermsText.isDisplayed();
    }
    public String acceptTermsGetText () {
        wdWait.until(ExpectedConditions.visibilityOf(acceptTermsText));
        return acceptTermsText.getText();
    }
    public void clickOnGasIcon () {
        wdWait.until(ExpectedConditions.visibilityOf(gasIcon));
        gasIcon.click();
    }
    public boolean isGasTrackerDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(gasTracker));
        return gasTracker.isDisplayed();
    }
    public String gasTrackerText () {
        wdWait.until(ExpectedConditions.visibilityOf(gasTracker));
        return gasTracker.getText();
    }
    public boolean errorIsDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(error));
        return error.isDisplayed();
    }
    public String errorText () {
        wdWait.until(ExpectedConditions.visibilityOf(error));
        return error.getText();
    }
    public void clickHome () {
        wdWait.until(ExpectedConditions.visibilityOf(home));
        home.click();
    }
    public boolean blockchainIsDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(blockchain));
        return blockchain.isDisplayed();
    }
    public String blockchainText () {
        wdWait.until(ExpectedConditions.visibilityOf(blockchain));
        return blockchain.getText();
    }

    public void clickApi1 () {
        wdWait.until(ExpectedConditions.visibilityOf(resources));
        hover.moveToElement(resources).perform();
        hover.moveToElement(api1).perform();
        api1.click();
    }
    public boolean apiIsDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(apiPrice));
        return apiPrice.isDisplayed();
    }

    public String apiText () {
        wdWait.until(ExpectedConditions.visibilityOf(apiPrice));
        return apiPrice.getText();
    }
    public void clickTokens() {
        wdWait.until(ExpectedConditions.visibilityOf(allFilters));
        allFilters.click();
        wdWait.until(ExpectedConditions.visibilityOf(tokens));
        tokens.click();
        wdWait.until(ExpectedConditions.visibilityOf(temporary));
        temporary.click();
    }
    public void clickSepolia () {
        wdWait.until(ExpectedConditions.visibilityOf(ice));
        hover.moveToElement(ice).perform();
        hover.moveToElement(sepolia).perform();
        sepolia.click();
    }
    public void clickReddit () {
        wdWait.until(ExpectedConditions.visibilityOf(reddit));
        reddit.click();
    }
}
