package PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SideSearchPage {

    WebDriver driver;

    public SideSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ===== Locator =====
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement sideSearchInput;

    // ===== Actions =====
    public void enterSearchText(String text) throws InterruptedException {
        sideSearchInput.click(); // make sure input is focused
        sideSearchInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // select all
        sideSearchInput.sendKeys(Keys.BACK_SPACE); // delete everything
        Thread.sleep(500); // small pause for UI to reset
        sideSearchInput.sendKeys(text); // type new text
    }
    
    public boolean isMenuVisible(String menuName) {
        try {
            By menuLocator = By.xpath("//span[text()='" + menuName + "']");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // increased wait
            WebElement menuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(menuLocator));
            return menuItem.isDisplayed();
        } catch (Exception e) {
            System.out.println(" Menu not visible: " + menuName + " - " + e.getMessage());
            return false;
        }
    }

    public void clearSearch() {
        sideSearchInput.clear();
    }
}