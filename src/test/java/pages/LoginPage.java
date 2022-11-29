package pages;

import org.openqa.selenium.By;
import utils.WebUI;

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
        WebUI.openURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebUI.sleep(3);
        WebUI.setText(inputUsername, username);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSubmit);
        WebUI.sleep(6);
        WebUI.verifyEquals(WebUI.getElementText(header_Dashboard), "Dashboard");
        return new DashboardPage();
    }

    public LoginPage forgetPassWord(String username) {
        WebUI.openURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebUI.sleep(5);
        WebUI.clickElement(forgetPassword);
        WebUI.sleep(4);
        WebUI.setText(inputUsername, username);
        WebUI.clickElement(buttonSubmit);
        WebUI.sleep(3);
        WebUI.verifyEquals(WebUI.getElementText(notifyLoginSuccess), "Reset Password link sent successfully");
        WebUI.sleep(10);
        return new LoginPage();
    }

    public LoginPage logInWithInvalidInfor(String username, String password) {
        WebUI.openURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       WebUI.sleep(5);
        WebUI.setText(inputUsername, username);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSubmit);
        WebUI.sleep(7);
        WebUI.verifyEquals(WebUI.getElementText(notifyLoginFail), "Invalid credentials");
        return new LoginPage();
    }

}
