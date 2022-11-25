package pages;

import DataTest.ConstantData;
import driver.DriverManager;
import org.apache.hc.core5.net.WWWFormCodec;
import org.openqa.selenium.By;
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
    By openEmployeeList = By.xpath("//a[normalize-space()='Employee List']");
    By messageSuccess = By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");
    By bloodType = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[3]");
    By nationality = By.xpath("(//div[@class='oxd-select-text-input'][normalize-space()='-- Select --'])[1]");
    By martialStatus = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
    By selectGender = By.xpath("//label[normalize-space()='Male']");

    By inputDriverLicense = By.xpath("(//input[@class='oxd-input oxd-input--active'])[5]");
    By inputLicenseExpiryDate = By.xpath("(//input[@placeholder='yyyy-mm-dd'])[1]");
    By inputSSNNumber = By.xpath("(//input)[10]");
    By inputSinNumber = By.xpath("(//input)[11]");
    By inputDateOfBirth = By.xpath("(//input[@placeholder='yyyy-mm-dd'])[2]");
    public String checkID;


    public void addEmployee() {
        WebUI.clickElement(buttonAddEmployee);
        WebUI.sleep(5);
        WebUI.setText(inputFirstName, ConstantData.FIRSTNAME);
        WebUI.setText(inputLastName, ConstantData.LASTNAME);
        WebUI.clickElement(buttonSave);
        WebUI.sleep(7);
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
        WebUI.setText(inputDateOfBirth, "1989-10-10");
        WebUI.clickElement(selectGender);
        WebUI.clickElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[1]"));






    }


}
