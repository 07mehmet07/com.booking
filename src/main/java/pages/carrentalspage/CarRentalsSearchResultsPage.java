package pages.carrentalspage;

import pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

import java.util.List;

public class CarRentalsSearchResultsPage extends BasePage {

	@FindBy(xpath = "(//div[@class='listResult']/div/button/div)")
	private List<WebElement> carSizeList;

	@FindBy(xpath = "//div[@stye='[object Object]']")
	private WebElement priceOfCar;

	@FindBy(xpath = "//span[@class='fs-4 fw-bold']")
	private List<WebElement> carPickupLocationList;

	@FindBy(xpath = "//button[@class='mt-2 btn btn-blue w-100']")
	private List<WebElement> viewDealButtonList;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement pickupLocationField;

	@FindBy(xpath = "//div[@class='listSearch-car-rental']/div[6]/div/div/input")
	private List<WebElement> priceRangeList;

	@FindBy(xpath = "//div[@class='listSearch-car-rental']/div[7]/div/div/input")
	private List<WebElement> carSpecsList;

	@FindBy(xpath = "//div[@class='listSearch-car-rental']/div[8]/div/div/input")
	private List<WebElement> transmissionList;

	@FindBy(xpath = "//div[@class='listSearch-car-rental']/div[9]/div/div/input")
	private List<WebElement> carCategoryList;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement searchButton;

	@FindBy(xpath = "//button[contains(text(),'Price Lowest')]")
	private WebElement sortByLowestPrice;

	@FindBy(xpath = "//button[contains(text(),'Price Highest')]")
	private WebElement sortByHighestPrice;

	public void chooseCarSize(String size) {
		size = size.toLowerCase();
		switch (size) {
			case "small" -> carSizeList.get(0).click();
			case "medium" -> carSizeList.get(1).click();
			case "minivan" -> carSizeList.get(2).click();
			case "suv" -> carSizeList.get(3).click();
			case "large" -> carSizeList.get(4).click();
		}
	}

	public String getCarPickupLocation(int index) {
		return carPickupLocationList.get(index).getText();
	}

	public void clickOnViewDealButton(int index) {
		viewDealButtonList.get(index).click();
	}

	public void selectPriceRange(int index) {
		priceRangeList.get(index).click();
	}

	public void selectCarSpecs(int index) {
		carSpecsList.get(index).click();
	}

	public void selectTransmission(int index) {
		transmissionList.get(index).click();
	}

	public void selectCarCategory(int index) {
		carCategoryList.get(index).click();
	}

	public void clickOnSearchButton() {
		BrowserUtils.scrollDownWithPageDownButton(1);
		searchButton.click();
		BrowserUtils.scrollUpWithPageUpButton(1);
	}

	public void clickOnSortByLowestPriceButton() {
		sortByLowestPrice.click();
	}

	public void clickOnSortByHighestPriceButton() {
		sortByHighestPrice.click();
	}

	public void enterPickupLocation(String location) {
		pickupLocationField.sendKeys(location);
	}

	public boolean isPickupLocationCorrect(String location){
		return pickupLocationField.getAttribute("value").equalsIgnoreCase(location);

	}

	public double getPriceOfCar(){
		System.out.println(Double.parseDouble(priceOfCar.getText().replace("$", "")));
		return Double.parseDouble(priceOfCar.getText().replace("$",""));
	}

	public List<WebElement> getCarPickupLocationList() {
		return carPickupLocationList;
	}
}
