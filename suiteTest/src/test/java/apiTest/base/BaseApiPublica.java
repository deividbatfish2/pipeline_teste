package apiTest.base;

import java.util.Properties;

import org.junit.BeforeClass;

import com.google.gson.Gson;

import static io.restassured.RestAssured.baseURI;

public class BaseApiPublica {
	
	public static Properties prop;
	public static Gson gson;
	
	@BeforeClass
	public static void inicializaTest(){
		baseURI = "https://jsonplaceholder.typicode.com";
	}
	
}
