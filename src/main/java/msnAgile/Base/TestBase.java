package msnAgile.Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBase {

	protected static Properties prop;
	File file;
	FileInputStream fis;
	protected static WebDriver driver;
	protected static String uRL;

	ExtentSparkReporter htmlReporter;
	protected ExtentReports extent;
	public ExtentTest test;

	public TestBase() {

		prop = new Properties();
		file = new File("D:\\EclipseWorkSpace\\MsnAgile\\src\\main\\java\\msnAgile\\Config\\Configure.properties");

		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();

		}

		// extent report

		htmlReporter = new ExtentSparkReporter("ExtentReporter.html");
		htmlReporter.config().setDocumentTitle("Extent Automation report");
		htmlReporter.config().setReportName("Test report");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tester Name", "sahil");

		test = extent.createTest("sahil", "kakar");

	}

	public static void initilization() {

		System.setProperty("webdriver.edge.driver", "D:\\EclipseWorkSpace\\MsnAgile\\BrowserDrivers\\msedgedriver.exe");

		driver = new EdgeDriver();

		driver.manage().deleteAllCookies();

		uRL = prop.getProperty("appurl");
		driver.get(uRL);

		driver.manage().window().maximize();

	}

}
