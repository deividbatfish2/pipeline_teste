package util.selenium.webdriver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import util.selenium.WebEventListener;

public abstract class DriverManager {

	protected WebDriver driver;
	protected EventFiringWebDriver navegador;
	protected WebEventListener eventListener;

	protected abstract void iniciarServico();

	protected abstract void criarNavegador();

	public void fecharNavegador() {

		if (null != this.navegador) {
			this.navegador.quit();
			this.navegador = null;
		}

	}

	public EventFiringWebDriver getNavegador() {
		if (null == this.navegador) {
			iniciarServico();
			criarNavegador();
		}
		return this.navegador;
	}
}
