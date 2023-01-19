package testcases;

import DataTest.ConstantData;
import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.CommonPage;
import pages.LoginPage;

import static utils.WebUI.*;

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
        waitForPageLoaded();
        adminPage.addJobTitle();
    }

    @Test(priority = 1)
    public void testAddJobCategory() {
        dashboardPage = loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        adminPage = commonPage.openAdminPage();
        waitForPageLoaded();
        adminPage.addJobCategory();
    }

    @Test(priority = 2)
    public void testAddEmployeeStatus() {
        dashboardPage = loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        adminPage = commonPage.openAdminPage();
        waitForPageLoaded();

        //Add Employee Status
        adminPage.addEmploymentStatus();
    }

    @Test(priority = 3)
    public void testDeleteEmployeeStatus() {
        dashboardPage = loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        adminPage = commonPage.openAdminPage();
        //Delete Employee Status
        adminPage.deleteEmployeeStatus();
    }

    @Test(priority = 4)
    public void testEditEmployeeStatus() {
        dashboardPage = loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        adminPage = commonPage.openAdminPage();
        waitForPageLoaded();
        //Edit Employee Status
        adminPage.editEmployeeStatus();
    }

    @Test(priority = 5)
    public void testAddLocation() {
        dashboardPage = loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        adminPage = commonPage.openAdminPage();
        waitForPageLoaded();
        adminPage.adddLocation();
    }
}
