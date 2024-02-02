package stepdefinitions.flights;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;

public class FlightsFarePageStepDefs extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(FlightsFarePageStepDefs.class);

	@And("the user select {string} tab and click on Select Who ‘ s flying")
	public void theUserSelectTabAndClickOnSelectWhoSFlying(String fare) {

		PAGES.getFlightsFarePage().ClickOnChooseFareButton(fare);
		PAGES.getFlightsFarePage().ClickOnSelectFlyingButton();
	}

}
