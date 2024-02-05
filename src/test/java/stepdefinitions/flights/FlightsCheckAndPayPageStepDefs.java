package stepdefinitions.flights;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsCheckAndPayPageStepDefs extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(FlightsCheckAndPayPageStepDefs.class);

	@When("The user enter {string} as cardholder's name")
	public void the_user_enter_as_cardholder_s_name(String string) {
		PAGES.getFlightsCheckAndPayPage().setCardholdersName(string);
		LOGGER.info("The user enters a cardholder's name");

	}

	@When("The user enter {string} as card number")
	public void the_user_enter_as_card_number(String string) {
		PAGES.getFlightsCheckAndPayPage().setCardNumber(string);
		LOGGER.info("The user enters a card number");

	}

	@When("The user enter {string} as expiration date")
	public void the_user_enter_as_expiration_date(String string) {
		PAGES.getFlightsCheckAndPayPage().setExpirationDate(string);
		LOGGER.info("The user enters a expiration date");

	}

	@When("The user enter {string} as cvv code")
	public void the_user_enter_as_cvv_code(String string) {
		PAGES.getFlightsCheckAndPayPage().setCvvOrCode(string);
		LOGGER.info("The user enters a cvv code");

	}

	@When("The user clicks on complete booking button")
	public void the_user_clicks_on_complete_booking_button() {
		PAGES.getFlightsCheckAndPayPage().clickOnCompletingBookingButton();
		LOGGER.info("The user clicks on the booking button");

	}

	@Then("verify {string} text message that under Thank you for your booking message")
	public void verify_text_message_that_under_thank_you_for_your_booking_message(String string) {
		then(PAGES.getFlightsBookingResultPage().getTextMessage(1)).isEqualTo(string);
		LOGGER.debug("The user should see message of Thank you for your booking ");

	}

	@Then("The user clicks on close button")
	public void the_user_clicks_on_close_button() {
		PAGES.getFlightsBookingResultPage().clickOnCloseButton();
		LOGGER.info("The user clicks on the close button");

	}

}