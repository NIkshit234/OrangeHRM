package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

    // ✅ Constructor initializes PageFactory
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // <--- Important line
    }

    // ✅ Use @FindBy instead of By locators
    @FindBy(name = "username")
    WebElement txt_username;

    @FindBy(name = "password")
    WebElement txt_password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btn_login;

    // ✅ Action methods use WebElement directly
    public void setUserName(String username) {
        txt_username.sendKeys(username);
    }

    public void setPassword(String password) {
        txt_password.sendKeys(password);
    }

    public void clicklogin() {
        btn_login.click();
        
    }
    
    public void login(String username, String password) {
        setUserName(username);
        setPassword(password);
        clicklogin();
    }

	
	}
    




