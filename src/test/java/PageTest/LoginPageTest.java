package PageTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.dashBoardPage;
import Util.BrowserFactory;

/**
 * @author rsvac
 *
 */
public class LoginPageTest {
	
	WebDriver driver;
	
	
	String username;
	String password;
	
	
	
	@Test
	@Parameters({"username","password"})
	public void ValidUserShouldBeableToLogin(String userName,String password) throws InterruptedException {
		driver =BrowserFactory.init();
	//LoginPage loginpage= 	new LoginPage();
		LoginPage loginpage =PageFactory.initElements(driver, LoginPage.class);
	loginpage.insertUsername(userName);
	Thread.sleep(2000);
	loginpage.insertPassword(password);
	Thread.sleep(2000);
	loginpage.elickSininButton();
	
		
	dashBoardPage dpage = PageFactory.initElements(driver, dashBoardPage.class);
	dpage.validateDashBoard("Dashboard");
	dpage.clickLIstCustomer();
	Thread.sleep(2000);
	
	
	
	BrowserFactory.tearDown();

}
	private void DisplaydashBoard() {
		// TODO Auto-generated method stub
		
	}
}
