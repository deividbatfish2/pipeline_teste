package acceptanceTest.pageObjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptanceTest.ElementMaps.ClienteElementMap;
import acceptanceTest.testRule.TestRule;

public class ClientePage extends ClienteElementMap{

	public ClientePage(){
		PageFactory.initElements(TestRule.getNavegador(), this);
	}
	
	public void informarDadosIdentificacaoPF() {
		fisica.click();
		cpf_cnpj.sendKeys("837.867.723-30");
		nome_razaosocial.sendKeys("Teste Razão Social");
		email.sendKeys("teste@email.com");
		data_nascimento.sendKeys("10/10/2000");
		
		Select cmbSexo = new Select(sexo);
		cmbSexo.deselectByVisibleText("Masculino");
		
		Select cmbEstadoCivil = new Select(estado_civil);
		cmbEstadoCivil.selectByVisibleText("Solteiro");
		
	}

	public void clicarBotaoAvancar() {
		avancar.click();
		
	}

	public void informarEnderecos() {
		//Endereço Principal
		endp_cep.sendKeys("99130-529");
		endp_endereco.sendKeys("Rua x");
		endp_numero.sendKeys("123");
		endp_complemento.sendKeys("Ranto faz");
		endp_cidade.sendKeys("Porto Alegre");
		
		Select cmbEstado = new Select(endp_estado);
		cmbEstado.selectByVisibleText("RS");
		
		endp_telefone.sendKeys("55 3366-9999");
		endp_celular.sendKeys("55 99256-3594");
		
		//Endereço 	de Cobrança
		endc_cep.sendKeys("99130-529");;
		endc_endereco.sendKeys("Rua x");;
		endc_numero.sendKeys("123");
		endc_complemento.sendKeys("Ranto faz");
		endc_cidade.sendKeys("Porto Alegre");
		
		cmbEstado = new Select(endc_estado);
		cmbEstado.selectByVisibleText("RS");
		
		endc_telefone.sendKeys("55 3366-9999");
		endc_celular.sendKeys("55 99256-3594");
		
	}

	public void clicarBoatoSalvar() {
		salvar.click();
		
	}

	public void verificarMensagemSucesso() {
		// TODO Auto-generated method stub
		
	}
	
	

}
