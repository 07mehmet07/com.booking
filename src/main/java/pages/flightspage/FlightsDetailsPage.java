package pages.flightspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.Arrays;
import java.util.List;

public class FlightsDetailsPage extends BasePage {

	@FindBy(css = ".w-100 > .form-control ")
	WebElement contactEmailArea;

	@FindBy(css = ".w-75> .form-control")
	WebElement phoneNumberArea;

	@FindBy(css = ".w-50 > input")
	List<WebElement> travelerInformationInput;

	@FindBy(css = ".form-select.fs-4.p-3.border-danger")
	List<WebElement> selectsTabs;

	@FindBy(xpath = "//div/select[@class='form-select fs-4 p-3']")
	List<WebElement> birthDateOfPassengers;

	@FindBy(css = "button.btn.btn-blue")
	WebElement selectExtrasButton;

	public void setContactEmailArea(String name) {
		contactEmailArea.sendKeys(name);
	}

	public void setPhoneNumberArea(String phoneNumber) {
		phoneNumberArea.sendKeys(phoneNumber);
	}

	public void setFirstNameInputAreas(String firstName, String lastName, int numberOfPassenger) {
		travelerInformationInput.get(2 * numberOfPassenger - 2).sendKeys(firstName);
		travelerInformationInput.get(2 * numberOfPassenger - 1).sendKeys(lastName);
	}

	public void selectGender(String gender, int numberOfPassenger) {
		Select select = new Select(selectsTabs.get(numberOfPassenger - 1));
		select.selectByVisibleText(gender);
	}

	public void selectBirthDate(String birthdate, int numOfPassenger) {
		List<String> list = Arrays.asList(birthdate.split("\\."));

		Select select = new Select(birthDateOfPassengers.get(3 * numOfPassenger - 3));
		select.selectByVisibleText(list.get(0));

		select = new Select(birthDateOfPassengers.get(3 * numOfPassenger - 2));
		select.selectByVisibleText(list.get(1));

		select = new Select(birthDateOfPassengers.get(3 * numOfPassenger - 1));
		select.selectByVisibleText(list.get(2));
	}

	public void clickOnSelectExtrasButton() {
		selectExtrasButton.click();
	}

}
