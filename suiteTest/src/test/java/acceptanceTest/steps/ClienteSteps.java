package acceptanceTest.steps;

import acceptanceTest.pageObjects.ClientePage;
import acceptanceTest.pageObjects.LoginPage;
import acceptanceTest.pageObjects.MenusPage;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class ClienteSteps {

	@Dado("^que efetuei login no sistema$")
	public void que_efetuei_login_no_sistema() throws Throwable {
	    LoginPage loginPage = new LoginPage();
	    
	    loginPage.efetuarLogin();
	}

	@Dado("^acessei o menu Cliente >> Inserir$")
	public void acessei_o_menu_Cliente_Inserir() throws Throwable {
	    MenusPage menuPage = new MenusPage();
	    
	    menuPage.acessarMenuClientesInserir();
	}

	@Quando("^na tela Dados de identificação informo os dados da pessoa física$")
	public void na_tela_Dados_de_identificação_informo_os_dados_da_pessoa_física() throws Throwable {
	    ClientePage clientePage = new ClientePage();
	    
	    clientePage.informarDadosIdentificacaoPF();	
	}

	@Quando("^na tela Dados de Identificação clico em Avançar$")
	public void na_tela_Dados_de_Identificação_clico_em_Avançar() throws Throwable {
		ClientePage clientePage = new ClientePage();
		
		clientePage.clicarBotaoAvancar();
	}

	@Quando("^na tela Endereços informo os endereços$")
	public void na_tela_Endereços_informo_os_endereços() throws Throwable {
		ClientePage clientePage = new ClientePage();
		
		clientePage.informarEnderecos();
	}

	@Quando("^na tela Endereços Clico em Salvar$")
	public void na_tela_Endereços_Clico_em_Salvar() throws Throwable {
		ClientePage clientePage = new ClientePage();
		
		clientePage.clicarBoatoSalvar();
	}

	@Então("^na tela Endereços será exibida a mensagem de sucesso$")
	public void na_tela_Endereços_será_exibida_a_mensagem_de_sucesso() throws Throwable {
	    ClientePage clientePage = new ClientePage();
	    
	    clientePage.verificarMensagemSucesso();
	}

	@Então("^eferuarei logout do sistema$")
	public void eferuarei_logout_do_sistema() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	
}
