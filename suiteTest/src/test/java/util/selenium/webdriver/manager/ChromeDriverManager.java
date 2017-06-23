package util.selenium.webdriver.manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import util.selenium.WebEventListener;

public class ChromeDriverManager extends DriverManager {

	@Override
	protected void iniciarServico() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
	}

	@Override
	protected void criarNavegador() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);

		// Initializing EventFiringWebDriver using Chrome WebDriver
		// instance
		navegador = new EventFiringWebDriver(navegador);

		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();

		navegador.register(eventListener);

	}

}
