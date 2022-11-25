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

    @Test(priority = 1)
    public void testForgetPass() {
        loginPage.forgetPassWord("Admin");
    }

    @Test(priority = 2)
    public void testLogInWithInvalidPass() {
        loginPage.logInWithInvalidInfor("Admin", "123456");
    }

    @Test(priority = 3)
    public void testLogInWithInValidUserName() {
        loginPage.logInWithInvalidInfor("Admin254", "admin123");
    }
}
