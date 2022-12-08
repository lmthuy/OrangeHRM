package testcases;

import DataTest.ConstantData;
import common.BaseTest;
import dataprovider.DataProviderManager;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.CommonPage;
import pages.LoginPage;
import pages.PIMPage;
import utils.WebUI;

import java.util.Hashtable;

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
    public void testLoginNewUser() {
        dashboardPage = loginPage.logIn(ConstantData.USERNAME, ConstantData.PASSWORD);
        WebUI.sleep(5);
        adminPage.addNewUser();
        dashboardPage = loginPage.logIn(ConstantData.NEW_USERNAME, ConstantData.NEW_PASSWORD);
    }


    @Test(priority = 1, dataProvider = "data_provider_login_from_excel", dataProviderClass = DataProviderManager.class)
    public void testLoginInvalidInfor(Hashtable<String, String> data) {
        loginPage.logInWithInvalidInfor(data.get("username"), data.get("password"));
    }
}
