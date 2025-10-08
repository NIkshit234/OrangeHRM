package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import PageClasses.LoginPage;
import PageClasses.PIMPage;
import TestBase.BaseClass;

public class PIMTests extends BaseClass {

    LoginPage loginPage;
    PIMPage pimPage;

    @BeforeClass
    public void setUp() {
        initialization();
        loginPage = new LoginPage(driver);
        pimPage = new PIMPage(driver);

        // Login first
        loginPage.setUserName(prop.getProperty("username"));
        loginPage.setPassword(prop.getProperty("password"));
        loginPage.clicklogin();
    }

    @Test
    public void addNewEmployee() throws InterruptedException {
        pimPage.clickPIMMenu();
        Thread.sleep(1000); // wait for page load

        pimPage.clickAddEmployee();
        Thread.sleep(1000);

        String firstName = "Nikshit";
        String lastName = "Jamwal";

        pimPage.enterEmployeeDetails(firstName, lastName);
        pimPage.clickSave();
        Thread.sleep(2000); // wait for save

        // Validate by URL contains "/pim/viewEmployeeList"
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after adding employee: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("/pim/viewEmployeeList"), "Employee not added or page not redirected!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
