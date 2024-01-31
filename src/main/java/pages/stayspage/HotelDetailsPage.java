package pages.stayspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class HotelDetailsPage extends BasePage {

	@FindBy(xpath = "(//input[@name=\"firstname\"])")
	private WebElement firstNameField;

	@FindBy(xpath = "(//input[@name=\"lastname\"])")
	private WebElement lastNameField;

	@FindBy(xpath = "(//input[@name=\"email\"])")
	private WebElement emailField;

	@FindBy(xpath = "//span[contains(text(),'Next, Final Details')]")
	private WebElement finalDetailsButton;

	@FindBy(xpath = "//span[@class='ms-2 fw-normal']")
	private List<WebElement> travelPurpose;

	@FindBy(xpath = "//span[@class='fw-normal fs-4']")
	private List<WebElement> notStayer;

	public void fillFirstNameField(String text) {
		firstNameField.sendKeys(text);
	}

	public void fillLastNameField(String text) {

		lastNameField.sendKeys(text);
		BrowserUtils.wait(0.5);
	}

	public void fillEmailField(String text) {
		emailField.sendKeys(text);
		BrowserUtils.wait(0.5);
	}

	public void clickFinalDetailsButton() {
		finalDetailsButton.click();
		BrowserUtils.wait(0.5);
	}

	public void selectTheTravelForWork(String selection) {
		if (selection.equalsIgnoreCase("Yes")) {
			travelPurpose.get(0).click();
		}
		else if (selection.equalsIgnoreCase("No")) {
			travelPurpose.get(1).click();
		}
	}

	public void selectTheWhoAreYouBookingFor(int selection) {
		if (selection == 1) {
			notStayer.get(0).click();
		}
		else if (selection == 2) {
			notStayer.get(1).click();
		}
	}

}
