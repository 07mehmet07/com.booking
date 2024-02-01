package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsBookingTest extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(FlightsBookingTest.class);

	@Given("the user is on the Inar Academy homepage and clicks on the Booking link")
	public void the_user_is_on_the_ınar_academy_homepage_and_clicks_on_the_booking_link() {
		PAGES.getHomePage().clickBookingLink();
		PAGES.getFlightsHomePage().getFlightsPage();
		BrowserUtils.wait(1);
	}

	@When("the user clicks on the one way radio")
	public void the_user_clicks_on_the_one_way_radio() {
		PAGES.getFlightsHomePage().selectTravelMode();
	}

	@When("the user selects {string} as departure country")
	public void the_user_selects_as_departure_country(String string) {
		PAGES.getFlightsHomePage().selectDepartureCity(string);
	}

	@When("the user selects {string} as destination country")
	public void the_user_selects_as_destination_country(String string) {
		PAGES.getFlightsHomePage().selectDestinationCity(string);

	}

	@When("the user selects 01-02-2024 for date")
	public void the_user_selects_for_date() {
		PAGES.getFlightsHomePage().ClickOnDateForOneWay();
	}

	@When("the user clicks on the search flights button")
	public void the_user_clicks_on_the_search_flights_button() {
		PAGES.getFlightsHomePage().clickOnSearchButton();
	}

	@When("the user clicks on the fastest tab")
	public void the_user_clicks_on_the_fastest_tab() {
		PAGES.getFlightsSelectTicketPage().ClickOnOptimalFlightsTabs(2);
	}

	@When("the user click on first see availability button of the fastest flight")
	public void the_user_click_on_first_see_availability_button_of_the_fastest_flight() {
		PAGES.getFlightsSelectTicketPage().selectTicketForTravel();
	}

	@When("the user select main tab and click on Select Who ‘ s flying")
	public void the_user_select_main_tab_and_click_on_select_who_s_flying() {
		PAGES.getFlightsFarePage().ClickOnChooseFareButton(1);
		PAGES.getFlightsFarePage().ClickOnSelectFlyingButton();
	}

	@When("the user enter Inar@gmail.com to the contact email input area")
	public void the_user_enter_ınar_gmail_com_to_the_contact_email_input_area() {
		PAGES.getFlightsDetailsPage().setContactEmailArea("Inar@gmail.com");
		PAGES.getFlightsDetailsPage().setPhoneNumberArea("0543789974");
	}

	@When("the user enters as {string} first name and as {string} last name")
	public void the_user_enters_as_first_name_and_as_last_name(String string, String string2) {
		PAGES.getFlightsDetailsPage().setFirstNameInputAreas(1, string);
		PAGES.getFlightsDetailsPage().setLastNameInputAreas(2, string2);
		BrowserUtils.scrollDownWithPageDownButton(1);
	}

	@When("the user select male as gender")
	public void the_user_select_gender_as() {
		PAGES.getFlightsDetailsPage().selectMaleAsGender();
	}

	@When("the user select birthdate as {string} year and {string} month and {string} day")
	public void the_user_select_birthdate_as_year_and_month_and_day(String string, String string2, String string3) {
		PAGES.getFlightsDetailsPage().selectBirthDate(1, 2, 3, string, string2, string3);
	}

	@When("The user clicks on select extras button")
	public void the_user_clicks_on_select_extras_button() {
		PAGES.getFlightsDetailsPage().clickOnSelectExtrasButton();
	}

	@When("the user select Vegan Meal $14 from the select meal dropdown menu")
	public void the_user_select_vegan_meal_$_from_the_select_meal_dropdown_menu() {
		PAGES.getFlightsExtrasPage().setSelectMeal(4);
		BrowserUtils.scrollDownWithPageDownButton(1);
	}

	@When("the user select Add Extra Legroom Seat for extra")
	public void the_user_select_add_extra_legroom_seat_for_extra() {
		PAGES.getFlightsExtrasPage().clickOnExtras(3);
	}

	@When("The user click on go to checkout button")
	public void the_user_click_on_go_to_checkout_button() {
		PAGES.getFlightsExtrasPage().clickOnGoToCheckoutButton();
	}

	@When("The user enter {string} as cardholder's name")
	public void the_user_enter_as_cardholder_s_name(String string) {
		PAGES.getFlightsCheckAndPayPage().setCardholdersName(string);
	}

	@When("The user enter {string} as card number")
	public void the_user_enter_as_card_number(String string) {
		PAGES.getFlightsCheckAndPayPage().setCardNumber(string);
	}

	@When("The user enter {string} as expiration date")
	public void the_user_enter_as_expiration_date(String string) {
		PAGES.getFlightsCheckAndPayPage().setExpirationDate(string);
	}

	@When("The user enter {string} as cvv code")
	public void the_user_enter_as_cvv_code(String string) {
		PAGES.getFlightsCheckAndPayPage().setCvvOrCode(string);
	}

	@When("The user clicks on complete booking button")
	public void the_user_clicks_on_complete_booking_button() {
		PAGES.getFlightsCheckAndPayPage().clickOnCompletingBookingButton();
	}

	@Then("verify {string} text message that under Thank you for your booking message")
	public void verify_text_message_that_under_thank_you_for_your_booking_message(String string) {
		then(PAGES.getFlightsBookingResultPage().getTextMessage(1)).isEqualTo(string);
	}

	@Then("The user clicks on close button")
	public void the_user_clicks_on_close_button() {
		PAGES.getFlightsBookingResultPage().clickOnCloseButton();
	}

}
