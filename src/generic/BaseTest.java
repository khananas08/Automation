/*We suppose to write static system set property for running further
 * and create an interface to declare and initialize all the variables*/

package generic;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;


import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
@Listeners(RESULT.class)
abstract public class BaseTest implements IAutoConst {
	public WebDriver driver;//never make as a static and final because if we can make it as
	//static we only run on one browser and parallel execution isn't possible 
	public String url=Utility.getPropertyValue(CONFIG_PATH, "URL");
	 String s =Utility.getPropertyValue(CONFIG_PATH, "ITO");
	public long duration=Long.parseLong(s);
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE );
	}
	@Parameters({"ip","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(@Optional("localhost")String ip, @Optional("chrome")String browser) 
	{
		//driver= new ChromeDriver();
		driver=Utility.openBrowser(driver,ip,browser);
		driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS);
		driver.get(url);
	}
	
	
	@AfterMethod
	public void closeApp(ITestResult result) {
	String name = result.getName();
	int status = result.getStatus();
	if(status==2)
	{
		String path=Utility.getPhoto(driver, PHOTO_PATH);
		
		Reporter.log("Test:"+name+"is FAILED & PHOTO is:"+path,true);
		}
	else {
		Reporter.log("Test : " + name + " is PASSED ",true);
	}
	
	driver.quit();

}
}
