package acceptanceTest.pageObjects;

import org.openqa.selenium.support.PageFactory;

import acceptanceTest.ElementMaps.MenusElementMap;
import acceptanceTest.testRule.TestRule;

public class MenusPage extends MenusElementMap{

	public MenusPage(){
		PageFactory.initElements(TestRule.getNavegador(), this);
	}
	
	public void acessarMenuClientesInserir() {
		
		menuCliente.click();
		subMenuClientesInserir.click();
	}

}
