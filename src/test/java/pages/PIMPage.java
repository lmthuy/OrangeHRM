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
    By nationality = By.xpath("(//i)[7]");
    By martialStatus = By.xpath("(//i)[8]");
    By selectGender = By.xpath("//label[normalize-space()='Male']");

    By inputSSNNumber = By.xpath("(//input)[10]");
    By inputSinNumber = By.xpath("(//input)[11]");

    By checkLastName = By.xpath("(//div[contains(text(),'Lam')])[1]");
    By checkFirstName = By.xpath("(//div[contains(text(),'Nguyen')])[1]");

    By editJob = By.xpath("//a[normalize-space()='Job']");

    By inputJobCategory = By.xpath("(//div[contains(text(),'-- Select --')])[2]");
    By inputNational = By.xpath("(//div[contains(text(),'-- Select --')])[1]");


    By jobTitle = By.xpath("(//div[contains(text(),'QA Engineer')])[1]");

    By sortID = By.xpath("(//div[@role='columnheader'])[2]/child::div[1]");
    By inputDriverLicense = By.xpath("(//input[@class='oxd-input oxd-input--active'])[5]");


    By selectDecending = By.xpath("(//span[@class='oxd-text oxd-text--span'][normalize-space()='Decending'])[1]");

    public void addEmployee() {
        clickElement(buttonAddEmployee);
        setText(inputFirstName, ConstantData.FIRSTNAME);
        setText(inputLastName, ConstantData.LASTNAME);
        clickElement(buttonSave);

        //Personal Details
        waitForPageLoaded();
        waitForElementPresent(inputDriverLicense);
        setText(inputDriverLicense, "2571557577");

        setText(inputSSNNumber, "023647863");
        setText(inputSinNumber, "03648711");

        clickElement(inputNational);
        waitForElementVisible(nationality);

        WebElement toSelectNationality = DriverManager.getDriver().findElement(inputNational);
        pressV();
        sleep(2);
        setArrowDown(toSelectNationality);
        pressENTER();


        clickElement(martialStatus);
        waitForPageLoaded();
        pressM();
        pressENTER();
        clickElement(selectGender);
        clickElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[1]"));

        //Job

        clickElement(editJob);
        sleep(2);
        waitForElementVisible(inputJobCategory);
        clickElement(inputJobCategory);
        pressT();
        clickElement(By.xpath("(//i)[9]"));
        pressE();

        waitForElementVisible(By.xpath("(//i)[10]"));

        clickElement(By.xpath("(//i)[10]"));
        pressT();

        waitForPageLoaded();
        clickElement(By.xpath("(//i)[7]"));
        pressQ();
        pressENTER();

        clickElement(By.xpath("(//i)[11]"));
        pressP();
        waitForPageLoaded();
        pressENTER();
        clickElement(buttonSave);

        openURL("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        waitForPageLoaded();

        clickElement(sortID);
        clickElement(selectDecending);

        boolean verifyJobTitle = checkElementExist(jobTitle);
        verifyTrue(verifyJobTitle, "Fail to add new employee");
        sleep(1);
        boolean verifyFirstName = checkElementExist(checkFirstName);
        verifyTrue(verifyFirstName, "Fail to add new employee");
        sleep(1);
        boolean verifyLastName = checkElementExist(checkLastName);
        verifyTrue(verifyLastName, "Fail to add new employee");
    }
}
