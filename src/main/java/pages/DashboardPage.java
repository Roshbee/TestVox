package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='oxd-sidepanel-body']//ul/li[2]/a") private WebElement pimMenu;
    @FindBy(xpath = "//nav[@aria-label='Topbar Menu']/ul/li[3]") private WebElement addEmployee;

   
    
    public DashboardPage(WebDriver driver) {
    	this.driver = driver;
        PageFactory.initElements(driver, this);
        
    }



	public void goToAddEmployee() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		    wait.until(ExpectedConditions.visibilityOf(pimMenu));
		    pimMenu.click();

		    wait.until(ExpectedConditions.visibilityOf(addEmployee));
		    addEmployee.click();
    }
}

