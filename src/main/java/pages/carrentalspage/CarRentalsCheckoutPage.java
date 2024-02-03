package pages.carrentalspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

public class CarRentalsCheckoutPage extends BasePage {

	@FindBy(name = "cvv")
	private WebElement cvvField;

	@FindBy(name = "cardNumber")
	private WebElement cardNumberField;

	@FindBy(name = "cardholderName")
	private WebElement cardHolderNameField;

	@FindBy(name = "expirationDate")
	private WebElement expirationDateField;

	@FindBy(name = "consentMarketingEmails")
	private WebElement consentMarketingEmailsCheckingBox;

	@FindBy(name = "consentTransportDeals")
	private WebElement consentTransportDealsCheckingBox;

	@FindBy(xpath = "(//button/strong)[1]")
	private WebElement backButton;

	@FindBy(xpath = "(//button/strong)[2]")
	private WebElement bookNowButton;

	@FindBy(css = ".carRentalItemDetails > h3")
	private WebElement tradeOfCar;

	@FindBy(xpath = "//div[contains(text(),'Invalid')]")
	private WebElement violationMessageOfCardInformation;

	@FindBy(xpath = "//h1[contains(text(),'Thank you')]")
	private WebElement confirmationMessageShownByPopUP;

	@FindBy(xpath = "(//span[@class='fw-bold fs-4'])[3]")
	private WebElement locationOfPickupOrDropOff;

	@FindBy(xpath = "//button[contains(text(),'Go to book')]")
	private WebElement goToBookButton;

	@FindBy(xpath = "//button[text()='View Deal']") // This element should be deleted from
	// this Class
	private WebElement viewDealButton;

	@FindBy(name = "phoneCountry")
	private WebElement areaCodeDropdown;

	@FindBy(xpath = "//div[@class='carRental-billing-address-inner']/div[1]/div[1]/input")
	private WebElement firstNameField;

	@FindBy(xpath = "//div[@class='carRental-billing-address-inner']/div[1]/div[2]/input")
	private WebElement lastNameField;

	@FindBy(xpath = "//div[@class='carRental-billing-address-inner']/div[2]/div/div[2]/input")
	private WebElement phoneNumberField;

	@FindBy(xpath = "//div[@class='carRental-billing-address-inner']/div[3]/input")
	private WebElement countryField;

	@FindBy(xpath = "//div[@class='carRental-billing-address-inner']/div[4]/input")
	private WebElement addressField;

	@FindBy(xpath = "//div[@class='carRental-billing-address-inner']/div[5]/div[1]/input")
	private WebElement cityField;

	@FindBy(name = "postalCode")
	private WebElement postalCodeField;

	@FindBy(id = "yes")
	private WebElement yesCheckbox;

	@FindBy(id = "no")
	private WebElement noCheckbox;

	public CarRentalsCheckoutPage() {

	}

	// This method should be deleted from this Class

	public void clickOnViewDealButton() {
		viewDealButton.click();
	}

	// This method should be deleted from this Class

	public void clickOnGoToBookButton() {
		BrowserUtils.scrollDownWithPageDownButton(2);
		BrowserUtils.wait(10);
		goToBookButton.click();
	}

	public void enterCardHoldersName(String name) {
		BrowserUtils.scrollDownWithPageDownButton(1);
		cardHolderNameField.clear();
		cardHolderNameField.sendKeys(name);
	}

	public void enterCardNumber(String cardNumber) {
		cardNumberField.clear();
		cardNumberField.sendKeys(cardNumber);
	}

	public void enterExpirationDate(String expirationDate) {
		expirationDateField.clear();
		expirationDateField.sendKeys(expirationDate);
	}

	public void enterCvv(String cvv) {
		cvvField.clear();
		cvvField.sendKeys(cvv);
	}

	public void enterCardInformation(String name, String cardNumber, String expirationDate, String cvv) {
		BrowserUtils.scrollUpWithPageUpButton(1);
		enterCardHoldersName(name);
		enterCardNumber(cardNumber);
		enterExpirationDate(expirationDate);
		enterCvv(cvv);
	}

	public boolean isConfirmationMessageDisplayedWithCorrectName(String userName) {
		String confirmationMessage = confirmationMessageShownByPopUP.getText();
		return confirmationMessage.contains(userName);
	}

	public void clickOnConsentMarketingEmailsCheckingBox() {
		consentMarketingEmailsCheckingBox.click();
	}

	public void clickOnConsentTransportDealsCheckingBox() {
		consentTransportDealsCheckingBox.click();
	}

	public void clickOnBackButton() {
		backButton.click();
	}

	public void clickOnBookNowButton() {

		bookNowButton.click();
	}

	public boolean isThisDealingPage() {
		return goToBookButton.isDisplayed();
	}

	public boolean isViolationMessageDisplayed() {
		return violationMessageOfCardInformation.isDisplayed();
	}

	public boolean isTradeOfCarCorrect(String selectedTradeOfCar) {
		BrowserUtils.scrollUpWithPageUpButton(2);
		return selectedTradeOfCar.equalsIgnoreCase(tradeOfCar.getAccessibleName());
	}

	public boolean isLocationOfPickupOrDropOffCorrect(String location) {
		return location.equalsIgnoreCase(locationOfPickupOrDropOff.getText());
	}

	public void enterFirstName(String firstName) {
		BrowserUtils.scrollUpWithPageUpButton(1);
		firstNameField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}

	public void enterPhoneNumber(String phoneNumber) {
		phoneNumberField.sendKeys(phoneNumber);
	}

	public void enterCountry(String country) {
		countryField.sendKeys(country);
	}

	public void enterAddress(String address) {
		addressField.sendKeys(address);
	}

	public void enterCity(String city) {
		cityField.sendKeys(city);
	}

	public void enterPostalCode(String postalCode) {
		postalCodeField.sendKeys(postalCode);
	}

	public void clickOnYesButton() {
		yesCheckbox.click();
	}

	public void clickOnNoButton() {
		noCheckbox.click();
	}

	public void selectAreaCodeOnDropdown(String code) {
		Select select = new Select(areaCodeDropdown);
		areaCodeDropdown.click();
		select.selectByValue(code);
		phoneNumberField.click();
	}

	public boolean isThisCheckoutPage() {

		BrowserUtils.moveToElement(bookNowButton);
		return  bookNowButton.isDisplayed();
	}
}
