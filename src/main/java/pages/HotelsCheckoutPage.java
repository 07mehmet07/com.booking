package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

}
