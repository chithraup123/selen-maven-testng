package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	public static WebDriver driver;

	public static ExtentReports extentReport;
	public static ExtentTest extentTest;

	XSSFWorkbook wbook;
	XSSFSheet sheet;

	@BeforeTest
	public void dataSetup() throws IOException {
		FileInputStream input = new FileInputStream("dataExcel.xlsx");
		wbook = new XSSFWorkbook(input);
		sheet = wbook.getSheet("data");

		extentReport = new ExtentReports("extent-report.html");
		// extentTest = extentReport.startTest("Login with data from excel");
	}

	@BeforeMethod
	public void setUp(Method method) {

		extentTest = extentReport.startTest(method.getName());
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		

	}

	@AfterMethod
	public void tearDown() {
		extentReport.endTest(extentTest);
		driver.quit();
	}

	@AfterTest
	public void DataTearDown() throws IOException {

		wbook.close();
		extentReport.flush();
		extentReport.close();
	}

}
