package br.com.autoglass.apiTest.pipeline_rest_assured.test.test.baseTeste;

import static br.com.autoglass.apiTest.pipeline_rest_assured.test.util.Manipulador.getProp;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.google.gson.Gson;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Base {

	public static String token;
	public static Properties prop;
	public static Gson gson;

	protected static String enderecoAutenticacao = "/api/autenticacao/autenticar";
	private static String login = "\"qualidade.ti\"";
	private static String senha = "\"megazord\"";
	private static String modelSchemaAutenticar = "{"
										+ "\"Login\":"+login +","
										+	"\"Senha\":"+senha
										+ "}";
	
	public static void inicializaCaminhoBaseApi(){
		baseURI = "https://caracas.autoglass.com.br/seguranca";
	}
	
	public static String getToken() {
		return token;
	}



	public static void setToken(String token) {
		Base.token = token;
	}
	
	@BeforeClass
	public static void relizaLoginERecuperaToken(){
		
		inicializaCaminhoBaseApi();
		inicializaArquivoProperties();
		
		Response resposta =  given().contentType("application/json")
							.body(modelSchemaAutenticar)
							.when().post(enderecoAutenticacao);
		
		JsonPath respostaBody = getRespostaBody(resposta);

		setToken((String) respostaBody.get("Token"));
		
		gson = new Gson();
	}
	
	private static void inicializaArquivoProperties() {
		try {
			prop = getProp();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JsonPath getRespostaBody(Response resposta){
		switch (resposta.getStatusCode()) {
		case 200:
				return resposta.getBody().jsonPath();
		case 404: 
			throw new AssertionError("Erro 404: Api n�o encontrada no endere�o Informado!");
				
		case 400:
			throw new AssertionError("Erro 400: Requisi��o inv�lida. Maiores detalhes na mensagem de retorno: "+
					resposta.getBody().jsonPath().get().toString());
		case 401: 
			throw new AssertionError("Erro 401: Usu�rio n�o esta autenticado");
			
		case 403: 
			throw new AssertionError("Erro 403: Usu�rio n�o tem permiss�o para executar esta opera��o");
			
		case 500: 
			throw new AssertionError("Erro 500: Erro interno no servidor");
			
		default:
			return null;
		}
	}
	
	@AfterClass
	public static void encerraLogin(){
		String modelSchemaDesconectar="{"
				+"\"Token\":"+token
				+"}";
		
		Response resposta =  given().contentType("application/json")
				.body(modelSchemaDesconectar)
				.when().post(enderecoAutenticacao);
		
		JsonPath respostaBody = getRespostaBody(resposta);
		if(respostaBody != null){
			System.out.println("Teste finalizado com sucesso");
			token = null;
		}
		
	}
	
	public void relizaLoginERecuperaToken(String usuariosemPermissao, String senhaUsuarioSemPermissao) {
		
		inicializaCaminhoBaseApi();
		
		inicializaModelSchemaAutenticar(usuariosemPermissao, senhaUsuarioSemPermissao);
		
		Response resposta =  given().contentType("application/json")
							.body(modelSchemaAutenticar)
							.when().post(enderecoAutenticacao);
		
		JsonPath respostaBody = getRespostaBody(resposta);

		setToken((String) respostaBody.get("Token"));
		
	}

	private void inicializaModelSchemaAutenticar(String usuariosemPermissao, String senhaUsuarioSemPermissao) {
		modelSchemaAutenticar = "{"
										+ "\"Login\":"+usuariosemPermissao +","
										+	"\"Senha\":"+senhaUsuarioSemPermissao
										+ "}";
		
	}
	
	@Before
	public void verificaExistenciaDeToken(){
		if(token == null){
			relizaLoginERecuperaToken();
		}
	}
}