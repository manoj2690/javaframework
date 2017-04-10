package testcases;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.ScbWrappers;

public class TC1 extends ScbWrappers{



	public TC1(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver; 
		this.test = test;
		if(!verifyTitle("Title of the Page")){
			reportStep("Step Description", "FAIL");
		}
	}
	
	//@BeforeClass - use hooks to call before each scenario @Before ("@scenario tag")
	public void setValues(String browser) {
		browserName=browser;
		testCaseName="TC001 - Login";
		testDescription="Login and Logout from Opentaps(Positive)";
		category="smoke";
		//call data provider
	}
	
	//Write step def methods based on feature file scenarios
}
