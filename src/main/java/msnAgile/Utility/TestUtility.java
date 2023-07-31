package msnAgile.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import msnAgile.Base.TestBase;

public class TestUtility extends TestBase {

	static File src, dest;

	public static void passedTestScreenShot(String name) {

		src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		dest = new File("D:\\EclipseWorkSpace\\MsnAgile\\ScreenShots" + name + ".png");

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static WebElement waitUntilElementExists(long timeoutinseconds, WebElement locator) {

		WebDriverWait wait = new WebDriverWait(driver, timeoutinseconds);
		wait.until(ExpectedConditions.visibilityOf(locator));
		
		return locator;
		

	}
	
}
