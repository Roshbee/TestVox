package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
    private WebDriver driver;

    @FindBy(name = "username") private WebElement username;
    @FindBy(name = "password") private WebElement password;
    @FindBy(css = "button[type='submit']") private WebElement loginBtn;


    public LoginPage(WebDriver driver) {
    	this.driver = driver;
      PageFactory.initElements(driver, this);
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
      wait.until(ExpectedConditions.visibilityOf(username));
	}

	public void login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }
}

