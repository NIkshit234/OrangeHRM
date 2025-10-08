package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {

    WebDriver driver;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ===== Locators =====
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement pimMenu;

    @FindBy(xpath = "//button[text()='Add']")
    WebElement btnAdd;

    @FindBy(name = "firstName")
    WebElement txtFirstName;

    @FindBy(name = "lastName")
    WebElement txtLastName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSave;

    // ===== Actions =====
    public void clickPIMMenu() {
        pimMenu.click();
    }

    public void clickAddEmployee() {
        btnAdd.click();
    }

    public void enterEmployeeDetails(String firstName, String lastName) {
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
    }

    public void clickSave() {
        btnSave.click();
    }
}
