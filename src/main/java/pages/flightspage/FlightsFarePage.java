package pages.flightspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class FlightsFarePage extends BasePage {

	@FindBy(className = "ms-3")
	List<WebElement> chooseFareButtons;

	@FindBy(css = "button.btn-blue > span")
	WebElement selectFlyingButton;

	public void ClickOnChooseFareButton(String fare) {
		List<String> selectsFare = chooseFareButtons.stream().map(WebElement::getText).toList();
		chooseFareButtons.get(selectsFare.indexOf(fare)).click();

	}

	public void ClickOnSelectFlyingButton() {
		selectFlyingButton.click();
	}

}
