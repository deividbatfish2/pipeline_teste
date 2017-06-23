package util.selenium.webdriver.manager;

public class DriverManagerFactory {

	public static DriverManager getManager(DriverType type) {

		DriverManager driverManager = null;

		switch (type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		case OPERA:
			driverManager = new OperaDriverManager();
			break;
		case CHROME_HEADLESS:
			driverManager = new ChromeDriverHeadLessManager();
			break;
		default:
			driverManager = new ChromeDriverManager();
			break;
		}

		return driverManager;
	}
}
