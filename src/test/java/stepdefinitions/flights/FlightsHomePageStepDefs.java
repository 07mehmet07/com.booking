package stepdefinitions.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsHomePageStepDefs extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(FlightsHomePageStepDefs.class);

	@When("the user clicks on the flights tab")
	public void theUserClicksOnTheFlightsTab() {
		PAGES.getFlightsHomePage().clickOnFlights();
	}

	@When("the user clicks on the {string} radio")
	public void theUserClicksOnTheRadio(String flightType) {
		PAGES.getFlightsHomePage().selectTypeOfFlights(flightType);
	}

	@When("the user selects {string} as departure country")
	public void the_user_selects_as_departure_country(String string) {
		PAGES.getFlightsHomePage().selectFromCountry(string);
	}

	@When("the user selects {string} as destination country")
	public void the_user_selects_as_destination_country(String string) {
		PAGES.getFlightsHomePage().selectToCountry(string);

	}

	@And("the user selects {string} for date")
	public void theUserSelectsForDate(String date) {

		// PAGES.getFlightsHomePage().selectDateFromOneWay(date);
	}

	@And("the user clicks on the search flights button")
	public void the_user_clicks_on_the_search_flights_button() {
		PAGES.getFlightsHomePage().clickOnSearchButton();
	}

	@And("the user selects {string} flight class")
	public void theUserSelectsFlightClass(String flightClass) {
		PAGES.getFlightsHomePage().selectFlightTicketType(flightClass);
	}

	@And("The user selects #{int} as departure date and #{int} as return date")
	public void theUserSelectsAsDepartureDateAndAsReturnDate(int departureDay, int returnDay) {
		PAGES.getFlightsHomePage().selectDaysOnTheDatePicker(departureDay, returnDay);
	}

	@And("the user select #{int} child")
	public void theUserSelectChild(int no) {
		PAGES.getFlightsHomePage().clickOnPassengersNumberButton();
		PAGES.getFlightsHomePage().selectNumberOfChild(no);
		PAGES.getFlightsHomePage().clickOnDoneButton();
	}

	@And("the user select #{int} adults and #{int} children")
	public void theUserSelectAdultsAndChildren(int adultNum, int childNum) {
		PAGES.getFlightsHomePage().clickOnPassengersNumberButton();
		PAGES.getFlightsHomePage().selectNumberOfAdults(adultNum);
		PAGES.getFlightsHomePage().selectNumberOfChild(childNum);
		PAGES.getFlightsHomePage().clickOnDoneButton();
		BrowserUtils.wait(2);
	}

	@Then("verify that adults and children numbers are {string} adult and {string} children as expected")
	public void verifyThatAdultsAndChildrenNumbersAreAdultAndChildrenAsExpected(String adultNo, String childNo) {
		then(PAGES.getFlightsSelectTicketPage().verifyAdultNumber(adultNo)).isTrue();
		then(PAGES.getFlightsSelectTicketPage().verifyChildNumber(childNo)).isTrue();

	}

}
