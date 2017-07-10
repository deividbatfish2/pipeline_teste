package acceptanceTest.steps;

import acceptanceTest.pageObjects.HomePage;
import acceptanceTest.testRule.TestRule;
import cucumber.api.java.pt.Dado;

public class ContextoStep {

	@Dado("^acessei o site da Autoglass$")
	public void acessei_o_site_da_Autoglass() throws Throwable {
		HomePage homePage = new HomePage();

		homePage.acessarSite();
		TestRule.getLogAtivo().addMensageInfoPrint("Acessando a HomePage");
	}

}
