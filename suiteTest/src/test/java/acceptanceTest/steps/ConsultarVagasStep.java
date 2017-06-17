package acceptanceTest.steps;

import static org.junit.Assert.assertTrue;

import acceptanceTest.pageObjects.CurriculoConectorPage;
import acceptanceTest.pageObjects.HomePage;
import acceptanceTest.pageObjects.TrabalheNaAutoglassPage;
import acceptanceTest.pageObjects.VagasDisponiveisPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import util.Log;

public class ConsultarVagasStep {

	@Dado("^que eu clique em Trabalhe na Autoglass$")
	public void que_eu_clique_em_Trabalhe_na_Autoglass() throws Throwable {
		HomePage homePage = new HomePage();

		homePage.clicarOpcaoTrabalheNaAutoglass();
		Log.logsEPrints("Acessando a pagina Trabalhe Conosco");
	}

	@Dado("^clique em oportunidades gerais$")
	public void clique_em_oportunidades_gerais() throws Throwable {
		TrabalheNaAutoglassPage trabalheNaAutoglassPage = new TrabalheNaAutoglassPage();

		trabalheNaAutoglassPage.clicarEmOportunidadesGerais();
		Log.logsEPrints("Acessando a pagina Oportunidades Gerais");
	}

	@Dado("^clique em vagas disponíveis$")
	public void clique_em_vagas_disponíveis() throws Throwable {
		CurriculoConectorPage curriculoConectorPage = new CurriculoConectorPage();

		curriculoConectorPage.clicarEmVagasDisponiveis();
		Log.logsEPrints("Acessando a pagina Vagas Disponíveis");
	}

	@Então("^o sistema deve me retonar links com as vagas disponíveis para o candidato$")
	public void o_sistema_deve_me_retonar_links_com_as_vagas_disponiveis_para_o_candidato() throws Throwable {
		VagasDisponiveisPage vagasDisponiveisPage = new VagasDisponiveisPage();

		assertTrue(vagasDisponiveisPage.verificarVagasDisponiveis());
	}

}
