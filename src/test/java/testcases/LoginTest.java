package testcases;

import DataTest.ConstantData;
import common.BaseTest;
import dataprovider.DataProviderFactory;
import dataprovider.DataProviderManager;
import helpers.ExcelHelpers;
import helpers.Helpers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.DashboardPage;
import pages.LoginPage;

import static utils.WebUI.*;

import java.io.StringReader;
import java.util.Hashtable;

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

    @Test
    public void testLogin() {
        dashboardPage =  loginPage.logIn(ConstantData.USERNAME,ConstantData.PASSWORD);
        sleep(5);
    }
}




