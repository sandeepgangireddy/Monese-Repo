package stepDefinitions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class MasterHooks extends DriverFactory {
	
	@Before
	public void setup() throws Exception  {
		driver = getDriver();
		
	}

	@After
	public void tearDownAndScreenshotonFailure(Scenario scenario) {
		try {
			if(driver !=null && scenario.isFailed()) 
			{
				//Scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"image/png");
				scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"image/png");
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
				
		if(driver !=null) {
			driver.manage().deleteAllCookies();
			driver.quit();
			driver = null;
		}
	} catch(Exception e) {
		System.out.println("Method Failed : tearDownAndScreenshotFailure,Exception"+ e.getMessage());
	}
}
}
