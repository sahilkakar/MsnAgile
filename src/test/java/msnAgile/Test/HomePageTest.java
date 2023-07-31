package msnAgile.Test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import msnAgile.Base.TestBase;
import msnAgile.Page.HomePage;
import msnAgile.Page.LoginPage;
import msnAgile.Utility.TestUtility;

public class HomePageTest extends TestBase {

	LoginPage lp;
	HomePage hp;

	public HomePageTest() {

	}

	@BeforeTest
	public void setup() {

		TestBase.initilization();

		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.login(prop.getProperty("email"), prop.getProperty("password"));

	}

	@Test
	public void invitenewUserTest() {

		hp = hp.inviteUserFlow();

	}

	@Test
	public void verifyUserAddedTest() {

		hp.verifyUserAdded();

	}

	@AfterMethod
	public void wrapUp(ITestResult result) {

		String methodName = result.getName();

		if (!(result.isSuccess()) || result.isSuccess()) {

			TestUtility.passedTestScreenShot(methodName);

			test.info("screenshot taken");

		}

		extent.flush();

	}

	@AfterTest
	public void quit() {

		// driver.quit();
	}
}
