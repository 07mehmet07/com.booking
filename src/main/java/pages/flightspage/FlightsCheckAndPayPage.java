package pages.flightspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class FlightsCheckAndPayPage extends BasePage {

	@FindBy(css = ".mb-4 > .form-control.fs-4")
	WebElement cardholdersName;

	@FindBy(css = ".d-flex.flex-row > .form-control.fs-4")
	List<WebElement> cardNoDateAndCvvInputAreas;

	@FindBy(css = ".btn.btn-blue")
	WebElement completingBookingButton;

	@FindBy(css = ".form-check>input")
	List<WebElement> informationOfMarketingEmail;

	public void setCardholdersName(String name) {
		cardholdersName.sendKeys(name);
	}

	public void setCardNumber(String cardNo) {
		cardNoDateAndCvvInputAreas.get(0).sendKeys(cardNo);
	}

	public void setExpirationDate(String expirationDate) {
		cardNoDateAndCvvInputAreas.get(1).sendKeys(expirationDate);
	}

	public void setCvvOrCode(String cvv) {
		cardNoDateAndCvvInputAreas.get(2).sendKeys(cvv);
	}

	public void clickOnCompletingBookingButton() {
		completingBookingButton.click();
	}

	public void clickOnInformationOfMarketingEmail() {
		informationOfMarketingEmail.get(0).click();
		informationOfMarketingEmail.get(1).click();

	}

}
