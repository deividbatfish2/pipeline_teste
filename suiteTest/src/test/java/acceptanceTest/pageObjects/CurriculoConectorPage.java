package acceptanceTest.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import acceptanceTest.elementMaps.CurriculoConectElementMap;
import acceptanceTest.testRule.TestRule;

public class CurriculoConectorPage extends CurriculoConectElementMap {

	public CurriculoConectorPage() {
		PageFactory.initElements(TestRule.getNavegador(), this);
	}

	public void clicarEmVagasDisponiveis() {

		List<String> abas = new ArrayList<String>(TestRule.getNavegador().getWindowHandles());
		TestRule.getNavegador().switchTo().window(abas.get(1));

		TestRule.getAguarde().until(ExpectedConditions.visibilityOf(vagasDisponiveis));
		vagasDisponiveis.click();

	}

}
