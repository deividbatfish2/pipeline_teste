package acceptanceTest.steps;

import static org.junit.Assert.assertTrue;

import acceptanceTest.pageObjects.ConsumidorPage;
import acceptanceTest.pageObjects.FaroisPage;
import acceptanceTest.pageObjects.HomePage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class BuscaFarolStep {

	@Dado("^acessei o site da Autoglass$")
	public void acessei_o_site_da_Autoglass() throws Throwable {
		HomePage homePage = new HomePage();
		
		homePage.acessarSite();
	}

	@Dado("^clique na opção Sou Consumidor$")
	public void clique_na_opção_Sou_Consumidor() throws Throwable {
	    HomePage homePage = new HomePage();
	    
	    homePage.clicarOpcaoSouConsumidor();
	}

	@Quando("^clicar na opção Fárois$")
	public void clicar_na_opção_Fárois() throws Throwable {
	    ConsumidorPage consumidorPage = new ConsumidorPage();
	    
	    consumidorPage.clicarOpcaoFarois();
	}

	@Então("^o sie deve exibir inforaçãoes relacionadas a farois$")
	public void o_sie_deve_exibir_inforaçãoes_relacionadas_a_farois() throws Throwable {
	    FaroisPage faroisPage = new FaroisPage();
	    
	    assertTrue(faroisPage.verificaPaginaFarois());
	}
	
}
