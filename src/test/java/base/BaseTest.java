package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {  // Base Class for initialisation Google Chrome browser

    protected static WebDriver driver;
    protected static WebDriverWait wdWait;  // waiting for Webelements to appear
    protected static JavascriptExecutor js; // for scrolling window

    @Before

    public  void initialSetup () {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        wdWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://etherscan.io/register");
    }
 /*   @After
    public void tearDown() {   // To shutdown browsers after tests finished
        driver.close();
        driver.quit();
    } */


}
