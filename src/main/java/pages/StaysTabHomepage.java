package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class StaysTabHomepage extends BasePage {
    @FindBy(xpath = "//div[@class=\"headerList\"]/div")
    private List<WebElement> headerList;

    @FindBy(xpath = " //div[@class=\"headerSearch\"]/div")
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
    private WebElement serchButton;

    @FindBy(xpath = "//button[@class=\"btn btn-danger fs-4\"]")
    private WebElement dialogCloseButton;

    @FindBy(xpath = "//div[@class=\"modal-dialog\"]\n")
    private WebElement dialogElement;



    public void selectTheOperationPage(int pageNumber){
        if (pageNumber == 1){
            headerList.get(0).click();
        } else if (pageNumber == 2) {
            headerList.get(1).click();
        }else if (pageNumber == 3){
            headerList.get(2).click();
        }else {
            System.out.println("We do not have such a page,man!");
        }
    }

    public void sendKeysToDestination(String city){
            searchBox.sendKeys(city);
    }

    public void clickDatePickerAndSelect(int number){
        datePickerButtonAndResidentsButton.get(0).click();
        for (int i = 0; i < number; i++) {
            datePickerNextButton.click();
        }
        actions.moveToElement(startDayOfBooking).click();
        actions.moveToElement(endDayOfBooking).click();
    }

    public void increaseAdultCount(){
        datePickerButtonAndResidentsButton.get(1).click();
        residentsOptionsOfIncreaseSelectors.get(0).click();
    }
    public void decraseAdultCount(){
        datePickerButtonAndResidentsButton.get(1).click();
        residentsOptionsOfDecraseSelectors.get(0).click();
    }

    public void increaseChildrenCount(){
        datePickerButtonAndResidentsButton.get(1).click();
        residentsOptionsOfIncreaseSelectors.get(1).click();
    }
    public void decraseChildrenCount(){
        datePickerButtonAndResidentsButton.get(1).click();
        residentsOptionsOfDecraseSelectors.get(1).click();
    }

    public void increaseRoomtCount(){
        datePickerButtonAndResidentsButton.get(1).click();
        residentsOptionsOfIncreaseSelectors.get(2).click();
    }
    public void decraseRoomCount(){
        datePickerButtonAndResidentsButton.get(1).click();
        residentsOptionsOfDecraseSelectors.get(2).click();
    }
    public void clickOnSearchButton(){
        serchButton.click();
    }
    public void closeTheDialog(){
        dialogCloseButton.click();
    }

    public boolean isDisplayedTheDialog(){
        if (dialogElement.isDisplayed()){
            return true;
        }
        return false;
    }
}
