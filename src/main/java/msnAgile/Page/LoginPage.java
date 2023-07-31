package msnAgile.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import msnAgile.Base.TestBase;

public class LoginPage extends TestBase {

	protected WebDriver driver;

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailTxtBx;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordTxtBx;

	@FindBy(xpath = "//button[@id='loginBtbn']")
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void login(String userName, String PassWord) {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		emailTxtBx.sendKeys(userName);
		passwordTxtBx.sendKeys(PassWord);
		loginBtn.click();

		test.pass("clicked on login button");

	}

}