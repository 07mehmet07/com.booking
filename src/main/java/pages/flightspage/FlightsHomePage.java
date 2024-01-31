package pages.flightspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class FlightsHomePage extends BasePage {

	@FindBy(css = ".me-3 > input")
	List<WebElement> travelMode;

	@FindBy(css = "select.headerSearchInput.w-100")
	List<WebElement> classesAndCities;

	@FindBy(css = "button.rdrDay")
	List<WebElement> flightDate;

	@FindBy(css = "button.rdrNextButton")
	WebElement nextButton;

	@FindBy(css = "button.optionCounterButton")
	List<WebElement> buttonsForAdultAndChild;

	@FindBy(css = "button.headerBtn.h-100")
	WebElement searchFlightsButton;

	@FindBy(css = "button.fs-4.mt-5")
	WebElement doneButton;

	public void selectTravelMode() {
		travelMode.get(0).click();
	}

	public void selectFlightClasses(String type) {
		Select select = new Select(classesAndCities.get(0));
		select.selectByValue(type);
	}

	public void selectDepartureCity(String originCountry) {
		Select select = new Select(classesAndCities.get(1));
		select.selectByValue(originCountry);
	}

	public void selectDestinationCity(String targetCountry) {
		Select select = new Select(classesAndCities.get(2));
		select.selectByValue(targetCountry);
	}

	public void clickOnNextButtonForDate(int i) {
		for (int j = 0; j < i; j++) {
			nextButton.click();
		}
	}

	public void selectDateOfFlight(int departureDay, int returnDay) {
		List<WebElement> activeDaysOfMonth = flightDate.stream()
			.filter(days -> !days.getAttribute("class").contains("rdrDayPassive"))
			.toList();
		activeDaysOfMonth.get(departureDay - 1).click();
		activeDaysOfMonth.get(returnDay - 1).click();
	}

	public void selectNumbersOfAdult(int number, int k) {
		for (int i = 0; i < number; i++) {
			buttonsForAdultAndChild.get(k - 1).click();
		}
	}

	public void selectNumbersOfChild(int numbers, int j) {
		for (int i = 0; i < numbers; i++) {
			buttonsForAdultAndChild.get(j - 1).click();
		}
	}

	public void clickOnSearchButton() {
		searchFlightsButton.click();
	}

	public void clickOnDoneButton() {
		doneButton.click();
	}

}
