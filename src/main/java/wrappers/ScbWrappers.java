package wrappers;

import org.junit.Before;

public class ScbWrappers extends GenericWrappers{
	
	public String browserName;
	public String dataSheetName;
	

	//@BeforeSuite - need to have some annotation to use hooks like @Before ("@annotation")
	public void beforeSuite(){
		startResult();
	}

	//@BeforeTest - need to have some annotation to use hooks like @Beforetest ("@annotation")
	public void beforeTest(){
		loadObjects();
	}
	
	//@BeforeMethod - @Before
	public void beforeMethod(){
		test = startTestCase(testCaseName, testDescription);
		test.assignCategory(category);
		invokeApp(browserName);
	}
		
	//@AfterSuite -  need to have some annotation to use hooks like @AfterSuite ("@annotation")
	public void afterSuite(){
		endResult();
	}

	//@AfterTest -  - need to have some annotation to use hooks like @Aftertest ("@annotation")
	public void afterTest(){
		unloadObjects();
	}
	
	//@AfterMethod - @After
	public void afterMethod(){
		//endTestcase();
		quitBrowser();
		
	}
	
	//@DataProvider(name="fetchData") --> Point to Utils Data provider
/*	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}	
	*/

}
