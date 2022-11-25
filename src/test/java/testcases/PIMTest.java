package testcases;

import DataTest.ConstantData;
import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;
import pages.PIMPage;
import utils.WebUI;

public class PIMTest extends BaseTest {
    public LoginPage loginPage;
    public CommonPage commonPage;
    public PIMPage pimPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage();
        commonPage = new CommonPage();
        pimPage = new PIMPage();
    }
    @Test
    public void testAddNewEmployee(){
        dashboardPage = loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        pimPage = commonPage.openPIMPage();
        WebUI.sleep(5);
        pimPage.addEmployee();
    }
}