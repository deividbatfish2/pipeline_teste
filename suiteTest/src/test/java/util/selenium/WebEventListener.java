package util.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import util.Log;

public class WebEventListener extends AbstractWebDriverEventListener{

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		Log.logInfo("Texo " + arg2.toString() + "informado no campo " + arg0.toString());
		
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		Log.logInfo("Clique no elemento: " + arg0.toString());
	}
	
}
