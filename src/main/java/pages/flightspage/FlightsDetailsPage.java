package pages.flightspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class FlightsDetailsPage extends BasePage {

	@FindBy(css = ".w-100 > .form-control ")
	WebElement contactEmailArea;

	@FindBy(css = ".w-75> .form-control")
	WebElement phoneNumberArea;

	@FindBy(css = ".w-50 > input")
	List<WebElement> travelerInformationInput;

	@FindBy(css = ".form-select.fs-4.p-3.border-danger")
	WebElement selectsTabs;

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

	public void setFirstNameInputAreas(int i, String firstName) {
		travelerInformationInput.get(i - 1).sendKeys(firstName);
	}

	public void setLastNameInputAreas(int i, String lastName) {
		travelerInformationInput.get(i - 1).sendKeys(lastName);
	}

	public void selectMaleAsGender() {
		Select select = new Select(selectsTabs);
		select.selectByIndex(1);

	}

	public void selectFemaleAsGender() {
		Select select = new Select(selectsTabs);
		select.selectByIndex(2);

	}

	public void selectBirthDate(int year, int month, int day, String year1, String month1, String day1) {
		Select select = new Select(birthDateOfPassengers.get(year - 1));
		select.selectByValue(year1);
		Select select2 = new Select(birthDateOfPassengers.get(month - 1));
		select2.selectByValue(month1);
		Select select3 = new Select(birthDateOfPassengers.get(day - 1));
		select3.selectByValue(day1);
	}

	public void clickOnSelectExtrasButton() {
		selectExtrasButton.click();
	}

}
