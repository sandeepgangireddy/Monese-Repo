package pageObjects;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import cucumber.api.DataTable;

public class ContactUs_Page extends BasePage {
	public @FindBy(xpath = "//input[@name='first_name']") WebElement textfield_FirstName;
	public @FindBy(xpath = "//input[@name='last_name']") WebElement textfield_LastName;
	public @FindBy(xpath = "//input[@name='email']") WebElement textfield_EmailAddress;
	public @FindBy(xpath = "//textarea[@name='message']") WebElement textfield_Message;
	public @FindBy(xpath = "//input[@value='SUBMIT']") WebElement button_Submit;
	public @FindBy(xpath = "//h1[contains(.,'Thank You for your Message!')]") WebElement messagefield_SuccessMessage;

	public ContactUs_Page() throws IOException {
		super();

	}

	public ContactUs_Page getContactUsPage() throws Throwable {
		getDriver().get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
		Thread.sleep(9000);
		return new ContactUs_Page();

	}

	public ContactUs_Page enterFirstName() throws Exception {
		sendKeysToWebElement(textfield_FirstName, "Tom");
		return new ContactUs_Page();

	}

	public ContactUs_Page enterLastName(DataTable dataTable, int row, int column)
			throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textfield_LastName, data.get(row).get(column));
		return new ContactUs_Page();
	}

	public ContactUs_Page enterEmailAddress(String email) throws Exception {
		sendKeysToWebElement(textfield_EmailAddress, email);
		return new ContactUs_Page();

	}

	public ContactUs_Page enterComments(DataTable dataTable, int row, int column)
			throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textfield_Message, data.get(row).get(column));
		return new ContactUs_Page();
	}

	public ContactUs_Page clickSubmitButton() throws Exception {
		waitAndClickElement(button_Submit);
		return new ContactUs_Page();

	}

	public ContactUs_Page conformContactUsFormSubmissionWasSuccessful()
			throws Exception {
		WaitUntilWebElementIsVisible(messagefield_SuccessMessage);
		WebElement thanksContactUsPage = getDriver().findElement(By.xpath("//h1[contains(.,'Thank You for your Message!')]"));
		Assert.assertEquals("thankyouforyourmessage!", thanksContactUsPage.getText().toLowerCase().replaceAll("[ ()0-9]", ""));
		return new ContactUs_Page();

	}

}
