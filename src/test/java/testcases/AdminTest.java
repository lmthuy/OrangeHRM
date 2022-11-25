package testcases;

import DataTest.ConstantData;
import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.CommonPage;
import pages.LoginPage;
import utils.WebUI;

public class AdminTest extends BaseTest {
    public LoginPage loginPage;
    public CommonPage commonPage;
    public AdminPage adminPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage();
        commonPage = new CommonPage();
        adminPage = new AdminPage();
    }

    @Test(priority = 0)
    public void testAddJobTitle() {
        dashboardPage = loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        adminPage = commonPage.openAdminPage();
        WebUI.sleep(10);
        adminPage.addJobTitle();
        WebUI.waitForPageLoaded();
    }

    @Test(priority = 1)
    public void testAddJobCategory() {
        dashboardPage = loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        adminPage = commonPage.openAdminPage();
        WebUI.sleep(10);
        adminPage.addJobCategory();
        WebUI.waitForPageLoaded();
    }

    @Test(priority = 2)
    public void testAddEmployeeStatus() {
        dashboardPage = loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        adminPage = commonPage.openAdminPage();
        WebUI.sleep(5);
        //Add Employee Status
        adminPage.addEmploymentStatus();
    }

    @Test(priority = 3)
    public void testDeleteEmployeeStatus() {
        dashboardPage = loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        adminPage = commonPage.openAdminPage();
        WebUI.sleep(5);
        //Delete Employee Status
        adminPage.deleteEmployeeStatus();
    }
    @Test(priority = 4)
    public void testEditEmployeeStatus(){
        dashboardPage = loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        adminPage = commonPage.openAdminPage();
        WebUI.sleep(5);
        //Edit Employee Status
        adminPage.editEmployeeStatus();
    }
    @Test(priority = 5)
    public void testAddLocation(){
        dashboardPage = loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        adminPage = commonPage.openAdminPage();
        WebUI.sleep(5);
        adminPage.adddLocation();
    }
}
