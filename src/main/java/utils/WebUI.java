package utils;

import com.aventstack.extentreports.Status;
import driver.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import reports.AllureManager;
import reports.ExtentTestManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.time.Duration;
import java.util.List;

public class WebUI {
    private final static int Timeout = 0;
    private final static double Step_Time = 1;
    private final static int Page_Load_Timeout = 5;

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Page_Load_Timeout), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    }

    @Step("Open URL: {0}")
    public static void openURL(String url) {
        DriverManager.getDriver().get(url);
        sleep(Step_Time);
        Log.info("Open: " + url);
        ExtentTestManager.logMessage(Status.PASS, "Open URL: " + url);

        AllureManager.saveTextLog("Open: " + url);

        waitForPageLoaded();
    }

    public static boolean pressENTER() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean pressI() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_I);
            robot.keyRelease(KeyEvent.VK_I);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pressV() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean pressQ() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_Q);
            robot.keyRelease(KeyEvent.VK_Q);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean pressT() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean pressM() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_M);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean pressF() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F);
            robot.keyRelease(KeyEvent.VK_F);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public static java.util.List<WebElement> getWebElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    @Step("Verify Equals: {0} and {1}")
    public static void verifyEquals(Object actual, Object expected) {
        waitForPageLoaded();
        sleep(Step_Time);
        Log.info("Verify equals: " + actual + " and " + expected);
        ExtentTestManager.logMessage(Status.PASS, "Verify equals: " + actual + " and " + expected);
        Assert.assertEquals(actual, expected, "Fail. Not match. '" + actual.toString() + "' != '" + expected.toString() + "'");
    }

    public static void verifyTrue(Object actual, String message) {
        waitForPageLoaded();
        sleep(Step_Time);
        Assert.assertTrue((Boolean) actual, message);
    }


    @Step("Click element: {0}")
    public static void clickElement(By by) {
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(Step_Time);
        getWebElement(by).click();
        Log.info("Click element: " + by);
        ExtentTestManager.logMessage(Status.PASS, "Click element: " + by);
        AllureManager.saveTextLog("Click element: " + by);
    }

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Timeout), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Log.error("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void waitForElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Timeout), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            Log.error("Element not exist. " + by.toString());
            Assert.fail("Element not exist. " + by.toString());
        }
    }


    @Step("Set text {1} on {0}")
    public static void setText(By by, String value) {
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(Step_Time);
        getWebElement(by).sendKeys(value);
        Log.info("Set text: " + value + " on element " + by);
        ExtentTestManager.logMessage(Status.PASS, "Set text: " + value + " on element " + by);
    }

    @Step("Get text of element {0}")
    public static String getElementText(By by) {
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(Step_Time);
        String text = getWebElement(by).getText();
        Log.info("Get text: " + text);
        ExtentTestManager.logMessage(Status.PASS, "Get text: " + text);
        return text; //Trả về một giá trị kiểu String
    }

    public static Boolean checkElementExist(By by) {
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(2);
        List<WebElement> listElement = getWebElements(by);

        if (listElement.size() > 0) {
            System.out.println("checkElementExist: " + true + " --- " + by);
            return true;
        } else {
            System.out.println("checkElementExist: " + false + " --- " + by);
            return false;
        }
    }

    public static boolean moveToElement(By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            Log.info(e.getMessage());
            return false;
        }
    }
    public static void scrollToElement(By element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(fail);", getWebElement(element));
    }


}
