package br.com.autoglass.pipeline_rest_assured.test.test.controleDeAcesso;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import br.com.autoglass.pipeline_rest_assured.test.test.baseTeste.Base;
import br.com.autoglass.pipeline_rest_assured.test.util.ValidaApi;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiDispositivoMovel extends Base{

	public String enderecoApi="/api/dispositivomovel";
	
	public String IMEI = "0700205303001c4ab9aa000550520008";
	public String CodigoPatrimonio = "056948";
	public String Empresa = "PG01";
	public String CodigoEmpresa = "44";
	
	@Test
	public void verificarPermissoesDoCliente(){
		
		
		Response resposta = given().contentType("application/json").
							header("Token_Autorizacao",token)
							.queryParam("IMEI", IMEI)
							.get(enderecoApi);
		
		JsonPath respostaBody = getRespostaBody(resposta);
		
		ApiDispositivoMovel dispositivo = new ApiDispositivoMovel();
		
		ValidaApi.validar(dispositivo, respostaBody);
	}
	
}
