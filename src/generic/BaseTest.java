/*We suppose to write static system set property for running further
 * and create an interface to declare and initialize all the variables*/

package generic;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
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
	
	@BeforeMethod
	public void openApp() {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS);
		driver.get(url);
	}
	
	
	@AfterMethod
	public void closeApp(){
	driver.close();

}
}
