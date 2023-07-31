package msnAgile.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import msnAgile.Base.TestBase;
import msnAgile.Page.LoginPage;

@Listeners(msnAgile.Utility.Listeners.class)

public class LoginPageTest extends TestBase {

	LoginPage loginpage;

	public LoginPageTest() {
	}

	@BeforeMethod
	public void lunchBrowser() {

		TestBase.initilization();
		loginpage = new LoginPage(driver);

	}

	@Test
	public void loginTest() {
		loginpage.login(prop.getProperty("email"), prop.getProperty("password"));

		test.pass("login successfull");

	}

	@AfterMethod

	public void report() {
		extent.flush();
	}

	@AfterTest
	public void quit() {

		// driver.quit();
	}

}
