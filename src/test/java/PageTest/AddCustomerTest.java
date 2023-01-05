package PageTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.AddCutomerPage;
import Pages.LoginPage;
import Pages.dashBoardPage;
import Util.BrowserFactory;

public class AddCustomerTest {
	WebDriver driver;
	@Test
	@Parameters({"username","password","fullName","companyName","email","phone","address","city","country","state","zip"})
	public void userShouldBeAbleToAddCustomer(String username,String password,String fullName,String companyName,
			String email,
			String phone,
			String address,
			String city,
			String country,
			String state,
			String zip) throws InterruptedException {
		driver = BrowserFactory.init();

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertUsername(username);
		Thread.sleep(2000);
		loginpage.insertPassword(password);
		Thread.sleep(2000);
		loginpage.elickSininButton();

		dashBoardPage dpage = PageFactory.initElements(driver, dashBoardPage.class);
		dpage.validateDashBoard("Dashboard");
		Thread.sleep(2000);
		dpage.clickcustomerMentElement1();
		Thread.sleep(2000);
	    dpage.clickAddcustomerMentElement();
	    Thread.sleep(2000);
	    
		AddCutomerPage acp = PageFactory.initElements(driver, AddCutomerPage.class);
		
		acp.insertFirstName(fullName);
		Thread.sleep(2000);
	
		acp.SelectCompanyName(companyName);
		Thread.sleep(2000);
		acp.insertEmail(email);
		Thread.sleep(2000);
		acp.insertPhoneNumber(phone);
		Thread.sleep(2000);
		acp.insertAddress(address);
		Thread.sleep(2000);
		acp.insertCity(city);
		Thread.sleep(2000);
		acp.insertState(state);
		Thread.sleep(2000);
		acp.insertZip(zip);
		Thread.sleep(2000);
		acp.selectCountry(country);
		Thread.sleep(2000);
		acp.clickonSaveButton();
		
		Thread.sleep(2000);
		dpage.clickLIstCustomer();
		Thread.sleep(2000);
		acp.validateInsertedCustomerAndDelete();
		
		Thread.sleep(2000);
		acp.clickConfirmButton();
		Thread.sleep(2000);
	
		BrowserFactory.tearDown();

	}

}
