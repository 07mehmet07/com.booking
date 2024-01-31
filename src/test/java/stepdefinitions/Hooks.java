package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.DriverManager;

public class Hooks {

	public static final Logger LOGGER = LogManager.getLogger(Hooks.class);

	@Before
	public void setUpTestEnvironment() {
		DriverManager.getWebDriver();
		LOGGER.info("TEST STARTED!!");
	}

	@After
	public void tearDownTestEnvironment() {
		DriverManager.closeDriver();
		LOGGER.info("TEST FINISHED!!");
	}


}
