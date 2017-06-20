package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import acceptanceTest.testRule.TestRule;

public class Log {

	private ExtentTest extendTest;
	private String strLog;

	public Log(String strLog) {
		this.strLog = strLog;
		this.extendTest = TestRule.getExtendTest();
	}

	public Log tipoInformacao() {

		this.extendTest.log(Status.INFO, this.strLog);

		return this;
	}

	public Log tipoCenarioCorreto() {

		this.extendTest.log(Status.PASS, this.strLog);
		
		return this;
	}

	public Log tipoErro() {

		this.extendTest.log(Status.ERROR, this.strLog);

		return this;
	}

	public void comPrintScreen() {
		tirarPrintTela(this.strLog);
		try {
			this.extendTest.addScreenCaptureFromPath(tirarPrintTela(this.strLog).getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private File tirarPrintTela(String strLog) {
		File strFile = ((TakesScreenshot) TestRule.getNavegador()).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(strFile,
					new File(System.getProperty("user.dir") + "/target/reports/" + strLog + ".png"));
			return new File(System.getProperty("user.dir") + "/target/reports/" + strLog + ".png");
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
