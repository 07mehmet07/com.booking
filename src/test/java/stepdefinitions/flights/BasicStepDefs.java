package stepdefinitions.flights;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;

public class BasicStepDefs extends BaseStep {
	private static final Logger LOGGER = LogManager.getLogger(FlightsHomePageStepDefs.class);
	@Given("the user is on the Inar Academy homepage and clicks on the Booking link")
	public void the_user_is_on_the_ınar_academy_homepage_and_clicks_on_the_booking_link() {
		PAGES.getHomePage().clickBookingLink();
		LOGGER.info("The user on the Inar Academy Home Page and clicks on the booking link");

	}

}