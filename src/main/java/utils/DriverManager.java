package utils;

import config.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.HashMap;

public class DriverManager {

	private static final ThreadLocal<WebDriver> THREAD_LOCAL_DRIVER = new ThreadLocal<>();

	private DriverManager() {
		throw new UnsupportedOperationException("You cannot object of utils.DriverManager");
	}

	public static WebDriver getWebDriver() {
		return getWebDriver(System.getProperty("browser", "chrome"));
	}

	public static WebDriver getWebDriver(String browserType) {
		WebDriver driver;
		if (THREAD_LOCAL_DRIVER.get() == null) {
			switch (browserType.toLowerCase()) {
				case "firefox" -> {
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					firefoxOptions.addArguments("--width-1920");
					firefoxOptions.addArguments("--height-1080");
					driver = new FirefoxDriver(firefoxOptions);
				}
				case "edge" -> {
					EdgeOptions edgeOptions = new EdgeOptions();
					edgeOptions.addArguments("--start-maximized");
					edgeOptions.addArguments("--ignore-certificate-error");
					driver = new EdgeDriver(edgeOptions);
				}

				default -> {
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--start-maximized");
					chromeOptions.addArguments("--ignore-certificate-error");
					driver = new ChromeDriver(chromeOptions);
				}
			}
			driver.get(ConfigurationManager.getProperty("baseURL"));
			THREAD_LOCAL_DRIVER.set(driver);
		}

		return THREAD_LOCAL_DRIVER.get();
	}

	public static void closeDriver() {
		if (THREAD_LOCAL_DRIVER != null) {
			THREAD_LOCAL_DRIVER.get().quit();
			THREAD_LOCAL_DRIVER.remove();
		}
	}

}