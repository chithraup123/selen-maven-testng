package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {

	@FindBy(linkText = "Log in")
	WebElement loginElement;

	@FindBy(name = "user_login")
	WebElement userNameElement;

	@FindBy(id = "password")
	WebElement passwordElement;

	@FindBy(name = "btn_login")
	WebElement button;

	@FindBy(className = "rememberMe")
	WebElement rememebrMe;

	WebDriver driver = BaseClass.driver;

	ExtentTest extentTest = BaseClass.extentTest;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void login(String usrName, String pwd) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(loginElement));
		loginElement.click();
		extentTest.log(LogStatus.PASS, "Click on Login link", "Click on Login link Succesfull");
		userNameElement.sendKeys(usrName);
		extentTest.log(LogStatus.PASS, "Enter UserName", "Username has got entered successfully");
		passwordElement.sendKeys(pwd);
		extentTest.log(LogStatus.PASS, "Enter password", "Password has got entered successfully");
		rememebrMe.click();
		button.click();
		extentTest.log(LogStatus.PASS, "Click on ", "Login successfull");
	}

}
