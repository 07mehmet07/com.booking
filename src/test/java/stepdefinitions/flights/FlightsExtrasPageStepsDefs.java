package stepdefinitions.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsExtrasPageStepsDefs extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(FlightsExtrasPageStepsDefs.class);

	@And("the user select Add Extra Legroom Seat for extra")
	public void theUserSelectAddExtraLegroomSeatForExtra() {
		PAGES.getFlightsExtrasPage().clickOnExtras(3);
	}

	@When("The user click on go to checkout button")
	public void the_user_click_on_go_to_checkout_button() {
		PAGES.getFlightsExtrasPage().clickOnGoToCheckoutButton();
	}

	@Then("Verify that total price is correct")
	public void verifyThatTotalPriceIsCorrect() {
		then(PAGES.getFlightsExtrasPage().isCorrectTotalPriceOfExtra()).isTrue();
	}

}
