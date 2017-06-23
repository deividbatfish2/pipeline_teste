package acceptanceTest.testRule;

import java.io.File;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.Log;
import util.Manipulador;
import util.selenium.webdriver.manager.DriverManager;
import util.selenium.webdriver.manager.DriverManagerFactory;
import util.selenium.webdriver.manager.DriverType;

public class TestRule {

	private DriverManager driverManager;
	private static WebDriverWait aguarde;
	private static EventFiringWebDriver navegador;

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReporter;
	private static ExtentTest feature;

	@Before
	public void beforeCenario(Scenario cenario) {

		inicializaLogFile(cenario);

		inicializaNavegador();

	}

	private void inicializaNavegador() {

		String navegadorSelecionado;

		try {
			navegadorSelecionado = Manipulador.getProp().getProperty("browser").toString();
		} catch (Exception e) {
			navegadorSelecionado = "";
		}

		switch (navegadorSelecionado) {
		case "Firefox":
			driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
			navegador = driverManager.getNavegador();
			navegador.manage().window().maximize();
			break;

		case "Chrome":
			driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
			navegador = driverManager.getNavegador();
			navegador.manage().window().maximize();
			break;
		case "Opera":
			driverManager = DriverManagerFactory.getManager(DriverType.OPERA);
			navegador = driverManager.getNavegador();
			navegador.manage().window().maximize();
			break;
		case "Chrome_HeadLess":
			driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
			navegador = driverManager.getNavegador();
			break;
		default:
			driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
			navegador = driverManager.getNavegador();
			navegador.manage().window().maximize();
			break;
		}
		aguarde = new WebDriverWait(navegador, 10);
	}

	private void inicializaLogFile(Scenario cenario) {
		if (extentReporter == null) {
			extentReporter = new ExtentReports();
			File reports = new File("target/reports");
			if (!reports.exists()) {
				reports.mkdirs();
			}
			htmlReporter = new ExtentHtmlReporter("target/reports/htmlReports.htm");
			extentReporter.attachReporter(htmlReporter);
		}

		feature = extentReporter.createTest(cenario.getId());
	}

	@After
	public void afterCenario(Scenario cenario) {
		if (cenario.isFailed()) {
			new Log("Cenário " + cenario.getName() + " falhou miseravelmente").tipoErro().comPrintScreen();
		} else {
			new Log("Cenário " + cenario.getName() + " falhou miseravelmente").tipoCenarioCorreto().comPrintScreen();
		}

		extentReporter.flush();

		if (navegador != null) {
			navegador.quit();
		}

	}

	public static WebDriverWait getAguarde() {
		return aguarde;
	}

	public static EventFiringWebDriver getNavegador() {
		return navegador;
	}

	public static ExtentTest getExtendTest() {
		return feature;
	}

}
