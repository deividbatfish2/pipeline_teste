package apiTest.test.user;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import apiTest.base.BaseApiPublica;


public class UserApiTest extends BaseApiPublica{

	@Test
	public void getUsuarioById(){
		given().contentType("application/json").get("/posts/1").then().assertThat().body("userId", equalTo(1));
	}
	
}
