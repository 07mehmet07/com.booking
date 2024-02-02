package stepdefinitions.flights;

import io.cucumber.java.en.And;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

public class FlightsFilteringPageStepDefs extends BaseStep {

    @And("the user clicks on the {string} tab on filtering page")
    public void theUserClicksOnTheTabOnFilteringPage(String optimalTicket) {
        PAGES.getFlightsSelectTicketPage().ClickOnOptimalFlightsTabs(optimalTicket);
        BrowserUtils.wait(2);
    }


    @And("the user click on #{int} see availability button of the fastest flight")
    public void theUserClickOnSeeAvailabilityButtonOfTheFastestFlight(int numberOfTicket) {
        PAGES.getFlightsSelectTicketPage().selectTicketForTravel(numberOfTicket);
    }


    @And("the user click on #{int} select return ticket button of the fastest flight")
    public void theUserClickOnSelectReturnTicketButtonOfTheFastestFlight(int numberOfTicket) {
            PAGES.getFlightsSelectTicketPage().selectTicketForTravel(numberOfTicket);
    }
}
