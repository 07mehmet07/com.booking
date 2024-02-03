package stepdefinitions.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;

public class FlightsExtrasPageStepsDefs extends BaseStep {


	private static final Logger LOGGER = LogManager.getLogger(FlightsCheckAndPayPageStepDefs.class);

	@And("the user select Add Extra Legroom Seat for extra")
	public void theUserSelectAddExtraLegroomSeatForExtra() {
		PAGES.getFlightsExtrasPage().clickOnExtras(3);
		LOGGER.info("The user selects Extra Legroom Seat");

	}

	@When("The user click on go to checkout button")
	public void the_user_click_on_go_to_checkout_button() {
		PAGES.getFlightsExtrasPage().clickOnGoToCheckoutButton();
		LOGGER.info("The user clicks on Go To Checkout button");

	}

}