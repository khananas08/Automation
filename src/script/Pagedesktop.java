package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagedesktop {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/hp/Desktop/Page1.html");
		//given index which is 0 in args
		driver.switchTo().frame(0);
		driver.findElement(By.id("t2")).sendKeys("a");
		driver.switchTo().parentFrame();
		driver.findElement(By.id("t1")).sendKeys("a");
		//given String in the arg
		driver.switchTo().frame("f1");
		driver.findElement(By.id("t2")).sendKeys("b");
		driver.switchTo().parentFrame();
		driver.findElement(By.id("t1")).sendKeys("b");
		//Given Web element in the arg 
		WebElement e = driver.findElement(By.id("f1"));
		driver.switchTo().frame(e);
		driver.findElement(By.id("t2")).sendKeys("c");
		//for the Main page
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t1")).sendKeys("c");
		driver.close();
	}

}
