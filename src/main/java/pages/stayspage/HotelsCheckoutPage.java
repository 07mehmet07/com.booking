package pages.stayspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

public class HotelsCheckoutPage extends BasePage {

	@FindBy(xpath = "//input[@name=\"phone\"]")
	private WebElement phoneNumberField;

	@FindBy(xpath = "//input[@name=\"cardholderName\"]")
	private WebElement cardHoldersNameField;

	@FindBy(xpath = "//input[@name='cardNumber']")
	private WebElement cardNumberField;

	@FindBy(xpath = "//input[@name='expirationDate']")
	private WebElement expDateField;

	@FindBy(xpath = "//input[@name='cvv']")
	private WebElement cvvField;

	@FindBy(xpath = "//span[text()=\"Complete Booking\"]")
	private WebElement completeBookingButton;

	@FindBy(xpath = "//select[@name='phoneCountry']")
	private WebElement selectPhoneCountry;

	@FindBy(xpath = "//div[contains(text(),'Invalid phone number')]")
	private WebElement invalidPhoneNumberMessage;

	public void fillPhoneNumberField(String text) {
		phoneNumberField.sendKeys(text);
	}

	public void fillCardHoldersNameField(String text) {
		cardHoldersNameField.sendKeys(text);
	}

	public void fillCardNumberField(String text) {
		cardNumberField.sendKeys(text);
	}

	public void fillExpDateField(String text) {
		expDateField.sendKeys(text);
	}

	public void fillCvvField(String text) {
		cvvField.sendKeys(text);
	}

	public void clickCompleteBookingButton() {
		completeBookingButton.click();
	}

	public void selectPhoneCountry(String countryAbbreviation) {
		Select country = new Select((WebElement) selectPhoneCountry);
		switch (countryAbbreviation) {
			case "US" -> country.getOptions().get(0).click();
			case "CA" -> country.getOptions().get(1).click();
			case "UK" -> country.getOptions().get(2).click();
			case "DE" -> country.getOptions().get(3).click();
			case "FR" -> country.getOptions().get(4).click();
			case "AU" -> country.getOptions().get(5).click();
			case "JP" -> country.getOptions().get(6).click();
		}
	}

	public boolean isDisplayedInvalidPhoneNumberMessage() {
		return phoneNumberField.isDisplayed();
	}

}