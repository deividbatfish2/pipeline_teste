package acceptanceTest.testRule;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import util.Log;
import util.selenium.WebEventListener;

public class TestRule {

	private WebDriver navegador;
	private static EventFiringWebDriver e_navegador;
	private WebEventListener eventListener;

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReporter;
	private static ExtentTest feature;

	@Before
	public void beforeCenario(Scenario cenario) {

		if (extentReporter == null) {
			extentReporter = new ExtentReports();
			File reports = new File("target/reports");
			if(!reports.exists()){
				reports.mkdirs();
			}
			htmlReporter = new ExtentHtmlReporter("target/reports/htmlReports.html");
			extentReporter.attachReporter(htmlReporter);
		}

		feature = extentReporter.createTest(cenario.getId());

		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
		System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		
		navegador = new ChromeDriver(options);
		// navegador = new FirefoxDriver();

		// Initializing EventFiringWebDriver using Firefox WebDriver instance
		e_navegador = new EventFiringWebDriver(navegador);

		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();

		e_navegador.register(eventListener);

		//e_navegador.manage().window().maximize();

	}

	@After
	public void afterCenario(Scenario cenario) {
		if (cenario.isFailed()) {
			Log.logFaill("Cenário " + cenario.getName() + " falhou miseravelmente");
		} else {
			Log.logPass("Cenário " + cenario.getName() + " foi executado com sucesso");
		}

		extentReporter.flush();

		if (navegador != null) {
			navegador.quit();
		}

	}

	public static EventFiringWebDriver getNavegador() {
		return e_navegador;
	}

	public static ExtentTest getExtendTest() {
		return feature;
	}

}
