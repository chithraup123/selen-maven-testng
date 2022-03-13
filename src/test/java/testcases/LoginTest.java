package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage loginPage;

	@BeforeMethod
	public void beforeMethod() {
		loginPage = new LoginPage();
	}

	// @Test
	public void loginFailureTest() {

		loginPage.login("xyz@abc.com", "Abc12345");
		String expMsg = "The email or password you have entered is invalid.";
		String actualMsg = driver.findElement(By.id("msg_box")).getText();
		Assert.assertEquals(actualMsg, expMsg, "Not matching actual and expected mesages");

	}

	// @Test
	public void loginSuccessTest() {

		loginPage.login("", "");
	}

	// Run with testng.xml since this params are given from suite
	@Test
	@Parameters({ "param1", "param2" })
	public void paramTest(String usrName, String pwd) {

		loginPage.login(usrName, pwd);
	}

	@Test
	public void externalDataTest() {

		System.out.println("Hellooooooooooooooo");

		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();

		loginPage.login(UserNameVal, PasswordVal);
	}
}
