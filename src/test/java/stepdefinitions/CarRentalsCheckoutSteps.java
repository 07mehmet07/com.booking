package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarRentalsCheckoutSteps extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(CarRentalsCheckoutSteps.class);

	@When("the user clicks on the Search Cars button")
	public void the_user_clicks_on_the_search_cars_button() {

		PAGES.getCarRentalsHomePage().clickOnTheSearchCarsButton();
		LOGGER.info("The user navigates to the Car Rentals Search Results Page");
	}

	@When("the user clicks on the View Deal button of the Selected Car")
	public void the_user_clicks_on_the_view_deal_button_of_the_selected_car() {

		PAGES.getCarRentalsCheckoutPage().clickOnViewDealButton();
		LOGGER.info("The user navigates to the Car Rentals Dealing Page");
	}

	@When("the user clicks on the Go to book button")
	public void the_user_clicks_on_the_go_to_book_button() {

		PAGES.getCarRentalsCheckoutPage().clickOnGoToBookButton();
		LOGGER.info("The user navigates to the Car Rentals Checkout Page");
	}

	@Then("the user should see the Trade of car is correct as {string}")
	public void theUserShouldSeeTheTradeOfCarIsCorrectAs(String selectedTradeOfCar) {

		boolean isTradeOfCarCorrect = PAGES.getCarRentalsCheckoutPage().isTradeOfCarCorrect(selectedTradeOfCar);
		softAssertions.assertThat(isTradeOfCarCorrect)
			.as("Actual trade of car is not the same with the one which we had selected previously")
			.isTrue();
	}

	@And("the user should see the location of Pickup and Drop-off is correct as {string}")
	public void theUserShouldSeeTheLocationOfPickupAndDropOffIsCorrectAs(String location) {

		boolean isLocationOfPickupOrDropOffCorrect = PAGES.getCarRentalsCheckoutPage()
			.isLocationOfPickupOrDropOffCorrect(location);
		softAssertions.assertThat(isLocationOfPickupOrDropOffCorrect)
			.as("Actual location is not the same with the one which we had selected previously")
			.isTrue();
	}

	@When("the user enters First Name as {string}")
	public void the_user_enters_first_name_as(String name) {

		PAGES.getCarRentalsCheckoutPage().enterFirstName(name);
		LOGGER.debug("The user enters first name");
	}

	@When("the user enters Last Name as {string}")
	public void the_user_enters_last_name_as(String surname) {

		PAGES.getCarRentalsCheckoutPage().enterLastName(surname);
		LOGGER.debug("The user enters last name");

	}

	@When("the user enters Code of Phone Number as {string}")
	public void the_user_enters_code_of_phone_number_as(String codeNumber) {

		PAGES.getCarRentalsCheckoutPage().selectAreaCodeOnDropdown(codeNumber);
		LOGGER.debug("The user enters area code number");
	}

	@When("the user enters Phone Number as {string}")
	public void the_user_enters_phone_number_as(String phoneNumber) {

		PAGES.getCarRentalsCheckoutPage().enterPhoneNumber(phoneNumber);
		LOGGER.debug("The user enters phone number");
	}

	@When("the user enters Country as {string}")
	public void the_user_enters_country_as(String country) {

		PAGES.getCarRentalsCheckoutPage().enterCountry(country);
		LOGGER.debug("The user enters country");
	}

	@When("the user enters Address as {string}")
	public void the_user_enters_address_as(String address) {

		PAGES.getCarRentalsCheckoutPage().enterAddress(address);
		LOGGER.debug("The user enters address");
	}

	@When("the user enters City as {string}")
	public void the_user_enters_city_as(String city) {

		PAGES.getCarRentalsCheckoutPage().enterCity(city);
		LOGGER.debug("The user enters city");
	}

	@When("the user enters Postal Code as {string}")
	public void the_user_enters_postal_code_as(String postalCode) {

		PAGES.getCarRentalsCheckoutPage().enterPostalCode(postalCode);
		LOGGER.debug("The user enters postalCode");
	}

	@When("the user selects whether this booking is for a business")
	public void the_user_selects_whether_this_booking_is_for_a_business() {

		PAGES.getCarRentalsCheckoutPage().clickOnYesButton();
		LOGGER.debug("The user enters yes button");
	}

	@When("the user enters Cardholder's Name as {string}")
	public void the_user_enters_cardholder_s_name_as(String name) {

		PAGES.getCarRentalsCheckoutPage().enterCardHoldersName(name);
		LOGGER.debug("The user enters Cardholder's Name");
	}

	@When("the user enters Card Number as {string}")
	public void the_user_enters_card_number_as(String cardNumber) {

		PAGES.getCarRentalsCheckoutPage().enterCardNumber(cardNumber);
		LOGGER.debug("The user enters cardNumber");
	}

	@When("the user enters Expiration Date as {string}")
	public void the_user_enters_expiration_date_as(String expirationDate) {

		PAGES.getCarRentalsCheckoutPage().enterExpirationDate(expirationDate);
		LOGGER.debug("The user enters expirationDate");
	}

	@When("the user enters CVV \\(CVC) Code as {string}")
	public void the_user_enters_cvv_cvc_code_as(String cvv) {

		PAGES.getCarRentalsCheckoutPage().enterCvv(cvv);
		LOGGER.debug("The user enters cvv");
	}

	@When("the user selects to get emails from Booking.com")
	public void the_user_selects_to_get_emails_from_booking_com() {

		PAGES.getCarRentalsCheckoutPage().clickOnConsentMarketingEmailsCheckingBox();
		LOGGER.debug("The user selects to get email");
	}

	@When("the user selects to get emails from Booking Transport Limited")
	public void the_user_selects_to_get_emails_from_booking_transport_limited() {

		PAGES.getCarRentalsCheckoutPage().clickOnConsentTransportDealsCheckingBox();
		LOGGER.debug("The user selects to get email");
	}

	@When("the user click on the Book Now button")
	public void the_user_click_on_the_book_now_button() {

		PAGES.getCarRentalsCheckoutPage().clickOnBookNowButton();
		LOGGER.debug("The user clicks on book now button");
	}

	@Then("the user validate confirmation message with correct user name as {string}")
	public void theUserValidateConfirmationMessageWithCorrectUserNameAs(String userName) {

		boolean isCorrectConfirmation = PAGES.getCarRentalsCheckoutPage()
			.isConfirmationMessageDisplayedWithCorrectName(userName);
		softAssertions.assertThat(isCorrectConfirmation)
			.as("The confirmation popup does not include the correct user's name")
			.isTrue();
		softAssertions.assertAll();
	}

}
