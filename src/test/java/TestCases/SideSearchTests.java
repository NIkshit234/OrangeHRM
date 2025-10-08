package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageClasses.LoginPage;
import PageClasses.SideSearchPage;
import TestBase.BaseClass;

public class SideSearchTests extends BaseClass {

    LoginPage loginPage;
    SideSearchPage sideSearchPage;

    @BeforeClass
    public void setUp() {
        initialization();
        loginPage = new LoginPage(driver);
        sideSearchPage = new SideSearchPage(driver);

        // Perform login
        loginPage.setUserName(prop.getProperty("username"));
        loginPage.setPassword(prop.getProperty("password"));
        loginPage.clicklogin();
    }

    @Test(priority = 1)
    public void searchAdminMenu() throws InterruptedException {
        sideSearchPage.enterSearchText("Admin");
        Thread.sleep(1000);
        boolean visible = sideSearchPage.isMenuVisible("Admin");
        Assert.assertTrue(visible, "Admin menu not visible in search results!");
        System.out.println(" 'Admin' menu appears successfully when searched.");
        sideSearchPage.clearSearch();
    }

    @Test(priority = 2)
    public void searchPIMMenu() throws InterruptedException {
        sideSearchPage.enterSearchText("PIM");
        Thread.sleep(1000);
        boolean visible = sideSearchPage.isMenuVisible("PIM");
        Assert.assertTrue(visible, "PIM menu not visible in search results!");
        System.out.println(" 'PIM' menu appears successfully when searched.");
        sideSearchPage.clearSearch();
    }

    @Test(priority = 3)
    public void searchLeaveMenu() throws InterruptedException {
        sideSearchPage.enterSearchText("Leave");
        Thread.sleep(1000);
        boolean visible = sideSearchPage.isMenuVisible("Leave");
        Assert.assertTrue(visible, "Leave menu not visible in search results!");
        System.out.println(" 'Leave' menu appears successfully when searched.");
        sideSearchPage.clearSearch();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Browser closed after search tests.");
    }
}