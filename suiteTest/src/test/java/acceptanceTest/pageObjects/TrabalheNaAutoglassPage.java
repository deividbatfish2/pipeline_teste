package acceptanceTest.pageObjects;

import org.openqa.selenium.support.PageFactory;

import acceptanceTest.elementMaps.TrabalheNaAutoglassElementMap;
import acceptanceTest.testRule.TestRule;

public class TrabalheNaAutoglassPage extends TrabalheNaAutoglassElementMap {

	public TrabalheNaAutoglassPage() {
		PageFactory.initElements(TestRule.getNavegador(), this);
	}

	public void clicarEmOportunidadesGerais() {
		oportunidadesGerais.click();

	}

}
