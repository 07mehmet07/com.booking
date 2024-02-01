package pages.flightspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class FlightsFarePage extends BasePage {

	@FindBy(css = "div.icn")
	List<WebElement> chooseFareButtons;

	@FindBy(css = "button.btn-blue > span")
	WebElement selectFlyingButton;

	public void ClickOnChooseFareButton(int i) {
		chooseFareButtons.get(i - 1).click();
	}

	public void ClickOnSelectFlyingButton() {
		selectFlyingButton.click();
	}

}
