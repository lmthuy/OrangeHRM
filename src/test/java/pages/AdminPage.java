package pages;

import DataTest.ConstantData;
import com.sun.source.tree.AssertTree;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.Log;
import utils.WebUI;

import static org.testng.Assert.assertTrue;
import static utils.WebUI.*;

import java.awt.*;
import java.awt.event.InputEvent;
import java.security.Key;

public class AdminPage extends CommonPage {
    By buttonAdd = By.xpath("//button[normalize-space()='Add']");
    By sectionJob = By.xpath("//span[normalize-space()='Job']");
    By selectJobTitles = By.xpath("//a[normalize-space()='Job Titles']");
    By inputInfor = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By inputJobDescription = By.xpath("//textarea[@placeholder='Type description here']");
    By inputNote = By.xpath("//textarea[@placeholder='Add note']");
    By messageSuccess = By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");
    By buttonSave = By.xpath("//button[@type='submit']");
    By selectEmploymentStatus = By.xpath("//a[normalize-space()='Employment Status']");
    By selectJobCategories = By.xpath("//a[normalize-space()='Job Categories']");
    By sectionOrganization = By.xpath("(//i[@class='oxd-icon bi-chevron-down'])[3]");
    By selectLocation = By.xpath("//a[normalize-space()='Locations']");
    By selectDrowdownList = By.xpath("//div[@class='oxd-select-text-input']");
    By selectCountry = By.xpath("(//label[normalize-space()='Country']/parent::div)/following-sibling::div[normalize-space()='Albania']");

    By buttonDelete = By.xpath("(//i[@class='oxd-icon bi-trash'])[2]");
    By buttonYesDelete = By.xpath("//button[normalize-space()='Yes, Delete']");
    By buttonEdit = By.xpath("(//i[@class='oxd-icon bi-pencil-fill'])[6]");
    By inputName = By.xpath("(//input[@placeholder='Type here ...'])[1]");
    By inputCity = By.xpath("(//input[@placeholder='Type here ...'])[2]");
    By inputPhone = By.xpath("//input[@modelmodifiers='[object Object]']");
    By userRole = By.xpath("(//div[contains(text(),'-- Select --')])[1]");
    By inputEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    By status = By.xpath("(//div[contains(text(),'-- Select --')])[2]");
    By inputPassword = By.xpath("(//input[@type='password'])[1]");
    By confirmPassword = By.xpath("(//input[@type='password'])[2]");
    By profilePicture = By.xpath("//img[@alt='profile picture']");
    By buttonLogout = By.xpath("//a[normalize-space()='Logout']");


    public void addJobTitle() {
        waitForPageLoaded();
        clickElement(sectionJob);
        sleep(3);
        clickElement(selectJobTitles);
        sleep(5);
        clickElement(buttonAdd);
        sleep(5);
        setText(inputInfor, "Automation QA Engineer");
        setText(inputJobDescription, "Contact directly Mr.Wu for JD");
        setText(inputNote, "We will contact with suitable candidates");
        clickElement(buttonSave);
        sleep(10);
        boolean checkText = checkElementExist(By.xpath("//div[contains(text(),'Automation QA Engineer')]"));
        verifyTrue(checkText, "Fail to add Job Title");
        sleep(5);
    }

    public void addJobCategory() {
        sleep(3);
        clickElement(sectionJob);
        sleep(3);
        clickElement(selectJobCategories);
        sleep(5);
        clickElement(buttonAdd);
        sleep(5);
        setText(inputInfor, "HRBP");
        clickElement(buttonSave);
        sleep(10);
        boolean checkText = checkElementExist(By.xpath("//div[contains(text(),'HRBP')]"));
        verifyTrue(checkText, "Fail to add Job Category");
        sleep(5);
    }

    public void addEmploymentStatus() {
        sleep(3);
        clickElement(sectionJob);
        sleep(3);
        clickElement(selectEmploymentStatus);
        sleep(5);
        clickElement(buttonAdd);
        sleep(5);
        setText(inputInfor, "Full-Time Internship");
        clickElement(buttonSave);
        sleep(10);
        boolean checkText = checkElementExist(By.xpath("//div[contains(text(),'Full-Time Internship')]"));
        verifyTrue(checkText, "Fail to add Employee Status");
        sleep(5);
    }

    public void deleteEmployeeStatus() {
        sleep(3);
        clickElement(sectionJob);
        sleep(3);
        clickElement(selectEmploymentStatus);
        sleep(5);
        clickElement(buttonDelete);
        sleep(1);
        clickElement(buttonYesDelete);
        sleep(1);
        waitForPageLoaded();
        assertTrue(DriverManager.getDriver().findElements(By.xpath("//div[contains(text(),'Part-Time Inrternship')]")).isEmpty());
        sleep(6);

       /* String actualText = getElementText(messageSuccess);
        sleep(0.5);
        String expectedText = "Successfully Updated";
        Assert.assertTrue(actualText.contains(expectedText));
        Log.info("Verify equals: " + actualText + " and " + expectedText);
       */
    }

    public void editEmployeeStatus() {
        sleep(3);
        clickElement(sectionJob);
        sleep(3);
        clickElement(selectEmploymentStatus);
        sleep(5);
        clickElement(buttonEdit);
        sleep(5);
        WebElement toEdit = DriverManager.getDriver().findElement(inputInfor);
        toEdit.sendKeys(Keys.CONTROL + "a");
        toEdit.sendKeys(Keys.DELETE);
        toEdit.sendKeys("Staff");
        clickElement(buttonSave);
        sleep(7);
        boolean checkText = checkElementExist(By.xpath("//div[contains(text(),'Staff')]"));
        verifyTrue(checkText, "Fail to edit Employee Status");
        sleep(5);
    }

    public void adddLocation() {
        sleep(3);
        clickElement(sectionOrganization);
        sleep(3);
        clickElement(selectLocation);
        sleep(5);
        clickElement(buttonAdd);
        sleep(5);
        setText(inputName, "Infosys");
        setText(inputCity, "Bengaluru");
        clickElement(selectDrowdownList);
        sleep(10);
        WebElement toMoveDown = DriverManager.getDriver().findElement(selectDrowdownList);
        pressI();
        sleep(1);
        toMoveDown.sendKeys(Keys.ARROW_DOWN);
        toMoveDown.sendKeys(Keys.ENTER);
        setText(inputPhone, "014578229");
        clickElement(buttonSave);
        sleep(7);
        boolean checkText = checkElementExist(By.xpath("//div[contains(text(),'Infosys')]"));
        verifyTrue(checkText, "Fail to add Location");
    }

    public void addNewUser() {
        clickElement(By.xpath("//span[normalize-space()='Admin']"));
        sleep(5);
        clickElement(buttonAdd);
        sleep(5);

        WebElement getAdminName = DriverManager.getDriver().findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
        String adminName = getAdminName.getText();
        System.out.println(adminName);
        setText(inputEmployeeName, adminName);


      //  setText(inputEmployeeName, ConstantData.ADMIN_NAME);
        sleep(5);
        WebElement selectEmployeeName = DriverManager.getDriver().findElement(inputEmployeeName);
        selectEmployeeName.sendKeys(Keys.ARROW_DOWN);
        clickElement(By.xpath("(//div[@role='listbox'])[1]"));
        sleep(5);

        WebElement selectStatus = DriverManager.getDriver().findElement(status);
        selectStatus.sendKeys(Keys.ARROW_DOWN);
        clickElement(By.xpath("(//div[@role='listbox'])[1]"));
        sleep(5);
        WebElement toSelectRole = DriverManager.getDriver().findElement(userRole);
        toSelectRole.sendKeys(Keys.ARROW_DOWN);
        clickElement(By.xpath("(//div[@role='listbox'])[1]"));
        sleep(5);
        setText(inputInfor, ConstantData.NEW_USERNAME);
        setText(inputPassword, ConstantData.NEW_PASSWORD);
        setText(confirmPassword, ConstantData.NEW_PASSWORD);
        clickElement(buttonSave);
        sleep(8);
        clickElement(profilePicture);
        sleep(5);
        clickElement(buttonLogout);
    }
}