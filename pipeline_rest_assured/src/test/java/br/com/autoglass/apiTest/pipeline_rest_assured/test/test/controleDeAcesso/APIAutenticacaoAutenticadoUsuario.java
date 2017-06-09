package br.com.autoglass.apiTest.pipeline_rest_assured.test.test.controleDeAcesso;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.autoglass.apiTest.pipeline_rest_assured.test.suporte.usuario.Usuario;
import br.com.autoglass.apiTest.pipeline_rest_assured.test.test.baseTeste.Base;
import br.com.autoglass.apiTest.pipeline_rest_assured.test.util.ValidaApi;
import io.restassured.response.Response;

public class APIAutenticacaoAutenticadoUsuario extends Base{
	
	public String enderecoApi="/api/Autenticacao/Autenticado/Usuario";
	public String Ativo = "true";
	
	public String usuariosemPermissao = "";
	public String senhaUsuarioSemPermissao = "";
	
	@Test
	public void verificarInformacoesDoUsuarioAutenticado(){
		
		Response resposta = given().contentType("application/json").
							header("Token_Autorizacao",token)
							.get(enderecoApi);
		
		Usuario usuarioRetornado = gson.fromJson(resposta.asString(),Usuario.class);
		
		Usuario usuario = new Usuario().getUsuarioBD("CODUSUARIO = 8229");
		
		ValidaApi.validar(usuario, usuarioRetornado);
		
	}
	
	@Test
	public void verificarUsuarioNaoAutenticado(){
		Response resposta = given().contentType("application/json").
				header("Token_Autorizacao","TOKEN_NAO_AUTENTICADO")
				.get(enderecoApi);
		
		assertEquals(resposta.getStatusCode(), 401);
	}
	
	@Test
	public void verificarRequisicaoInvalida(){
		Response resposta = given().contentType("application/json").
				header("REQUISICAO_INVALIDA",token)
				.get(enderecoApi);
		
		assertEquals(resposta.getStatusCode(), 401);
	}
	
	@Test
	public void verificarUsuarioSemPermissaoParaExecutarOperacao(){
		encerraLogin();
		
		relizaLoginERecuperaToken(usuariosemPermissao, senhaUsuarioSemPermissao);
		
		Response resposta = given().contentType("application/json").
				header("Token_Autorizacao",token)
				.get(enderecoApi);
		
		assertEquals(resposta.getStatusCode(), 403);
	}
}
