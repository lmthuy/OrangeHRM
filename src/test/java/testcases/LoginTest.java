package testcases;

import DataTest.ConstantData;
import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    public LoginPage loginPage;
    public CommonPage commonPage;
    public DashboardPage dashboardPage;

    @BeforeMethod
    public void loginTest() {
        loginPage = new LoginPage();
        commonPage = new CommonPage();
        dashboardPage = new DashboardPage();
    }

    @Test(priority = 0)
    public void testLogInSuccess() {
        loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
    }


}
