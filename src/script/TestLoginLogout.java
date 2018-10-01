package script;


import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.HomePage;
import page.LoginPage;

public class TestLoginLogout extends BaseTest {
	
		@Test(priority=1,groups= {"login","smoke"})
		public void testLoginLogout(){
			
			//Get the data from excel
			String sheet="TestLoginLogout";
			String un = Utility.getXLData(INPUT_PATH, sheet, 1,0);
			String pw=Utility.getXLData(INPUT_PATH, sheet, 1, 1);
			
			//Enter valid user name un, password pw
			LoginPage loginpage= new LoginPage(driver);
			loginpage.setUserName(un);
			loginpage.setPwdName(pw);
			loginpage.clickLogin();
			
			//click log out
			HomePage homepage= new HomePage(driver);
			homepage.clickLogout();
		}
		
	 }
