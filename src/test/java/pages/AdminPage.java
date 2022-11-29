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
        WebUI.clickElement(sectionJob);
        WebUI.clickElement(selectJobTitles);
        WebUI.sleep(5);
        WebUI.clickElement(buttonAdd);
        WebUI.sleep(5);
        WebUI.setText(inputInfor, "Automation QA Engineer");
        WebUI.setText(inputJobDescription, "Contact directly Mr.Wu for JD");
        WebUI.setText(inputNote, "We will contact with suitable candidates");
        WebUI.clickElement(buttonSave);
        WebUI.sleep(10);
        boolean checkText = WebUI.checkElementExist(By.xpath("//div[contains(text(),'Automation QA Engineer')]"));
        WebUI.verifyTrue(checkText, "Fail to add Job Title");
        WebUI.sleep(5);
    }

    public void addJobCategory() {
        WebUI.clickElement(sectionJob);
        WebUI.clickElement(selectJobCategories);
        WebUI.sleep(5);
        WebUI.clickElement(buttonAdd);
        WebUI.sleep(5);
        WebUI.setText(inputInfor, "HRBP");
        WebUI.clickElement(buttonSave);
        WebUI.sleep(10);
        boolean checkText = WebUI.checkElementExist(By.xpath("//div[contains(text(),'HRBP')]"));
        WebUI.verifyTrue(checkText, "Fail to add Job Category");
        WebUI.sleep(5);
    }

    public void addEmploymentStatus() {
        WebUI.clickElement(sectionJob);
        WebUI.clickElement(selectEmploymentStatus);
        WebUI.sleep(5);
        WebUI.clickElement(buttonAdd);
        WebUI.sleep(5);
        WebUI.setText(inputInfor, "Full-Time Internship");
        WebUI.clickElement(buttonSave);
        WebUI.sleep(10);
        boolean checkText = WebUI.checkElementExist(By.xpath("//div[contains(text(),'Full-Time Internship')]"));
        WebUI.verifyTrue(checkText, "Fail to add Employee Status");
        WebUI.sleep(5);
    }

    public void deleteEmployeeStatus() {
        WebUI.clickElement(sectionJob);
        WebUI.clickElement(selectEmploymentStatus);
        WebUI.sleep(5);
        WebUI.clickElement(buttonDelete);
        WebUI.clickElement(buttonYesDelete);
        WebUI.sleep(1);
        String actualText = WebUI.getElementText(messageSuccess);
        WebUI.sleep(0.5);
        // System.out.println(actualText);
        String expectedText = "Successfully Deleted";
        Assert.assertTrue(actualText.contains(expectedText));
        Log.info("Verify equals: " + actualText + " and " + expectedText);
        WebUI.sleep(5);
    }

    public void editEmployeeStatus() {
        WebUI.clickElement(sectionJob);
        WebUI.clickElement(selectEmploymentStatus);
        WebUI.sleep(5);
        WebUI.clickElement(buttonEdit);
        WebUI.sleep(5);
        WebElement toEdit = DriverManager.getDriver().findElement(inputInfor);
        toEdit.sendKeys(Keys.CONTROL + "a");
        toEdit.sendKeys(Keys.DELETE);
        toEdit.sendKeys("Staff");
        WebUI.clickElement(buttonSave);
        WebUI.sleep(1);
        String actualText = WebUI.getElementText(messageSuccess);
        WebUI.sleep(0.5);
        // System.out.println(actualText);
        String expectedText = "Successfully Updated";
        Assert.assertTrue(actualText.contains(expectedText));
        Log.info("Verify equals: " + actualText + " and " + expectedText);
    }

    public void adddLocation() {
        WebUI.clickElement(sectionOrganization);
        WebUI.clickElement(selectLocation);
        WebUI.sleep(5);
        WebUI.clickElement(buttonAdd);
        WebUI.sleep(5);
        WebUI.setText(inputName, "Infosys");
        WebUI.setText(inputCity, "Bengaluru");
        WebUI.clickElement(selectDrowdownList);
        WebUI.sleep(10);
        WebElement toMoveDown = DriverManager.getDriver().findElement(selectDrowdownList);
        WebUI.pressI();
        WebUI.sleep(1);
        toMoveDown.sendKeys(Keys.ARROW_DOWN);
        toMoveDown.sendKeys(Keys.ENTER);
        WebUI.setText(inputPhone, "014578229");
        WebUI.clickElement(buttonSave);
        WebUI.sleep(7);
        boolean checkText = WebUI.checkElementExist(By.xpath("//div[contains(text(),'Infosys')]"));
        WebUI.verifyTrue(checkText, "Fail to add Location");
    }

    public void addNewUser() {
        WebUI.clickElement(By.xpath("//span[normalize-space()='Admin']"));
        WebUI.sleep(5);
        WebUI.clickElement(buttonAdd);
        WebUI.sleep(5);

        WebUI.setText(inputEmployeeName, "Kevin Mathews");
        WebUI.sleep(5);
        WebElement selectEmployeeName = DriverManager.getDriver().findElement(inputEmployeeName);
        selectEmployeeName.sendKeys(Keys.ARROW_DOWN);
        WebUI.clickElement(By.xpath("(//div[@role='listbox'])[1]"));
        WebUI.sleep(5);

        WebElement selectStatus = DriverManager.getDriver().findElement(status);
        selectStatus.sendKeys(Keys.ARROW_DOWN);
        WebUI.clickElement(By.xpath("(//div[@role='listbox'])[1]"));
        WebUI.sleep(5);
        WebElement toSelectRole = DriverManager.getDriver().findElement(userRole);
        toSelectRole.sendKeys(Keys.ARROW_DOWN);
        WebUI.clickElement(By.xpath("(//div[@role='listbox'])[1]"));
        WebUI.sleep(5);
        WebUI.setText(inputInfor, ConstantData.NEW_USERNAME);
        WebUI.setText(inputPassword, ConstantData.NEW_PASSWORD);
        WebUI.setText(confirmPassword, ConstantData.NEW_PASSWORD);
        WebUI.clickElement(buttonSave);
        WebUI.sleep(8);
        WebUI.clickElement(profilePicture);
        WebUI.clickElement(buttonLogout);
    }
}