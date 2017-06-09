package br.com.autoglass.apiTest.pipeline_rest_assured.test.test.controleDeAcesso;

import static io.restassured.RestAssured.given;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.autoglass.apiTest.pipeline_rest_assured.test.suporte.dispositivoMovel.DispositivoMovel;
import br.com.autoglass.apiTest.pipeline_rest_assured.test.suporte.usuario.Usuario;
import br.com.autoglass.apiTest.pipeline_rest_assured.test.test.baseTeste.Base;
import br.com.autoglass.apiTest.pipeline_rest_assured.test.util.ValidaApi;
import io.restassured.response.Response;

public class ApiUsuariosMovel extends Base{

	public String enderecoApi = "/api/usuarios/movel";
	
	List<Usuario> listaUsuarios;
	
	@Test
	public void verificaUsuariosRetornadosPorAparelho(){
		
		DispositivoMovel dispositivo = new DispositivoMovel().getDisposivoMovelBD("CODDISPOSITIVO = 453");
		
		// Gerar Lista de Usu�rios atrav�s de consulta no banco.
		listaUsuarios = new Usuario().getListaUsuarioDispositivoMovel(dispositivo.getCODEMPRESA());
		
		Response resposta = given().contentType("application/json").
				header("Token_Autorizacao",token)
				.queryParam("IMEI", dispositivo.getIMEI())
				.get(enderecoApi);

		// Converter JsonPath em um arrayList
		
		java.lang.reflect.Type collectionType = new TypeToken<Collection<Usuario>>(){}.getType();
		
		List<Usuario> listaUsuarioRetornado = gson.fromJson(resposta.asString(), collectionType);
		
		ValidaApi.validar(listaUsuarios, listaUsuarioRetornado);

	}

	
}
