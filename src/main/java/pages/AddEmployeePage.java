package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage {
    private WebDriver driver;

    @FindBy(name = "firstName") private WebElement firstName;
    @FindBy(name = "lastName") private WebElement lastName;
    @FindBy(css = ".oxd-switch-input") private WebElement toggleLoginDetails;
    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div/input") private WebElement username;
    @FindBy(xpath = "//label[text()='Password']/../following-sibling::div/input") private WebElement password;
    @FindBy(xpath = "//label[text()='Confirm Password']/../following-sibling::div/input") private WebElement confirmPassword;
    @FindBy(css = "button[type='submit']") private WebElement saveBtn;

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addEmployee(String fName, String lName, String uName, String pass) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(fName);
        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.sendKeys(lName);
        wait.until(ExpectedConditions.visibilityOf(toggleLoginDetails));
        toggleLoginDetails.click();
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(uName);
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOf(confirmPassword));
        confirmPassword.sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
        saveBtn.click();
    }

    public boolean isEmployeeAdded() {
        return driver.findElements(By.xpath("//h6[text()='Personal Details']")).size() > 0;
    }
}

