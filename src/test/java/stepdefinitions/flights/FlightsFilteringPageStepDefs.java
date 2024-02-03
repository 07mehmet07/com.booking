package stepdefinitions.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;


public class FlightsFilteringPageStepDefs extends BaseStep {

	private static Logger LOGGER = LogManager.getLogger(FlightsFilteringPageStepDefs.class);

	@And("the user clicks on the {string} tab on filtering page")
	public void theUserClicksOnTheTabOnFilteringPage(String optimalTicket) {
		PAGES.getFlightsSelectTicketPage().ClickOnOptimalFlightsTabs(optimalTicket);
		BrowserUtils.wait(2);
		LOGGER.info("The user selects the ticket listing type");
	}


	@And("the user click on #{int} see availability button of the fastest flight")
	public void theUserClickOnSeeAvailabilityButtonOfTheFastestFlight(int numberOfTicket) {
		PAGES.getFlightsSelectTicketPage().selectTicketForTravel(numberOfTicket);
		LOGGER.info("The user clicks on See Availability button ");

	}


	@And("the user click on #{int} select return ticket button of the fastest flight")
	public void theUserClickOnSelectReturnTicketButtonOfTheFastestFlight(int numberOfTicket) {
		PAGES.getFlightsSelectTicketPage().selectTicketForTravel(numberOfTicket);
		LOGGER.info("The user clicks on return ticket button");
	}

	@Then("verify that all the return tickets dates are {string} February")
	public void verifyThatAllTheReturnTicketsDatesAreFebruary(String dateOfReturnTicket) {
		then(PAGES.getFlightsSelectTicketPage().isDepartureDate(dateOfReturnTicket)).isTrue();
		LOGGER.debug("The user should see that all the return tickets dates are as expected");
	}

	@Then("Verify that origin main {string} as expected")
	public void verifyThatOriginMainAsExpected(String originMain) {
		then(PAGES.getFlightsSelectTicketPage().isCorrectOriginCountry(originMain)).isTrue();
		LOGGER.debug("The user should see that all the departure tickets locations are as expected");
	}

	@Then("verify that all the tickets dates are {string}")
	public void verifyThatAllTheTicketsDatesAre(String date) {
		then(PAGES.getFlightsSelectTicketPage().isDepartureDate(date)).isTrue();
		LOGGER.debug("The user should see that all the departure tickets dates are as expected");
	}

	@Then("verify that all the tickets types are {string}")
	public void verifyThatAllTheTicketsTypesAre(String classType) {
		then(PAGES.getFlightsSelectTicketPage().isBusinessCabin(classType)).isTrue();
		LOGGER.debug("The user should see that all tickets cabin type are as expected");

	}
}