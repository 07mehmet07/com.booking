package stepdefinitions.flights;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;


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
}