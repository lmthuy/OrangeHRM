package pages;

import org.openqa.selenium.By;
import utils.WebUI;

public class CommonPage {
    public CommonPage() {
    }

    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public AdminPage adminPage;
    public PIMPage pimPage;
    By buttonAvt = By.xpath("//p[@class='oxd-userdropdown-name']");
    By buttonLogOut = By.xpath("//a[normalize-space()='Logout']");
    By menuAdmin = By.xpath("//span[normalize-space()='Admin']");
    By menuPIM = By.xpath("//span[normalize-space()='PIM']");


    public LoginPage logOut() {
        WebUI.clickElement(buttonAvt);
        WebUI.clickElement(buttonLogOut);
        return new LoginPage();
    }

    public AdminPage openAdminPage() {
        WebUI.clickElement(menuAdmin);
        return new AdminPage();
    }
    public PIMPage openPIMPage(){
        WebUI.clickElement(menuPIM);
        return new PIMPage();
    }

    public AdminPage getAdminPage() {
        if (adminPage == null) {
            adminPage = new AdminPage();
        }
        return adminPage;
    }
    public PIMPage getPimPage(){
        if(pimPage == null){
            pimPage = new PIMPage();
        }
        return pimPage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }


}
