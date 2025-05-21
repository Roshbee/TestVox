package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReportManager;

public class BaseTest {
	protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeClass
    public void setupReporting() {
        extent = ReportManager.getReportInstance();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();  // or use WebDriverManager
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @AfterClass
    public void flushReports() {
        extent.flush();
    }
}

