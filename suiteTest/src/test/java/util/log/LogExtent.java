package util.log;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import acceptanceTest.testRule.TestRule;
import cucumber.api.Scenario;
import util.log.interfaces.ILogBdd;

public class LogExtent implements ILogBdd {

	private ExtentHtmlReporter htmlReporter;
	private ExtentReports extentReporter;
	private ExtentTest feature;
	private String strLog;

	public LogExtent() {

		if (extentReporter == null) {
			extentReporter = new ExtentReports();
			File reports = new File("target/reports");
			if (!reports.exists()) {
				reports.mkdirs();
			}
			htmlReporter = new ExtentHtmlReporter("target/reports/htmlReports.htm");
			extentReporter.attachReporter(htmlReporter);
		}
	}

	@Override
	public void addMensageInfo(String mensagem) {

		this.feature.log(Status.INFO, mensagem);

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

	@Override
	public void createLog() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createLog(Scenario cenario) {
		feature = extentReporter.createTest(cenario.getId());

	}

	@Override
	public void finishLog() {
		this.extentReporter.flush();

	}

	@Override
	public void addMensageSuccessPrint(String mensagem) {
		try {
			this.feature.log(Status.PASS, this.strLog,
					MediaEntityBuilder.createScreenCaptureFromPath(tirarPrintTela(mensagem).getAbsolutePath()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addMensageFailPrint(String mensagem) {
		try {
			this.feature.log(Status.FAIL, this.strLog,
					MediaEntityBuilder.createScreenCaptureFromPath(tirarPrintTela(mensagem).getAbsolutePath()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void addMensageInfoPrint(String mensagem) {
		try {
			this.feature.log(Status.INFO, this.strLog,
					MediaEntityBuilder.createScreenCaptureFromPath(tirarPrintTela(mensagem).getAbsolutePath()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
