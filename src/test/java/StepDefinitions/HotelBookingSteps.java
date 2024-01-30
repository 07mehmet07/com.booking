package StepDefinitions;

import hook.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
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
        PAGES.getStaysTabHomepage().sendKeysToDestination("New York");
        LOGGER.info("User sends New York as a destination");
    }

    @Given("chooses next month’s 8'th day to 10'th day")
    public void chooses_next_month_s_8_day_to_10_day() {
        PAGES.getStaysTabHomepage().clickDatePickerAndSelect(1);
        LOGGER.info("User selects days 8 to 10");
    }

    @Given("chooses one adult")
    public void chooses_one_adult() {
        LOGGER.info("One adult is selected default");
    }

    @Given("clicks search hotels button")
    public void clicks_search_hotels_button() {
        PAGES.getStaysTabHomepage().clickOnSearchButton();
        LOGGER.info("User Clicks on the Search Button");
    }

    @When("user navigated to hotel search page")
    public void user_navigated_to_hotel_search_page() {
        LOGGER.info("User is navigated to Hotel Search Page");
    }

    @When("user chooses first hotel")
    public void user_chooses_first_hotel() {
        PAGES.getHotelSearchPage().clickSeeAvailabilityButton(0);
        LOGGER.info("User clicks to See Availability Button");
    }

    @When("in the mentioned hotel’s description page user clicks reserve or book now")
    public void in_the_mentioned_hotel_s_description_page_user_clicks_reserve_or_book_now() {
        PAGES.getHotelInfoPage().clickBookNowButton();
        LOGGER.info("User in the Hotel's Info Page and clicks book now button");
    }

    @When("user sees checkout process’ first page")
    public void user_sees_checkout_process_first_page() {
        LOGGER.info("User in the Hotel's Detail Page");
    }

    @When("user fills first name, last name, email fields and clicks Next Final Details Button")
    public void user_fills_first_name_last_name_email_fields_and_clicks_next_final_details_button() {
        PAGES.getHotelDetailsPage().fillFirstNameField("Tarıq Jake");
        PAGES.getHotelDetailsPage().fillLastNameField("Gulbas");
        PAGES.getHotelDetailsPage().fillEmailField("Tarıq@gulbas.com");
        PAGES.getHotelDetailsPage().clickFinalDetailsButton();
    }

    @When("in the final details page user fills phone number, card holders name, card number, cvc afterwards clicks complete booking button")
    public void in_the_final_details_page_user_fills_phone_number_card_holders_name_card_number_cvc_afterwards_clicks_complete_booking_button() {
        PAGES.getHotelsCheckoutPage().fillPhoneNumberField("5555551234");
        PAGES.getHotelsCheckoutPage().fillCardHoldersNameField("Tarıq Jake Gulbas");
        PAGES.getHotelsCheckoutPage().fillCardNumberField("1234123412341234");
        PAGES.getHotelsCheckoutPage().fillExpDateField("11/28");
        PAGES.getHotelsCheckoutPage().fillCvvField("123");
        PAGES.getHotelsCheckoutPage().clickCompleteBookingButton();
    }

    @Then("user should see checkout dialogue and click close button properly")
    public void user_should_see_checkout_dialogue_and_click_close_button_properly() {
        boolean result = PAGES.getStaysTabHomepage().isTheDialogueDisplayed();
        Assertions.assertThat(result).isTrue();
    }

    @Then("verify user sees booking.com homepage")
    public void verify_user_sees_booking_com_homepage() {
        boolean result = DriverManager.getDriver().getCurrentUrl().startsWith("https://test.inar-academy.com/booking");
        Assertions.assertThat(result).isTrue();
    }
}