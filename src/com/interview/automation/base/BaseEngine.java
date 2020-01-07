package com.interview.automation.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.interview.automation.supporters.PropertiesUtilities;
import com.interview.automation.utilities.POJOSupporters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseEngine {
	static private WebDriver driver;
	static private String tcName;
	private static String curDir;
	private static PropertiesUtilities prConf;
	
	private static PropertiesUtilities prOr;
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	
	@Parameters("browser")
	@BeforeSuite
	public void openBrowser(@org.testng.annotations.Optional("chrome")String browser) throws IOException, EncryptedDocumentException, InvalidFormatException {
		String curDir = System.getProperty("user.dir");

		prConf = POJOSupporters.getConfObj();
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
			driverInit();
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", curDir+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driverInit();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "");
			driver = new FirefoxDriver();
			driverInit();
		}
	}
	static private void driverInit(){
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(89, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	@AfterSuite
	static public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		/*if (driver!=null) {
			driver.close();
		}*/
		Optional<WebDriver> optional = Optional.ofNullable(driver);
		if (optional.isPresent())
		   driver.close();	
		else
			System.out.println("Driver is pointing to NULL...");
		System.out.println("AS");
	}
	static public WebDriver getDriver() {
		return driver;
	}
	
	@BeforeTest
	public void initiateReports() {
		extentReports = new ExtentReports(curDir+"\\Reports\\Result.html");
	}
	@AfterTest
	public void generateReports() {
		extentReports.flush();
		extentReports.close();
	}
	
	@BeforeMethod
	public void beforeTCExecution(Method method) {
		tcName = method.getName();	
		System.out.println("CURRENTLYEXECUTING TC NAME IS: " +tcName);
		extentTest = extentReports.startTest(tcName);
	}
	@AfterMethod
	public void afterTCEcecution(ITestResult result) throws IOException {
		//String tcName = result.getName();
	if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("TC IS PASSED: " +tcName);
			extentTest.log(LogStatus.PASS, "TC IS PASSED: " +tcName);
	}
	else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("TC IS FAILED : " +tcName);
			Throwable errorMsg = result.getThrowable();
			extentTest.log(LogStatus.FAIL, "TC IS FAILED: " +tcName);
			extentTest.log(LogStatus.FAIL, result.getThrowable());
			System.out.println("TC IS FAILED BECAUSE: " +errorMsg.toString());
			
			
	}
	else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("TC IS SKIPPED : " +tcName);
			Throwable errorMsg = result.getThrowable();
			extentTest.log(LogStatus.SKIP, "TC IS SKIPPED: " +tcName);
			extentTest.log(LogStatus.SKIP, result.getThrowable());
			System.out.println("TC IS FAILED BECAUSE: " +errorMsg.toString());
	       
	}
	extentReports.endTest(extentTest);
	}
	
	public static ExtentTest getExtentTest() {
		return extentTest;
	}
	
	static public String getTcName() {
		return tcName;
	}
	
	static public String getCurDir() {
		return curDir;
	}
	public static PropertiesUtilities getPrConf() {
		return prConf;
	}
	
	
	
}
