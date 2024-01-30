package StepDefinitions;

import hook.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.DriverManager;

public class HotelBookingSteps extends Hooks {
    public static final Logger LOGGER = LogManager.getLogger(HotelBookingSteps.class);

    @Given("user is in the booking.com page")
    public void user_is_in_the_booking_com_page() {
        DriverManager.getDriver().get("https://test.inar-academy.com/booking");
        LOGGER.info("User is navigated to the booking.com page");
    }
    @Given("types New York in the search bar")
    public void types_new_york_in_the_search_bar() {
    }
    @Given("chooses next month’s #{int} day to #{int} day")
    public void chooses_next_month_s_day_to_day(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("chooses one adult")
    public void chooses_one_adult() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("clicks search hotels button")
    public void clicks_search_hotels_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user navigated to hotel search page")
    public void user_navigated_to_hotel_search_page() {
        PAGES.getHotelSearchPage().clickSeeAvailabilityButton(0);
        LOGGER.info("User is navigated to the booking.com page");

    }
    @When("user chooses first hotel")
    public void user_chooses_first_hotel() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("in the mentioned hotel’s description page user clicks reserve or book now")
    public void in_the_mentioned_hotel_s_description_page_user_clicks_reserve_or_book_now() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user sees checkout process’ first page")
    public void user_sees_checkout_process_first_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user fills first name, last name, email fields and clicks Next Final Details Button")
    public void user_fills_first_name_last_name_email_fields_and_clicks_next_final_details_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("in the final details page user fills phone number, card holders name, card number, cvc afterwards clicks complete booking button")
    public void in_the_final_details_page_user_fills_phone_number_card_holders_name_card_number_cvc_afterwards_clicks_complete_booking_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user should see checkout dialogue and click close button properly")
    public void user_should_see_checkout_dialogue_and_click_close_button_properly() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("verify user sees booking.com homepage")
    public void verify_user_sees_booking_com_homepage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
