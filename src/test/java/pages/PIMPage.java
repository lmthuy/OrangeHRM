package pages;

import DataTest.ConstantData;
import driver.DriverManager;
import org.apache.hc.core5.net.WWWFormCodec;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Log;
import utils.WebUI;

import javax.print.DocFlavor;

public class PIMPage extends CommonPage {

    By buttonAddEmployee = By.xpath("//a[normalize-space()='Add Employee']");
    By inputFirstName = By.xpath("//input[@placeholder='First Name']");
    By inputLastName = By.xpath("//input[@placeholder='Last Name']");
    By buttonSave = By.xpath("//button[@type='submit']");
    By nationality = By.xpath("(//div[@class='oxd-select-text-input'][normalize-space()='-- Select --'])[1]");
    By martialStatus = By.xpath("(//i)[8]");
    By selectGender = By.xpath("//label[normalize-space()='Male']");

    By inputDriverLicense = By.xpath("(//input[@class='oxd-input oxd-input--active'])[5]");
    By inputLicenseExpiryDate = By.xpath("(//input[@placeholder='yyyy-mm-dd'])[1]");
    By inputSSNNumber = By.xpath("(//input)[10]");
    By inputSinNumber = By.xpath("(//input)[11]");
    By inputDateOfBirth = By.xpath("(//input[@placeholder='yyyy-mm-dd'])[2]");
    By checkLastName = By.xpath("(//div[contains(text(),'Lam')])[1]");
    By checkFirstName = By.xpath("(//div[contains(text(),'Nguyen')])[1]");
    By editJob = By.xpath("//a[normalize-space()='Job']");
    By inputJoinedDate = By.xpath("//input[@placeholder='yyyy-mm-dd']");
    By inputJobTitle = By.xpath("(//div[contains(text(),'-- Select --')])[1]");
    By inputJobCategory = By.xpath("(//div[contains(text(),'-- Select --')])[2]");
    By inputSubUnit = By.xpath("(//div[contains(text(),'-- Select --')])[3]");
    By inputLocation = By.xpath("(//div[contains(text(),'-- Select --')])[4]");
    By inputEmployeeStatus = By.xpath("(//div[contains(text(),'-- Select --')])[5]");
    By inputEmployeeID = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");


    public void addEmployee() {
        WebUI.clickElement(buttonAddEmployee);
        WebUI.sleep(5);
        WebUI.setText(inputFirstName, ConstantData.FIRSTNAME);
        WebUI.setText(inputLastName, ConstantData.LASTNAME);
        WebUI.clickElement(buttonSave);
        WebUI.sleep(7);
        //Personal Details
        WebUI.clickElement(inputJobTitle);
        WebUI.sleep(5);
        WebUI.setText(inputDriverLicense, "451227846");
        WebUI.setText(inputLicenseExpiryDate, "2025-10-10");
        WebUI.setText(inputSSNNumber, "023647863");
        WebUI.setText(inputSinNumber, "03648711");
        WebUI.clickElement(nationality);
        WebUI.sleep(7);
        WebElement toSelectNationality = DriverManager.getDriver().findElement(nationality);
        WebUI.pressV();
        WebUI.sleep(2);
        toSelectNationality.sendKeys(Keys.ARROW_DOWN);
        toSelectNationality.sendKeys(Keys.ENTER);

        WebUI.clickElement(martialStatus);
        WebUI.sleep(2);
        WebUI.pressM();
        WebUI.setText(inputDateOfBirth, "1989-10-10");
        WebUI.clickElement(selectGender);
        WebUI.clickElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[1]"));

        //Job

        WebUI.clickElement(editJob);
        WebUI.sleep(5);
        WebUI.setText(inputJoinedDate, "2022-12-08");

        WebUI.waitForPageLoaded();
        WebUI.clickElement(inputJobCategory);
        WebUI.pressT();
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath("(//i)[9]"));
        WebUI.sleep(2);
      //  WebElement toSelectSubUnit = DriverManager.getDriver().findElement(By.xpath("(//i)[9]"));
        WebUI.pressQ();
        WebUI.sleep(3);

        WebUI.waitForPageLoaded();

        WebUI.clickElement(By.xpath("(//i)[10]"));
        WebUI.sleep(2);
       // WebElement toSelectLocation = DriverManager.getDriver().findElement(By.xpath("(//i)[10]"));
        WebUI.pressT();
        WebUI.sleep(3);
;

        WebUI.waitForPageLoaded();
        WebUI.clickElement(By.xpath("(//i)[7]"));
        WebUI.pressQ();
        WebUI.sleep(2);


        WebUI.clickElement(buttonSave);

        WebUI.openURL("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        WebUI.sleep(7);
        WebElement element = DriverManager.getDriver().findElement(checkFirstName);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
        WebUI.sleep(3);
        boolean verifyFirstName = WebUI.checkElementExist(checkFirstName);
        WebUI.verifyTrue(verifyFirstName, "Fail to add new employee");
        WebUI.sleep(3);
        boolean verifyLastName = WebUI.checkElementExist(checkLastName);
        WebUI.verifyTrue(verifyLastName, "Fail to add new employee");
    }
}
