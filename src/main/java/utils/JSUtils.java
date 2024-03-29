package utils;

import org.openqa.selenium.JavascriptExecutor;

public class JSUtils {

	private static JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getWebDriver();

	/**
	 * Executes the provided JavaScript code.
	 * @param javascriptCode the JavaScript code to execute
	 */
	public static void javascriptExecutor(String javascriptCode) {
		javascriptExecutor.executeScript(javascriptCode);
	}

	/**
	 * Clicks on an element using its ID.
	 * @param elementId the ID of the element to click
	 */
	public static void clickOnElementByItsId(String elementId) {
		javascriptExecutor.executeScript("document.querySelector('#" + elementId + "').click()");
	}

	public static void setElementValueByClassName(String className, String value) {
		javascriptExecutor.executeScript("document.querySelector('." + className + "').value='" + value + "'");
	}

}
