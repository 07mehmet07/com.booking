package pages.carrentalspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class CarRentalsHomePage extends BasePage {

	@FindBy(css = ".headerListItem:last-child")
	private WebElement carRentalsTab;

	@FindBy(css = ".headerTitle")
	private WebElement welcomeHeadingForCarRentals;

	@FindBy(css = ".headerSearchInput")
	private WebElement enterPickupLocationField;

	@FindBy(xpath = "//input[@type='date']")
	private List<WebElement> datesForPickupAndDropOff;

	@FindBy(xpath = "//select[@class='form-select']")
	private List<WebElement> hoursForPickupAndDrop;

	@FindBy(css = ".headerBtn")
	private WebElement searchCarsButton;

	@FindBy(css = ".headerDateInput.form-control.fs-5")
	private WebElement enterPickupDateField;

	@FindBy(css = ".headerDateInput.form-control.fs-5.position-relative")
	private WebElement enterDropOffDateField;

	@FindBy(xpath = "//h1[text()='Car rental']")
	private WebElement welcomeHeadingForCarRentalsSearchResultPage;

	public CarRentalsHomePage() {

	}

	// This method can be used in Class that defined as the parent of CarRentalsHomePage

	public void clickOnCarRentalsTab() {
		carRentalsTab.click();
	}

	public boolean isWelcomeHeadingCorrect() {
		String welcomeHeading = welcomeHeadingForCarRentals.getText();
		return welcomeHeading.equalsIgnoreCase("Rent a Car for Your Trip");
	}

	/**
	 * @param date the format of the date should be yyyy-MM-dd
	 */

	public void setPickupDate(String date) {
		enterPickupDateField.sendKeys(date);
	}

	public void setDropOffDate(String date) {
		enterDropOffDateField.sendKeys(date);
	}

	public void enterValueIntoPickupLocationField(String placeToPickup) {
		enterPickupLocationField.clear();
		enterPickupLocationField.sendKeys(placeToPickup);
	}

	/**
	 * @param pickup Should be entered in military time format . Also, it should be only
	 * defined as the start of the hour such as "05.00" or as halfway through the hour
	 * such as "05.30".
	 * @param drop Should be entered in military time format . Also, it should be only
	 * defined as the start of the hour such as "05.00" or as halfway through the hour
	 * such as "05.30".
	 */

	public void enterHoursForPickupAndDrop(String pickup, String drop) {
		Select selectPickup = new Select(hoursForPickupAndDrop.get(0));
		selectPickup.selectByVisibleText(pickup);
		Select selectDrop = new Select(hoursForPickupAndDrop.get(1));
		selectDrop.selectByVisibleText(drop);
	}

	public void clickOnTheSearchCarsButton() {
		searchCarsButton.click();
	}

	public boolean isWelcomeHeadingForCarRentalsSearchResultPage() {
		String welcomeHeading = welcomeHeadingForCarRentalsSearchResultPage.getText();
		return welcomeHeading.equalsIgnoreCase("Car rental");
	}
}