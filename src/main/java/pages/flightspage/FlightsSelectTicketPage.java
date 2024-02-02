package pages.flightspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class FlightsSelectTicketPage extends BasePage {

	@FindBy(css = "button.text-center")
	List<WebElement> selectTicketButtons;

	@FindBy(xpath = "//h1[@class='flight-title']/../span[3]")
	List<WebElement> allOriginCountry;

	@FindBy(css = ".shadow-md.form-select.fs-4")
	List<WebElement> travelInformationTabs;

	@FindBy(xpath = "//h1[@class='flight-title']/../span[1]")
	List<WebElement> cabinClassesNames;

	@FindBy(css = ".listResultTabs > button")
	List<WebElement> optimalFlightsTab;

	@FindBy(xpath = "//h1[@class=\"flight-title\"]/../span[3]")
	List<WebElement> departureDates;

	@FindBy(xpath = "(//div[@class='lsOptions p-0'])[1]/div/input")
	List<WebElement> flightCabinTypes;

	@FindBy(xpath = "//div[@class='searchItem flightItem']//span[@class='siCancelOpSubtitle']")
	List<WebElement> cabinClassOnTickets;

	@FindBy(xpath = "//span[@class='flight-deperture-time']/..//span[2]")
	List<WebElement> departureCountries;

	@FindBy(xpath = "//span[@class='flight-arrival-time']/..//span[2]")
	List<WebElement> arrivalCountries;

	public boolean isDepartureDate(String departureDay) {
		return departureDates.stream().allMatch(day -> day.getText().contains(departureDay));
	}

	public void ClickOnOptimalFlightsTabs(String optimalFlightsName) {
		List<String> names = optimalFlightsTab.stream().map(WebElement::getText).toList();
		actions.moveToElement(optimalFlightsTab.get(names.indexOf(optimalFlightsName))).click().release().perform();

	}

	public void selectTicketForTravel(int i) {
		selectTicketButtons.get(i - 1).click();
	}

	public boolean isCorrectOriginCountry(String city) {
		return travelInformationTabs.get(0).getAttribute("value").contains(city);
	}

	public boolean isSelectedDepartureCountry(String departureCountry) {
		List<String> list = departureCountries.stream().map(WebElement::getText).toList();
		return departureCountries.stream().allMatch(country -> country.getText().contains(departureCountry));
	}

	public boolean isSelectedArrivalCountry(String arrivalCountry) {
		List<String> list = arrivalCountries.stream().map(WebElement::getText).toList();
		return arrivalCountries.stream().allMatch(country -> country.getText().contains(arrivalCountry));
	}

	public boolean verifyAllOriginCountryIsCorrect(String departure) {
		List<String> allMainCountries = allOriginCountry.stream().map(WebElement::getText).toList();
		return allMainCountries.stream().allMatch(countries -> countries.contains(departure));
	}

	public boolean verifyAdultNumber(String number) {
		return travelInformationTabs.get(2).getAttribute("value").contains(number);
	}

	public boolean verifyChildNumber(String numbers) {
		return travelInformationTabs.get(3).getAttribute("value").contains(numbers);
	}

	public boolean verifyAllCabinClassesAreCorrect(String cabinClasses) {
		List<String> cabinClass = cabinClassesNames.stream().map(WebElement::getText).toList();
		return cabinClass.stream().allMatch(cabins -> cabins.contains(cabinClasses));
	}

	public boolean isBusinessCabin(String classType) {
		BrowserUtils.scrollDownWithPageDownButton(1);

		flightCabinTypes.get(2).click();

		if (cabinClassOnTickets.isEmpty()) {
			return true;
		}
		else {
			return cabinClassOnTickets.stream().allMatch(ticket -> ticket.getText().contains(classType));
		}
	}

}
