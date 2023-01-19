package common;

import driver.DriverManager;
import helpers.PropertiesHelpers;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.TestListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.CommonPage;

import java.io.File;
import java.io.IOException;

@Listeners(TestListener.class)
public class BaseTest extends CommonPage {

    //Luôn chạy trước trong 1 class
    public BaseTest() {
        PropertiesHelpers.loadAllFiles();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public static void createDriver(@Optional("chrome") String browserName) {
        WebDriver driver = setupBrowser(browserName);
        DriverManager.setDriver(driver);
    }


    public static WebDriver setupBrowser(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private static WebDriver initChromeDriver() {
        WebDriver driver;
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=es");
        ChromeDriver driver1 = new ChromeDriver(options);
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public static void closeDriver(ITestResult result) {
        //Chụp màn hình khi Fail
        if (result.getStatus() == ITestResult.FAILURE) {

            TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();

            File source = ts.getScreenshotAs(OutputType.FILE);
            File theDir = new File("./Screenshots/");
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
            try {
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Screenshot taken: " + result.getName());

        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }

}

