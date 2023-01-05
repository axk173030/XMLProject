package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCutomerPage extends BasePage {
	WebDriver driver;
	String insertedName;

	public AddCutomerPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")
	WebElement Add_contact_header;

	public void validateaddContactPage(String addContactHeader) {
		
		Assert.assertEquals(Add_contact_header.getText(), addContactHeader, "Add Contact Page is not available");
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement Add_furtname_Element;

	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement compant_Name_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement Add_Email_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement Add_Phone_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement Add_Address_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement Add_City_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement Add_State_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement Add_Zip_Element;

	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement Add_Country_Element;

	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SaveButton_Element;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/button[2]")
	WebElement Ok_Button_Element;

	public void insertFirstName(String fullName) {
		int genNum = generateRandomNo(999);
		insertedName = fullName + genNum;
		Add_furtname_Element.sendKeys(insertedName);

	}

	public void SelectCompanyName(String company) {

		selectFromDropDown(compant_Name_Element, company);

	}

	public void insertEmail(String emailaddress) {

		Add_Email_Element.sendKeys(emailaddress + generateRandomNo(999));

	}

	public void insertPhoneNumber(String phoneNO) {
		Add_Phone_Element.sendKeys(phoneNO + generateRandomNo(999));

	}

	public void insertAddress(String Address) {
		Add_Address_Element.sendKeys(Address);

	}

	public void insertCity(String city) {
		Add_City_Element.sendKeys(city);
	}

	public void insertState(String state) {
		Add_State_Element.sendKeys(state);

	}

	public void insertZip(String zip) {
		Add_Zip_Element.sendKeys(zip);
	}

	public void selectCountry(String country) {
		selectFromDropDown(Add_Country_Element, country);

	}

	public void clickonSaveButton() {
		SaveButton_Element.click();
	}

	public void clickConfirmButton() {

		Ok_Button_Element.click();

	}

	//// tbody/tr[1]/td[3]
	//// tbody/tr[2]/td[3]
	//// tbody/tr[3]/td[3]
	//// tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
	//Unable to find version of CDP to use for . You may need to include a dependency on a specific version of the CDP using something similar to `org.seleniumhq.selenium:selenium-devtools-v86:4.3.0` where the version ("v86") matches the version of the chromium-based browser you're using and the version number of the artifact is the same as Selenium's.
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";
	String after_xpath_delete = "]/td[3]/following-sibling::td[4]/a[2]";

	public void validateInsertedCustomerAndDelete() {
		for (int i = 1; i <= 100; i++) {
			String namesList = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			// System.out.println(namesList);
			// Assert.assertEquals(namesList, insertedName, "insertedName is not
			// available");

			if (namesList.equalsIgnoreCase(insertedName)) {
				System.out.println("Inserted name exist");
				driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
			}
			break;
		}

	}
}
