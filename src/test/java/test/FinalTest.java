package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import page.*;
import java.util.Random;


public class FinalTest extends BaseTest {
    private HomePage homePage;
    private RegisterNewAccount registerNewAccount;
    private MailinatorPage mailinatorPage;
    private ConfirmationYourEmail confirmationYourEmail;
    private NewTab newTab;
    private final String myUsername = "mark";
    private final String myTestPassword = "Ot4a%";
    private Random ran = new Random();
    static String longText (int i) {
        String pom=new String();
        for (int j=0;j<i;j++) {
            pom+=""+(int)(Math.random()*10);
        }
        return pom;
    }

    private String[] testUsername={"h"+(ran.nextInt(8999)+1000),10000+ran.nextInt(89999)+"L",
    "v"+longText(28),""+longText(29)+"0"};

    private String eMail = "dundaetf" + ran.nextInt(99999) + "@mailinator.com";

    private final char[] testChars = {' ', '!', '+'};

    @Before

    public void preparation() {
        homePage = new HomePage();
        registerNewAccount = new RegisterNewAccount();
        mailinatorPage = new MailinatorPage();
        confirmationYourEmail = new ConfirmationYourEmail();
        newTab = new NewTab();
    }


    public void positiveUsername (String x)  // Method for different usernames testing
    {
        homePage.clickCookie();
        homePage.inputUsername(x);
        homePage.inputEmail(eMail);
        homePage.inputConfirmationMail(eMail);
        homePage.scrollDown();
        homePage.inputPassword(myTestPassword+"!");
        homePage.inputConfirmationPassword(myTestPassword+"!");
        homePage.checkTermsAndCondition();
        homePage.checkRobot();
        try {
    Thread.sleep(10000); //If banner images show, images clicking required manually in order to continue test!
            homePage.clickCreateAnAccount();
            Assert.assertTrue(registerNewAccount.submittingTextIsDisplayed());
            Assert.assertEquals("Your account registration has been submitted and is pending email verification"
                    , registerNewAccount.getSubmittingText());
            driver.switchTo().newWindow(WindowType.TAB);
            driver.navigate().to("https://www.mailinator.com/");
            mailinatorPage.enterEmail(eMail);
            mailinatorPage.clickInbox();
            mailinatorPage.confirmLink();
            confirmationYourEmail.moveToNewTab();
            Assert.assertTrue(confirmationYourEmail.isConfirmationRegistrationDisplayed());
            Assert.assertEquals("Congratulations! Your account is successfully verified.\n" +
                    "You may proceed to log in with your user ID and password.\n" +
                    "Enjoy your Etherscan Services!", confirmationYourEmail.confirmationRegistrationText());

        }
        catch (Exception e) {
            System.out.println("Captcha interferes! Not possible to do registration without completing captcha images");
        }

    }
    @Test

    public void positiveTestCase11 () {  // Username length 5
       this.positiveUsername(testUsername[0]);
    }
    @Test

    public void positiveTestCase12 () {  // Username length 6
        this.positiveUsername(testUsername[1]);
    }
    @Test

    public void positiveTestCase13 () {  // Username length 29
        this.positiveUsername(testUsername[2]);
    }
    @Test

    public void positiveTestCase14 () {  // Username length 30

        this.positiveUsername(testUsername[3]);
    }

    @Test
    public void negativeTestCase21 () //All fields left empty
    {   homePage.clickCookie();
    homePage.scrollDown();
    homePage.clickCreateAnAccount();
    Assert.assertTrue(homePage.isUserNameTextDisplayed());
    Assert.assertEquals("Username is invalid.",homePage.userNameTextGetText());
    Assert.assertTrue(homePage.isEmailTextDisplayed());
    Assert.assertEquals("Please enter a valid email address.", homePage.emailTextGetText());
    Assert.assertTrue(homePage.isEmailConfirmartionTextDisplayed());
    Assert.assertEquals("Please re-enter your email address.",homePage.emailConfirmationTextGetText());
    Assert.assertTrue(homePage.isPasswordTextDisplayed());
    Assert.assertEquals("Your password must be at least 5 characters long.",homePage.passwordTextGetText());
    Assert.assertTrue(homePage.isConfirmPasswordTextDisplayed());
    Assert.assertEquals("Your password must be at least 5 characters long."
    ,homePage.confirmPasswordTextGetText());
    Assert.assertTrue(homePage.isAcceptTermsTextDisplayed());
    Assert.assertEquals("Please accept our Terms and Conditions.",homePage.acceptTermsGetText());
    }
    @Test
    public void negativeTestCase22 () // invalid username inputs
    {
        homePage.clickCookie();
        homePage.inputEmail(eMail);
        homePage.inputConfirmationMail(eMail);
        homePage.inputPassword(myTestPassword);
        homePage.inputConfirmationPassword(myTestPassword);
        homePage.checkTermsAndCondition();
        homePage.clickCreateAnAccount();
        Assert.assertTrue(homePage.isUserNameTextDisplayed());
        Assert.assertEquals("Username is invalid.",homePage.userNameTextGetText());
        for (char x:testChars) {
            homePage.inputUsername(x);
            Assert.assertTrue(homePage.isUserNameTextDisplayed());
            Assert.assertEquals("Username is invalid.", homePage.userNameTextGetText());
            homePage.inputUsername(myUsername + x);
            Assert.assertTrue(homePage.isUserNameTextDisplayed());
            Assert.assertEquals("Username is invalid.", homePage.userNameTextGetText());
        }
        for (char x:testChars) {
            homePage.inputUsername(x);
            Assert.assertTrue(homePage.isUserNameTextDisplayed());
            Assert.assertEquals("Username is invalid.", homePage.userNameTextGetText());
            homePage.inputUsername(x+myUsername);
            Assert.assertTrue(homePage.isUserNameTextDisplayed());
            Assert.assertEquals("Username is invalid.", homePage.userNameTextGetText());
        }
    }
    @Test
    public void negativeTestCase23 () // invalid email and confirmation email inputs
    {   homePage.clickCookie();
        homePage.inputUsername(myUsername+"o");
        homePage.inputPassword(myTestPassword+"!");
        homePage.inputConfirmationPassword(myTestPassword+"!");
        homePage.checkTermsAndCondition();
        homePage.checkNewsletters();
        homePage.scrollDown();
        homePage.clickCreateAnAccount();
        Assert.assertTrue(homePage.isEmailTextDisplayed());
        Assert.assertEquals("Please enter a valid email address.", homePage.emailTextGetText());
        homePage.inputEmail("on purpose wrong");
        homePage.inputConfirmationMail("on purpose wrong");
        Assert.assertTrue(homePage.isEmailTextDisplayed());
        Assert.assertEquals("Please enter a valid email address.", homePage.emailTextGetText());
        homePage.inputEmail("on purpose wrong@gmail.com");
        homePage.inputConfirmationMail("on purpose wrong@gmail.com");
        Assert.assertTrue(homePage.isEmailTextDisplayed());
        Assert.assertEquals("Please enter a valid email address.", homePage.emailTextGetText());
        homePage.inputEmail("on_purpose_wrong@gma!il.com");
        homePage.inputConfirmationMail("on_purpose_wrong@gma!il.com");
        Assert.assertTrue(homePage.isEmailTextDisplayed());
        Assert.assertEquals("Please enter a valid email address.", homePage.emailTextGetText());
        homePage.inputEmail("on purpose_wrong@gmail.com");
        homePage.inputConfirmationMail("on purpose_wrong@gmail.com");
        Assert.assertTrue(homePage.isEmailTextDisplayed());
        Assert.assertEquals("Please enter a valid email address.", homePage.emailTextGetText());
        homePage.inputEmail(eMail);
        homePage.inputConfirmationMail("mismatched_mail@gmail.com");
        Assert.assertTrue(homePage.isEmailConfirmartionTextDisplayed());
        Assert.assertEquals("Email address does not match.", homePage.emailConfirmationTextGetText());
    }
    @Test
    public void negativeTestCase24 () // invalid inputs for password and confirmation password
    {   homePage.clickCookie();
        homePage.inputUsername(myUsername);
        homePage.inputEmail(eMail);
        homePage.inputConfirmationMail(eMail);
        homePage.checkTermsAndCondition();
        homePage.checkNewsletters();
        homePage.scrollDown();
        homePage.clickCreateAnAccount();
        Assert.assertTrue(homePage.isPasswordTextDisplayed());
        Assert.assertEquals("Your password must be at least 5 characters long.",homePage.passwordTextGetText());
        homePage.inputPassword("Ot4!");
        homePage.inputConfirmationPassword("Ot4!");
        Assert.assertTrue(homePage.isPasswordTextDisplayed());
        Assert.assertEquals("Your password must be at least 5 characters long.",homePage.passwordTextGetText());
        homePage.inputPassword(myTestPassword+"!");
        homePage.inputConfirmationPassword("mismatched on purpose");
        Assert.assertTrue(homePage.isConfirmPasswordTextDisplayed());
    Assert.assertEquals("Password does not match, please check again.",homePage.confirmPasswordTextGetText());
    }
    @Test
    public void negativeTestCase25 () // invalid checking mandatory checkboxes
    {   homePage.clickCookie();
        homePage.inputUsername(myUsername+"o");
        homePage.inputEmail(eMail);
        homePage.inputConfirmationMail(eMail);
        homePage.inputPassword(myTestPassword+"!");
        homePage.inputConfirmationPassword(myTestPassword+"!");
        homePage.scrollDown();
        homePage.clickCreateAnAccount();
        Assert.assertTrue(homePage.isAcceptTermsTextDisplayed());
        Assert.assertEquals("Please accept our Terms and Conditions.",homePage.acceptTermsGetText());
        homePage.checkNewsletters();
        homePage.clickCreateAnAccount();
        Assert.assertTrue(homePage.isAcceptTermsTextDisplayed());
        Assert.assertEquals("Please accept our Terms and Conditions.",homePage.acceptTermsGetText());
        homePage.checkTermsAndCondition();
        homePage.clickCreateAnAccount();
        Assert.assertTrue(homePage.errorIsDisplayed());
        Assert.assertEquals("Error! Invalid captcha response.\n" +
        "Please Try Again", homePage.errorText());
    }
    @Test
    public void inspectButtonsForSameTab () // checking several other elements opening new page in the same tab
    {   homePage.clickCookie();
        homePage.clickOnGasIcon();
        Assert.assertTrue(homePage.isGasTrackerDisplayed());
        Assert.assertEquals("Ethereum Gas Tracker",homePage.gasTrackerText());
        driver.navigate().back();
        homePage.clickHome();
        Assert.assertTrue(homePage.blockchainIsDisplayed());
        Assert.assertEquals("The Ethereum Blockchain Explorer",homePage.blockchainText());
        driver.navigate().back();
        homePage.clickApi1();
        Assert.assertTrue(homePage.apiIsDisplayed());
        Assert.assertEquals("API Pricing Plans",homePage.apiText());
        driver.navigate().back();
    }
    @Test
    public void inspectButtonsForNewTab () // checking several other elements opening new page in the new tab
    {
        homePage.clickCookie();
        homePage.clickTokens();
        newTab.moveToNewTab();
        Assert.assertTrue(newTab.aaxIsDisplayed());
        driver.close();
        newTab.moveToPreviousTab();
        homePage.clickSepolia();
        newTab.moveToNewTab();
        Assert.assertTrue(newTab.sepoliaDisplayed());
        Assert.assertEquals("Sepolia Testnet Explorer",newTab.sepoliaGetText());
        driver.close();
        newTab.moveToPreviousTab();
        homePage.clickReddit();
        newTab.moveToNewTab();
        Assert.assertTrue(newTab.redditDisplayed());
        Assert.assertEquals("Etherscan.io - Ethereum Block Explorer and Analytics Site",newTab.redditGetText());
    }
}
