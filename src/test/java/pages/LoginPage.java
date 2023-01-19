package pages;

import DataTest.ConstantData;
import org.openqa.selenium.By;
import utils.WebUI;


import static utils.WebUI.*;

public class LoginPage {
    public LoginPage() {
    }

    By inputUsername = By.xpath("//input[@placeholder='Username']");
    By inputPassword = By.xpath("//input[@placeholder='Password']");
    By buttonSubmit = By.xpath("//button[@type='submit']");
    By forgetPassword = By.xpath("//div[@class='orangehrm-login-forgot']");
    By header_Dashboard = By.xpath("//h6[normalize-space()='Dashboard']");
    By notifyLoginSuccess = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']");
    By notifyLoginFail = By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']");


    public DashboardPage logIn(String username, String password) {
        openURL(ConstantData.URL);
        waitForPageLoaded();
        setText(inputUsername, username);
        setText(inputPassword, password);
        clickElement(buttonSubmit);
        waitForPageLoaded();
        verifyEquals(getElementText(header_Dashboard), "Dashboard");
        return new DashboardPage();
    }

    public LoginPage forgetPassWord(String username) {
        openURL(ConstantData.URL);
        waitForPageLoaded();
        clickElement(forgetPassword);
        setText(inputUsername, username);
        clickElement(buttonSubmit);
        verifyEquals(getElementText(notifyLoginSuccess), "Reset Password link sent successfully");
        waitForPageLoaded();
        return new LoginPage();
    }

    public LoginPage logInWithInvalidInfor(String username, String password) {
        openURL(ConstantData.URL);
        waitForPageLoaded();
        setText(inputUsername, username);
        setText(inputPassword, password);
        clickElement(buttonSubmit);
        waitForPageLoaded();
        verifyEquals(getElementText(notifyLoginFail), "Invalid credentials");
        return new LoginPage();
    }

}
