package pages.flightspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class FlightsBookingResultPage extends BasePage {

	@FindBy(css = ".fs-3 > .fw-bold")
	List<WebElement> thanksMessage;

	@FindBy(css = "button.btn.btn-danger.fs-4")
	WebElement closeButton;

	public String getTextMessage(int i) {
		return thanksMessage.get(i - 1).getText();
	}

	public void clickOnCloseButton() {
		closeButton.click();
	}

}
