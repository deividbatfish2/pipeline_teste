package acceptanceTest.testRule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestRule {

	private static WebDriver navegador;
	
	@Before
	public void beforeCenario(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
		System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver");
		
		navegador = new ChromeDriver();
		
		navegador.manage().window().maximize();
		
	}
	
	public static WebDriver getNavegador(){
		return navegador;
	}
	
	@After
	public void afterCenario(){
		navegador.quit();
	}
	
}
