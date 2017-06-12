package acceptanceTest.pageObjects;

import org.openqa.selenium.support.PageFactory;

import acceptanceTest.elementMaps.ConsumidorElementMap;
import acceptanceTest.testRule.TestRule;

public class ConsumidorPage extends ConsumidorElementMap{

	public ConsumidorPage(){
		PageFactory.initElements(TestRule.getNavegador(), this);
	}

	public void clicarOpcaoFarois() {
		farois.click();

	}
	
}
