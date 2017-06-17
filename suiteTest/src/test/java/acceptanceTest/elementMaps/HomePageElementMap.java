package acceptanceTest.elementMaps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElementMap {

	@FindBy(css = "[href='https://www.autoglass.com.br/consumidor/']")
	protected WebElement souConsumidor;
	
	@FindBy(css = "[href='https://www.autoglass.com.br/trabalhe-conosco/']")
	protected WebElement trabalheNaAutoglass;
}
