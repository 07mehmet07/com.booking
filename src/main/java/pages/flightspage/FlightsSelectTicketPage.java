package pages.flightspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

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

	public void ClickOnOptimalFlightsTabs(String optimalFlightsName) {
		List<String> names = optimalFlightsTab.stream().map(WebElement::getText).toList();
		actions.moveToElement(optimalFlightsTab.get(names.indexOf(optimalFlightsName))).click().release().perform();

	}

	public void selectTicketForTravel(int i) {
		selectTicketButtons.get(i).click();
	}

	public boolean verifyAllOriginCountryIsCorrect(String departure) {
		List<String> allMainCountries = allOriginCountry.stream().map(WebElement::getText).toList();
		return allMainCountries.stream().allMatch(countries -> countries.contains(departure));
	}

	public boolean verifyAdultNumber(String number) {
		return travelInformationTabs.get(3).getAttribute("value").contains(number);
	}

	public boolean verifyChildNumber(String numbers) {
		return travelInformationTabs.get(4).getAttribute("value").contains(numbers);
	}

	public boolean verifyAllCabinClassesAreCorrect(String cabinClasses) {
		List<String> cabinClass = cabinClassesNames.stream().map(WebElement::getText).toList();
		return cabinClass.stream().allMatch(cabins -> cabins.contains(cabinClasses));
	}

}
