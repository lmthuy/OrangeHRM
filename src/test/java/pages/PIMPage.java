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

import static utils.WebUI.*;

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
    By checkJobTitle = By.xpath("(//div[contains(text(),'QA Engineer')])[1]");
    By editJob = By.xpath("//a[normalize-space()='Job']");
    By inputJoinedDate = By.xpath("//input[@placeholder='yyyy-mm-dd']");
    By inputJobTitle = By.xpath("(//div[contains(text(),'-- Select --')])[1]");
    By inputJobCategory = By.xpath("(//div[contains(text(),'-- Select --')])[2]");
    By inputSubUnit = By.xpath("(//div[contains(text(),'-- Select --')])[3]");
    By inputLocation = By.xpath("(//div[contains(text(),'-- Select --')])[4]");
    By inputEmployeeStatus = By.xpath("(//div[contains(text(),'-- Select --')])[5]");
    By inputEmployeeID = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By ID = By.xpath("//div[contains(text(),'0456')]");

    By sortID = By.xpath("(//div[@role='columnheader'])[2]/child::div[1]");
    By selectDecending = By.xpath("(//span[@class='oxd-text oxd-text--span'][normalize-space()='Decending'])[1]");

    public void addEmployee() {
        clickElement(buttonAddEmployee);
        sleep(5);
        setText(inputFirstName, ConstantData.FIRSTNAME);
        setText(inputLastName, ConstantData.LASTNAME);
        WebElement toEdit = DriverManager.getDriver().findElement(inputEmployeeID);
        toEdit.sendKeys(Keys.CONTROL + "a");
        toEdit.sendKeys(Keys.DELETE);
        toEdit.sendKeys("0456");
        clickElement(buttonSave);
        sleep(7);
        //Personal Details
        clickElement(inputJobTitle);
        sleep(3);

        setText(inputLicenseExpiryDate, "2025-10-10");
        setText(inputSSNNumber, "023647863");
        setText(inputSinNumber, "03648711");
        clickElement(nationality);
        sleep(7);
        WebElement toSelectNationality = DriverManager.getDriver().findElement(nationality);
        pressV();
        sleep(2);
        toSelectNationality.sendKeys(Keys.ARROW_DOWN);
        toSelectNationality.sendKeys(Keys.ENTER);

        clickElement(martialStatus);
        sleep(2);
        pressM();
        setText(inputDateOfBirth, "1989-10-10");
        clickElement(selectGender);
        clickElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[1]"));

        //Job

        clickElement(editJob);
        sleep(5);
        setText(inputJoinedDate, "2022-12-08");

        waitForPageLoaded();
        clickElement(inputJobCategory);
        pressT();
        sleep(2);
        clickElement(By.xpath("(//i)[9]"));
        sleep(2);
        pressE();
        sleep(3);

        waitForPageLoaded();

        clickElement(By.xpath("(//i)[10]"));
        sleep(2);
        pressT();
        sleep(2);

        waitForPageLoaded();
        clickElement(By.xpath("(//i)[7]"));
        pressQ();
        pressENTER();

        clickElement(By.xpath("(//i)[11]"));
        pressP();
        sleep(5);
        pressENTER();
        clickElement(buttonSave);

        openURL("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        sleep(6);

        clickElement(sortID);
        sleep(2);
        clickElement(selectDecending);
        sleep(2);
        WebElement getID = DriverManager.getDriver().findElement(ID);
        String actualID = getID.getText();
        sleep(2);
        verifyEquals(actualID,"0456");

        boolean verifyFirstName = checkElementExist(checkFirstName);
        verifyTrue(verifyFirstName, "Fail to add new employee");
        sleep(3);
        boolean verifyLastName = checkElementExist(checkLastName);
        verifyTrue(verifyLastName, "Fail to add new employee");




    }
}
