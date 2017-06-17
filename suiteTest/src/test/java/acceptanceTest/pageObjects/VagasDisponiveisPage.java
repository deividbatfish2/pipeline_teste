package acceptanceTest.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptanceTest.testRule.TestRule;

public class VagasDisponiveisPage {

	public VagasDisponiveisPage() {
		PageFactory.initElements(TestRule.getNavegador(), this);
	}

	public boolean verificarVagasDisponiveis() {
		List<WebElement> anuncios = new ArrayList<WebElement>();
		anuncios.addAll(TestRule.getNavegador().findElements(By.cssSelector("div[id^='an-div-parametros-anuncio']")));
		if (anuncios.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
