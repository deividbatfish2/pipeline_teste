package util.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import acceptanceTest.testRule.TestRule;

public class WebEventListener extends AbstractWebDriverEventListener {

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {

		TestRule.getLogAtivo().addMensageInfo("Texo " + arg2.toString() + "informado no campo " + arg0.toString());

	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		TestRule.getLogAtivo().addMensageInfo("Clique no elemento: " + arg0.toString());
	}

}
