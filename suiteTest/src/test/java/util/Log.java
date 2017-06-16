package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import acceptanceTest.testRule.TestRule;

public class Log {

	
	public static void logsEPrints(String strLog){
		ExtentTest extendTest = TestRule.getExtendTest();
		
		try {
			tirarPrintTela(strLog);
			extendTest.log(Status.INFO, strLog, MediaEntityBuilder.
					createScreenCaptureFromPath(System.getProperty("user.dir") + "/src/test/resources/reports/" + strLog + ".png")
			.build());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	private static void tirarPrintTela(String strLog) {
		File strFile = ((TakesScreenshot) TestRule.getNavegador()).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(strFile, 
					new File(System.getProperty("user.dir") + "/src/test/resources/reports/" + strLog + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
