package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageClasses.Dashboard;
import PageClasses.LoginPage;
import TestBase.BaseClass;

public class DashboardTests extends BaseClass {
	
    LoginPage loginPage;
    Dashboard dashboard;
    public DashboardTests() {
        super(); // Load config properties
    }

    @BeforeClass
    public void setUp() {
        initialization();
        loginPage = new LoginPage(driver);
        dashboard = new Dashboard(driver);

        // Perform login before dashboard validation
        loginPage.setUserName(prop.getProperty("username"));
        loginPage.setPassword(prop.getProperty("password"));
        loginPage.clicklogin();
    }

    @Test(priority = 1)
    public void verifyDashboardIsDisplayed() {
        boolean displayed = dashboard.isDashboardDisplayed();
        System.out.println("Dashboard displayed: " + displayed);
        Assert.assertTrue(displayed, "Dashboard header is NOT displayed!");
    }

    @Test(priority = 2)
    public void verifyDashboardTitle() {
        String title = dashboard.getHomePageTitle();
        System.out.println("Current Page Title: " + title);
        Assert.assertTrue(title.contains("OrangeHRM"), "Title mismatch!");
    }

    @Test(priority = 3)
    public void verifyDashboardUrl() {
        String url = dashboard.getDashboardUrl();
        System.out.println("Current URL: " + url);
        Assert.assertTrue(url.contains("/dashboard"), "URL does not contain '/dashboard'!");
    }

    @AfterClass()
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

