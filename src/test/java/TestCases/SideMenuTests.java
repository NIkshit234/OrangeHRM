package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageClasses.LoginPage;
import PageClasses.SideMenuPage;
import TestBase.BaseClass;

public class SideMenuTests extends BaseClass {

    LoginPage loginPage;
    SideMenuPage sideMenu;

    public SideMenuTests() {
        super();
    }

    @BeforeClass
    public void setUp() {
        initialization();
        loginPage = new LoginPage(driver);
        sideMenu = new SideMenuPage(driver);

        loginPage.setUserName(prop.getProperty("username"));
        loginPage.setPassword(prop.getProperty("password"));
        loginPage.clicklogin();
    }

    @Test(priority = 1)
    public void clickAdminMenu() {
        sideMenu.clickAdmin();
        Assert.assertTrue(sideMenu.getCurrentPageUrl().contains("/admin"), "Admin page not opened!");
        System.out.println(" Clicked on Admin menu successfully.");
    }

    @Test(priority = 2)
    public void clickPIMMenu() {
        sideMenu.clickPIM();
        Assert.assertTrue(sideMenu.getCurrentPageUrl().contains("/pim"), "PIM page not opened!");
        System.out.println(" Clicked on PIM menu successfully.");
    }

    @Test(priority = 3)
    public void clickLeaveMenu() {
        sideMenu.clickLeave();
        Assert.assertTrue(sideMenu.getCurrentPageUrl().contains("/leave"), "Leave page not opened!");
        System.out.println(" Clicked on Leave menu successfully.");
    }

    @Test(priority = 4)
    public void clickTimeMenu() {
        sideMenu.clickTime();
        Assert.assertTrue(sideMenu.getCurrentPageUrl().contains("/time"), "Time page not opened!");
        System.out.println(" Clicked on Time menu successfully.");
    }

    @Test(priority = 5)
    public void clickRecruitmentMenu() {
        sideMenu.clickRecruitment();
        Assert.assertTrue(sideMenu.getCurrentPageUrl().contains("/recruitment"), "Recruitment page not opened!");
        System.out.println(" Clicked on Recruitment menu successfully.");
    }

    @Test(priority = 6)
    public void clickMyInfoMenu() throws InterruptedException {
        sideMenu.clickMyInfo();
        Thread.sleep(1000);
        Assert.assertTrue(sideMenu.getCurrentPageUrl().contains("/viewPersonalDetails"), "My Info page not opened!");
        System.out.println("Clicked on My Info menu successfully.");
    }

    @Test(priority = 7)
    public void clickPerformanceMenu() {
        sideMenu.clickPerformance();
        Assert.assertTrue(sideMenu.getCurrentPageUrl().contains("/performance"), "Performance page not opened!");
        System.out.println(" Clicked on Performance menu successfully.");
    }

    @Test(priority = 8)
    public void clickDashboardMenu() {
        sideMenu.clickDashboard();
        Assert.assertTrue(sideMenu.getCurrentPageUrl().contains("/dashboard"), "Dashboard page not opened!");
        System.out.println("Clicked on Dashboard menu successfully.");
    }

    @Test(priority = 9)
    public void clickDirectoryMenu() {
        sideMenu.clickDirectory();
        Assert.assertTrue(sideMenu.getCurrentPageUrl().contains("/directory"), "Directory page not opened!");
        System.out.println("Clicked on Directory menu successfully.");
    }

    @Test(priority = 10)
    public void clickMaintenanceMenu() {
        sideMenu.clickMaintenance();
        // Wait for page load
//        try {
//            Thread.sleep(2000); // small wait; ideally use WebDriverWait
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        
//        String currentUrl = sideMenu.getCurrentPageUrl();
//        System.out.println("Current URL after clicking Maintenance: " + currentUrl);
//
//        boolean isMaintenancePage = currentUrl.contains("/maintenance")
//                || currentUrl.contains("/accessEmployeeData")
//                || currentUrl.contains("/purgeEmployee");
//
//        Assert.assertTrue(isMaintenancePage, "Maintenance page not opened!");
//        System.out.println(" Clicked on Maintenance menu successfully.");
           
     Assert.assertTrue(sideMenu.getCurrentPageUrl().contains("/purgeEmployee"), "Maintenance page not opened!");
 
        System.out.println("Clicked on Maintenance menu successfully.");
    }
    
    @Test(priority = 11)
    public void clickCancel() {
        sideMenu.clickcancel();
        
    }

    @Test(priority = 12)
    public void clickClaimMenu() {
        sideMenu.clickClaim();
        Assert.assertTrue(sideMenu.getCurrentPageUrl().contains("/claim"), "Claim page not opened!");
        System.out.println("Clicked on Claim menu successfully.");
    }

    @Test(priority = 13)
    public void clickBuzzMenu() {
        sideMenu.clickBuzz();
        Assert.assertTrue(sideMenu.getCurrentPageUrl().contains("/buzz"), "Buzz page not opened!");
        System.out.println("Clicked on Buzz menu successfully.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Browser closed successfully after side menu tests.");
    }
}


