package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CarRentalsHomePage extends BasePage {

	// This element can be used in the page that defined as the parent of
	// CarRentalsHomePage

	@FindBy(css = ".headerListItem:last-child")
	private WebElement carRentalsTab;

	@FindBy(css = ".headerTitle")
	private WebElement welcomeHeadingForCarRentals;

	@FindBy(css = ".headerSearchInput")
	private WebElement enterPickupLocationField;

	@FindBy(xpath = "//input[@type='date']")
	private List<WebElement> datesForPickupAndDropOff;

	@FindBy(css = ".form-select")
	private List<WebElement> hoursForPickupAndDrop;

	@FindBy(css = ".headerBtn")
	private WebElement searchCarsButton;

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

	public void enterValueIntoPickupLocationField(String placeToPickup) {
		enterPickupLocationField.clear();
		enterPickupLocationField.sendKeys(placeToPickup);
	}

	public void choosePickupDate(String day, String month, String year) {
		datesForPickupAndDropOff.get(1).click();
		Select select = new Select(datesForPickupAndDropOff.get(1));

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
		Select selectPickup = new Select(datesForPickupAndDropOff.get(1));
		Select selectDrop = new Select(datesForPickupAndDropOff.get(2));
		selectPickup.selectByVisibleText(pickup);
		selectDrop.selectByVisibleText(drop);
	}

	public void clickOnTheSearchCarsButton() {
		searchCarsButton.click();
	}

}