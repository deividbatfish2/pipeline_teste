package acceptanceTest.pageObjects;

import org.openqa.selenium.support.PageFactory;

import acceptanceTest.elementMaps.HomePageElementMap;
import acceptanceTest.testRule.TestRule;

public class HomePage extends HomePageElementMap{

	public HomePage(){
		PageFactory.initElements(TestRule.getNavegador(), this);
	}
	
	public void acessarSite() {
		
		TestRule.getNavegador().navigate().to("https://www.autoglass.com.br");
		
	}

	public void clicarOpcaoSouConsumidor() {
		souConsumidor.click();
		
	}

}
