package acceptanceTest.testRule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestRule {

	private static WebDriver navegador;
	
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReporter;
	private static ExtentTest feature;
	
	@Before
	public void beforeCenario(Scenario cenario){
		
		if(extentReporter == null){
			extentReporter = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter("src/test/resources/reports/htmlReports.html");
			extentReporter.attachReporter(htmlReporter);
		}
		
		feature = extentReporter.createTest(cenario.getId());
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
		System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver");
		
		navegador = new ChromeDriver();
		//navegador = new FirefoxDriver();
		
		navegador.manage().window().maximize();
		
	}
	
	public static WebDriver getNavegador(){
		return navegador;
	}
	
	@After
	public void afterCenario(Scenario cenario){
		feature.log(Status.PASS, "Cenário " + cenario.getName() + " executado com sucesso");
		extentReporter.flush();
		navegador.quit();
	}
	
}
