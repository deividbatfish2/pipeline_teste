package br.com.autoglass.pipeline_rest_assured.test.test.controleDeAcesso;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import br.com.autoglass.pipeline_rest_assured.test.test.baseTeste.Base;
import br.com.autoglass.pipeline_rest_assured.test.util.ValidaApi;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiClientePermissao extends Base{

	public String enderecoApi="/api/cliente/permissao";
	
	public String CpfCnpj = "11608032779";
	public String Permissoes = "[]";
	
	@Test
	public void verificarPermissoesDoCliente(){
		Response resposta = given().contentType("application/json").
							header("Token_Autorizacao",token)
							.queryParam("cpfCnpj", CpfCnpj)
							.get(enderecoApi);
		
		JsonPath respostaBody = getRespostaBody(resposta);
		
		ApiClientePermissao cliente = new ApiClientePermissao();
		
		ValidaApi.validar(cliente, respostaBody);
		
	}
}
