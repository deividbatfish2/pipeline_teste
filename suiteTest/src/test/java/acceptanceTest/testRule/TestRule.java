package acceptanceTest.testRule;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.Manipulador;
import util.log.LogManagerFactory;
import util.log.LogType;
import util.log.interfaces.ILogBdd;
import util.selenium.webdriver.manager.DriverManager;
import util.selenium.webdriver.manager.DriverManagerFactory;
import util.selenium.webdriver.manager.DriverType;

public class TestRule {

	private DriverManager driverManager;
	private static WebDriverWait aguarde;
	private static EventFiringWebDriver navegador;

	private static ILogBdd log = null;

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
		if (log == null) {
			log = LogManagerFactory.getLog(LogType.BDD);
		}
		log.createLog(cenario);
	}

	@After
	public void afterCenario(Scenario cenario) {

		if (cenario.isFailed()) {
			log.addMensageFailPrint("Cenário " + cenario.getName() + " falhou miseravelmente");
		} else {
			log.addMensageSuccessPrint("Cenário " + cenario.getName() + " falhou miseravelmente");
		}

		log.finishLog();

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

	public static ILogBdd getLogAtivo() {
		return log;
	}

}
