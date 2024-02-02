package pages.flightspage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class FlightsHomePage extends BasePage {

	@FindBy(css = "label.me-3 > span")
	List<WebElement> typeOfFlights;

	@FindBy(css = "select.headerSearchInput:nth-child(1)")
	WebElement flightTicketType;

	@FindBy(css = "select.headerSearchInput:nth-child(2)")
	WebElement fromDropdown;

	@FindBy(xpath = "(//div[@class='me-3'])[2]/../select")
	WebElement toDropdown;

	@FindBy(css = ".headerSearchText")
	WebElement dateField;

	@FindBy(css = "button.headerBtn")
	WebElement searchButton;

	@FindBy(xpath = "//div/select[@class='form-select fs-4 p-3']")
	List<WebElement> birthdateSelectors;

	@FindBy(xpath = "//span[text()='Flights']")
	WebElement flightsTab;

	@FindBy(css = ".rdrDays > button")
	List<WebElement> days;

	@FindBy(css = ".optionCounter > .optionCounterButton")
	List<WebElement> plusButtonsForTravelersNumbers;

	@FindBy(xpath = "//span[@class='headerSearchText'][1]")
	WebElement dateButton;

	@FindBy(xpath = "(//span[@class='headerSearchText'])[2]")
	WebElement passengersNumberButton;

	@FindBy(css = "button.p-3.py-2.fs-4.mt-5")
	WebElement doneButton;

	public void selectDaysOnTheDatePicker(int departureDay, int returnDay) {
		dateButton.click();
		List<WebElement> daysOnTheDatePicker = days.stream()
			.filter(day -> !day.getAttribute("class").contains("rdrDayPassive"))
			.toList();
		daysOnTheDatePicker.get(departureDay - 1).click();
		daysOnTheDatePicker.get(returnDay - 1).click();
	}

	public void selectTypeOfFlights(String typeName) {
		List<String> typeNames = typeOfFlights.stream().map(WebElement::getText).toList();
		typeOfFlights.get(typeNames.indexOf(typeName)).click();
	}

	public void selectFlightTicketType(String type) {
		Select select = new Select(flightTicketType);
		select.selectByVisibleText(type);
	}

	public void selectFromCountry(String country) {
		Select select = new Select(fromDropdown);
		select.selectByVisibleText(country);
	}

	public void selectToCountry(String country) {
		Select select = new Select(toDropdown);
		select.selectByVisibleText(country);
	}

	public void selectDateFromOneWay(String date) {
		actions.moveToElement(dateField).click().release().perform();
		JavascriptExecutor js = (JavascriptExecutor) DRIVER;
		js.executeScript("document.querySelector('input.form-select').value = '2024-05-12';");
	}

	public void clickOnFlights() {
		flightsTab.click();
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void selectNumberOfAdults(int number) {
		for (int i = 0; i < number; i++) {
			plusButtonsForTravelersNumbers.get(1).click();
		}
	}

	public void selectNumberOfChild(int number) {
		for (int i = 0; i < number; i++) {
			plusButtonsForTravelersNumbers.get(3).click();
		}
	}

	public void clickOnDoneButton() {
		doneButton.click();
	}

	public void clickOnPassengersNumberButton() {
		passengersNumberButton.click();
	}

}
