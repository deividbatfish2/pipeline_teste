package acceptanceTest.pageObjects;

import org.openqa.selenium.support.PageFactory;

import acceptanceTest.elementMaps.HomePageElementMap;
import acceptanceTest.testRule.TestRule;
import util.Manipulador;

public class HomePage extends HomePageElementMap {

	public HomePage() {
		PageFactory.initElements(TestRule.getNavegador(), this);
	}

	public void acessarSite() {

		TestRule.getNavegador().navigate().to(Manipulador.getProp().getProperty("urlBase").toString());

	}

	public void clicarOpcaoSouConsumidor() {
		souConsumidor.click();

	}

	public void clicarOpcaoTrabalheNaAutoglass() {
		trabalheNaAutoglass.click();

	}

}
