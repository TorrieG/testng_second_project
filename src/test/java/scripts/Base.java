package scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.UASearchPage;
import utilities.Driver;

public class Base {
    WebDriver driver;
    WebDriverWait explicitWait;
    SoftAssert softAssert;
    Actions actions;
    JavascriptExecutor js;
    UASearchPage uaSearchPage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 30);
        softAssert = new SoftAssert();
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        driver.get("https://www.united.com/en/us");
        uaSearchPage = new UASearchPage(driver);

    }

    @AfterMethod
    public void teardown(){
        softAssert.assertAll();
        Driver.quitDriver();
    }
}
