package stepdefinitions.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import stepdefinitions.BaseStep;

public class FlightsHomePageStepDefs extends BaseStep {

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

        //PAGES.getFlightsHomePage().selectDateFromOneWay(date);
    }

    @When("the user clicks on the search flights button")
    public void the_user_clicks_on_the_search_flights_button() {
        PAGES.getFlightsHomePage().clickOnSearchButton();
    }



}
