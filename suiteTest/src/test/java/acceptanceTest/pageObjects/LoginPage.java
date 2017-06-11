package acceptanceTest.pageObjects;

import org.openqa.selenium.support.PageFactory;

import acceptanceTest.ElementMaps.LoginElementMap;
import acceptanceTest.testRule.TestRule;

public class LoginPage extends LoginElementMap{

	public LoginPage(){
		PageFactory.initElements(TestRule.getNavegador(), this);
	}
	
	public void efetuarLogin() {
		login.sendKeys("john");
		senha.sendKeys("jhon");
		btnLogin.click();
	}
	
	

}
