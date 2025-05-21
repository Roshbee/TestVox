package test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;


public class AddEmployeeTest extends BaseTest {

    @Test
    public void addEmployeeTest() {
    	 test = extent.createTest("Add Employee Test");

         LoginPage loginPage = new LoginPage(driver);
         loginPage.login("Admin", "admin123");
         test.log(Status.PASS, "Logged in successfully");

         DashboardPage dashboard = new DashboardPage(driver);
         dashboard.goToAddEmployee();
         test.log(Status.PASS, "Navigated to Add Employee");

         AddEmployeePage addEmp = new AddEmployeePage(driver);
         String user = "emp" + System.currentTimeMillis();
         addEmp.addEmployee("John", "Snow", user, "Pass@123");
         test.log(Status.PASS, "Added employee: " + user);

         Assert.assertTrue(addEmp.isEmployeeAdded(), "Employee was not added!");
         test.log(Status.PASS, "Employee addition verified");
        Assert.assertTrue(addEmp.isEmployeeAdded(), "Employee was not added!");

    }
}
