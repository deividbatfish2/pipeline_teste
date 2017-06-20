package acceptanceTest.steps;

import acceptanceTest.pageObjects.HomePage;
import cucumber.api.java.pt.Dado;
import util.Log;

public class ContextoStep {

	@Dado("^acessei o site da Autoglass$")
	public void acessei_o_site_da_Autoglass() throws Throwable {
		HomePage homePage = new HomePage();

		homePage.acessarSite();
		new Log("Acessando a HomePage").tipoInformacao().comPrintScreen();
	}

}
