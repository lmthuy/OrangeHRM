package testcases;

import DataTest.ConstantData;
import common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.CommonPage;
import pages.LoginPage;
import pages.PIMPage;
import utils.WebUI;

public class LoginNewUserTest extends BaseTest {
    public LoginPage loginPage;
    public CommonPage commonPage;
    public AdminPage adminPage;
    public PIMPage pimPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage();
        commonPage = new CommonPage();
        adminPage = new AdminPage();
        pimPage = new PIMPage();
    }
    @Test(priority = 0)
    public void testLoginNewUser(){
        dashboardPage = loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        WebUI.sleep(5);
        adminPage.addNewUser();
        dashboardPage = loginPage.logIn(ConstantData.NEW_USERNAME,ConstantData.NEW_PASSWORD);
    }


    @Test(priority = 1)
    public void testLogInWithInvalidPass() {
        loginPage.logInWithInvalidInfor(ConstantData.NEW_USERNAME, "123456");
    }

    @Test(priority = 2)
    public void testLogInWithInValidUserName() {
        loginPage.logInWithInvalidInfor("Kevin123",ConstantData.NEW_PASSWORD );
    }

}
