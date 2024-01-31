package pages.stayspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class StaysTabHomepage extends BasePage {

	@FindBy(xpath = "//div[@class=\"headerList\"]/div")
	private List<WebElement> headerList;

	@FindBy(xpath = "//div[@class=\"headerSearch\"]/div")
	private WebElement searchBox;

	@FindBy(xpath = "//button[@class=\"rdrNextPrevButton rdrNextButton\"]")
	private WebElement datePickerNextButton;

	@FindBy(xpath = "//span[@class=\"rdrDayNumber\"]/span[text()=\"8\"]")
	private WebElement startDayOfBooking;

	@FindBy(xpath = "//span[@class=\"rdrDayNumber\"]/span[text()=\"10\"]")
	private WebElement endDayOfBooking;

	@FindBy(xpath = "//span[@class='headerSearchText']")
	private List<WebElement> datePickerButtonAndResidentsButton;

	@FindBy(xpath = "//button[@class=\"optionCounterButton\"][1]")
	private List<WebElement> residentsOptionsOfDecraseSelectors;

	@FindBy(xpath = "//button[@class=\"optionCounterButton\"][2]")
	private List<WebElement> residentsOptionsOfIncreaseSelectors;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement searchButton;

	@FindBy(xpath = "//button[@class=\"btn btn-danger fs-4\"]")
	private WebElement dialogCloseButton;

	@FindBy(xpath = "//div[@class=\"modal-dialog\"]")
	private WebElement dialogElement;

	@FindBy(xpath = "//input[@placeholder='Where are you going?']")
	private WebElement cityFieldButton;

	public void selectTheOperationPage(int pageNumber) {
		if (pageNumber == 1) {
			headerList.get(0).click();
		}
		else if (pageNumber == 2) {
			headerList.get(1).click();
		}
		else if (pageNumber == 3) {
			headerList.get(2).click();
		}
		else {
			System.out.println("We do not have such a page,man!");
		}
	}

	public void sendKeysToDestination(String city) {
		cityFieldButton.sendKeys(city);
	}

	public void clickDatePickerAndSelect(int month) {
		datePickerButtonAndResidentsButton.get(0).click();
		for (int i = 0; i < month; i++) {
			datePickerNextButton.click();
		}
		actions.moveToElement(startDayOfBooking).click();
		actions.moveToElement(endDayOfBooking).click();
	}

	public void increaseAdultCount() {
		datePickerButtonAndResidentsButton.get(1).click();
		residentsOptionsOfIncreaseSelectors.get(0).click();
	}

	public void decreaseAdultCount() {
		datePickerButtonAndResidentsButton.get(1).click();
		residentsOptionsOfDecraseSelectors.get(0).click();
	}

	public void increaseChildrenCount() {
		datePickerButtonAndResidentsButton.get(1).click();
		residentsOptionsOfIncreaseSelectors.get(1).click();
	}

	public void decreaseChildrenCount() {
		datePickerButtonAndResidentsButton.get(1).click();
		residentsOptionsOfDecraseSelectors.get(1).click();
	}

	public void increaseRoomCount() {
		datePickerButtonAndResidentsButton.get(1).click();
		residentsOptionsOfIncreaseSelectors.get(2).click();
	}

	public void decreaseRoomCount() {
		datePickerButtonAndResidentsButton.get(1).click();
		residentsOptionsOfDecraseSelectors.get(2).click();
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void closeTheDialog() {
		dialogCloseButton.click();
	}

	public boolean isTheDialogueDisplayed() {
		return !dialogElement.equals(null);
	}

	public void clickOnCityField() {
		cityFieldButton.click();
	}

}
