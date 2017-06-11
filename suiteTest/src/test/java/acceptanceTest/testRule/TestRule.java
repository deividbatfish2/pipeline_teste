package acceptanceTest.testRule;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.Before;

public class TestRule {

	private static WebDriver navegador;
	
	@Before
	public void beforeCenario(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=/home/deivid/.config/chromium/Default");
		
		navegador = new ChromeDriver(options);
		
		navegador.manage().window().maximize();
		
		try {
			navegador.navigate().to(new File("src/test/resources/sistemaFake/index.html").toURI().toURL());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static WebDriver getNavegador(){
		return navegador;
	}
	
}
