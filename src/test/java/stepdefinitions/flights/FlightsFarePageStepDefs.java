package stepdefinitions.flights;

import io.cucumber.java.en.And;
import stepdefinitions.BaseStep;

public class FlightsFarePageStepDefs extends BaseStep {

    @And("the user select {string} tab and click on Select Who ‘ s flying")
    public void theUserSelectTabAndClickOnSelectWhoSFlying(String fare) {

        PAGES.getFlightsFarePage().ClickOnChooseFareButton(fare);
        PAGES.getFlightsFarePage().ClickOnSelectFlyingButton();
    }

}
