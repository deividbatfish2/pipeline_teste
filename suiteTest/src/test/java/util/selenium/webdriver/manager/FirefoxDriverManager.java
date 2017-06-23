package util.selenium.webdriver.manager;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import util.selenium.WebEventListener;

public class FirefoxDriverManager extends DriverManager {

	@Override
	protected void iniciarServico() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver");
	}

	@Override
	protected void criarNavegador() {
		driver = new FirefoxDriver();

		// Initializing EventFiringWebDriver using Chrome WebDriver
		// instance
		navegador = new EventFiringWebDriver(navegador);

		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();

		navegador.register(eventListener);

	}

}
