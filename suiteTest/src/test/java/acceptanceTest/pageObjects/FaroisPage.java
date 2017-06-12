package acceptanceTest.pageObjects;

import acceptanceTest.elementMaps.FaroisElementMap;
import acceptanceTest.testRule.TestRule;

public class FaroisPage extends FaroisElementMap{

	public boolean verificaPaginaFarois() {
		return TestRule.getNavegador().getCurrentUrl().contains("farois");
	}

}
