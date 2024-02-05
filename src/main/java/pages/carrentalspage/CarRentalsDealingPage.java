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

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[3]/h3[1]/span[2]")
	private WebElement totalPrice;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[4]/h3[1]/span[2]")
	private WebElement totalPriceUpdated;

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

	public double getTotalPrice() {
		System.out.println(totalPrice.getText());
		System.out.println(Double.parseDouble(totalPrice.getText().replace("$", "")));
		return Double.parseDouble(totalPrice.getText().replace("$", ""));
	}

	public void clickBelowGoToBookButton() {
		belowGoToBookButton.click();
	}

	public void clickInsuranceCheckBoxes(int index) {

		actions.moveToElement(insuranceCheckBoxes.get(index)).click().build().perform();
	}

	public double getTotalPriceUpdated() {
		System.out.println(totalPriceUpdated.getText());
		System.out.println(Double.parseDouble(totalPriceUpdated.getText().replace("$", "")));
		return Double.parseDouble(totalPriceUpdated.getText().replace("$", ""));
	}

}
