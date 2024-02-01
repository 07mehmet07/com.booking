package pages.carrentalspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CarRentalsDealingPage extends BasePage {

	@FindBy(xpath = "//div[@class='car-price-breakdown mb-3']/div[4]/button")
	private WebElement rightGoToBookButton;

	@FindBy(css = ".col-6 > .fs-4")
	private List<WebElement> carInformation;

	@FindBy(css = ".carRentalItemDetails > .d-flex > .fs-4")
	private WebElement pickUpLocation;

	@FindBy(xpath = "//div[@class='mt-5']/h3/span[2]")
	private WebElement totalPrice;

	@FindBy(css = ".col-8 > .mt-5 > .btn")
	private WebElement belowGoToBookButton;

	@FindBy(css = ".check-option")
	private List<WebElement> insuranceCheckBoxes;

	public void clickRightGoToBookButton() {
		rightGoToBookButton.click();
	}

	public String getCarInformation(int index) {
		return carInformation.get(index).getText();
	}

	public String getPickUpLocation() {
		return pickUpLocation.getText();
	}

	public String getTotalPrice() {
		return totalPrice.getText();
	}

	public void clickBelowGoToBookButton() {
		belowGoToBookButton.click();
	}

	public void clickInsuranceCheckBoxes(int index) {
		insuranceCheckBoxes.get(index).click();
	}

}
