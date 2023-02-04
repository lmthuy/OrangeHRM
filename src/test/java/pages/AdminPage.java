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
import java.util.UUID;

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
    By firstRow = By.xpath("//div[@class='oxd-table-header']//div[@role='row']");
    By profilePicture = By.xpath("//img[@alt='profile picture']");
    By buttonLogout = By.xpath("//a[normalize-space()='Logout']");
    By selectNameIcon = By.xpath("//span[@class='oxd-userdropdown-tab']");


    public void addJobTitle() {
        waitForPageLoaded();
        clickElement(sectionJob);
        clickElement(selectJobTitles);
        clickElement(buttonAdd);
        waitForPageLoaded();
        setText(inputInfor, "Automation QA Engineer");
        setText(inputJobDescription, "Contact directly Mr.Wu for JD");
        setText(inputNote, "We will contact with suitable candidates");
        clickElement(buttonSave);
        waitForElementVisible(By.xpath("//div[contains(text(),'Automation QA Engineer')]"));
        boolean checkText = checkElementExist(By.xpath("//div[contains(text(),'Automation QA Engineer')]"));
        verifyTrue(checkText, "Fail to add Job Title");
        sleep(3);
    }

    public void addJobCategory() {
        waitForPageLoaded();
        clickElement(sectionJob);
        waitForPageLoaded();
        clickElement(selectJobCategories);
        waitForPageLoaded();
        clickElement(buttonAdd);
        waitForPageLoaded();
        setText(inputInfor, "HRBP");
        clickElement(buttonSave);
        waitForElementVisible(By.xpath("//div[contains(text(),'HRBP')]"));
        boolean checkText = checkElementExist(By.xpath("//div[contains(text(),'HRBP')]"));
        verifyTrue(checkText, "Fail to add Job Category");
        sleep(3);
    }

    public void addEmploymentStatus() {
        waitForPageLoaded();
        clickElement(sectionJob);
        clickElement(selectEmploymentStatus);
        clickElement(buttonAdd);
        waitForPageLoaded();
        setText(inputInfor, "Full-Time Internship");
        clickElement(buttonSave);
        waitForPageLoaded();
        boolean checkText = checkElementExist(By.xpath("//div[contains(text(),'Full-Time Internship')]"));
        verifyTrue(checkText, "Fail to add Employee Status");
        sleep(3);
    }

    public void deleteEmployeeStatus() {
        waitForPageLoaded();
        clickElement(sectionJob);
        clickElement(selectEmploymentStatus);
        clickElement(buttonDelete);
        sleep(1);
        clickElement(buttonYesDelete);
        sleep(1);
        waitForPageLoaded();
        assertTrue(DriverManager.getDriver().findElements(By.xpath("//div[contains(text(),'Part-Time Inrternship')]")).isEmpty());
        sleep(3);

    }

    public void editEmployeeStatus() {
        clickElement(sectionJob);
        clickElement(selectEmploymentStatus);
        clickElement(buttonEdit);
        waitForPageLoaded();
        waitForElementVisible(inputInfor);

        setText(inputInfor, " managed by Mr.Wu");
        sleep(2);
        clickElement(buttonSave);
        waitForPageLoaded();
        boolean checkText = checkElementExist(By.xpath("//div[contains(text(),'Mr.Wu')]"));
        verifyTrue(checkText, "Fail to edit Employee Status");
        sleep(3);
    }

    public void adddLocation() {
        clickElement(sectionOrganization);
        clickElement(selectLocation);
        clickElement(buttonAdd);
        waitForPageLoaded();
        setText(inputName, "Infosys");
        setText(inputCity, "Bengaluru");
        clickElement(selectDrowdownList);
        waitForPageLoaded();
        WebElement toMoveDown = DriverManager.getDriver().findElement(selectDrowdownList);
        pressI();
        setArrowDown(toMoveDown);
        setEnter(toMoveDown);
        setText(inputPhone, "014578229");
        clickElement(buttonSave);
        sleep(3);
        boolean checkText = checkElementExist(By.xpath("//div[contains(text(),'Infosys')]"));
        verifyTrue(checkText, "Fail to add Location");

    }

    public void addNewUser() {
        waitForPageLoaded();
        clickElement(By.xpath("//span[normalize-space()='Admin']"));
        clickElement(buttonAdd);
        waitForElementVisible(selectNameIcon);

        String adminName = getElementText(selectNameIcon);
        System.out.println(adminName);
        setText(inputEmployeeName, adminName);


        WebElement selectEmployeeName = DriverManager.getDriver().findElement(inputEmployeeName);
        setArrowDown(selectEmployeeName);
        clickElement(By.xpath("(//div[@role='listbox'])[1]"));

        WebElement selectStatus = DriverManager.getDriver().findElement(status);
        setArrowDown(selectStatus);
        clickElement(By.xpath("(//div[@role='listbox'])[1]"));


        WebElement toSelectRole = DriverManager.getDriver().findElement(userRole);
        setArrowDown(toSelectRole);
        clickElement(By.xpath("(//div[@role='listbox'])[1]"));
        setText(inputInfor,ConstantData.NEW_USERNAME);
        setText(inputPassword, ConstantData.NEW_PASSWORD);
        setText(confirmPassword, ConstantData.NEW_PASSWORD);
        clickElement(buttonSave);
        waitForPageLoaded();
        clickElement(profilePicture);
        waitForElementVisible(buttonLogout);
        clickElement(buttonLogout);
        sleep(1);
    }
}