package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageClasses.Dashboard;
import PageClasses.LoginPage;
import TestBase.BaseClass;

public class LoginTests extends BaseClass {  // Extend BaseClass to inherit driver, setup, etc.
	 LoginPage loginPage;
	    public LoginTests() {
	        super(); // Load config properties
	    }
    @BeforeClass
    public void setUp() {
        initialization();  //  Call BaseClass method to setup browser, load URL from config.properties
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void verifyTitle() {
        String actualTitle = driver.getTitle();
        System.out.println("Current Page Title: " + actualTitle);
        Assert.assertEquals(actualTitle, "OrangeHRM");  //  Replace with correct expected title if needed
    }

    @Test(priority = 2)
    public void testLogin() {
        LoginPage lp = new LoginPage(driver);  //  Page Object usage
        lp.setUserName("Admin");
        lp.setPassword("admin123");
        lp.clicklogin();
        
    }

    @AfterClass
    public void tearDownTest() {
        tearDown();  //  Call BaseClass method to quit the driver
    }
}


//package TestCases;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import PageClasses.LoginPage;
//
//public class LoginTests {
//   WebDriver driver;
//
//   @BeforeClass
//    void setup()
//    {
//	   
//	   ChromeOptions Option=new ChromeOptions();
////	   Option.addArguments("--headless=true");
//	   driver=new ChromeDriver (Option);
//	   driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//	  
//    }
//   
//   @Test(priority=2)
//   void testLogin(){
//	   //login page2 
//	   LoginPage lp=new LoginPage(driver);
//	   
//	   lp.setUserName("Admin");
//	   lp.setPassword("admin123");
//	   lp.clicklogin();
//   }
//	   @Test(priority=1)
//	   void Title() throws InterruptedException  {
//		   Thread.sleep(1000);
//
//	        // Current page title
//	        String actualTitle = driver.getTitle();
//	        // Print title to console
//	        System.out.println("Current Page Title: " + actualTitle);
//	        
//	        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
//	   
//    }
//	   
//   @AfterClass
//   void tearDown()
//   {
//	   driver.quit();
//   }
//   
//}
//   