package msnAgile.Page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import msnAgile.Base.TestBase;

public class HomePage extends TestBase {

	protected WebDriver driver;

	@FindBy(xpath = "//span[text()=' Manage Users & Groups']")
	WebElement manageUsersGroupsLink;

	@FindBy(xpath = "//div[@id='createColumnBtn']")
	WebElement createBtn;

	@FindBy(xpath = "//span[@id='inviteUserButton']")
	WebElement inviteUsersBtn;

	@FindBy(xpath = "//input[@id='emailfield']")
	WebElement emailTxtBx;

	@FindBy(xpath = "//button[@id='sendbtn']")
	WebElement sendBtn;

	@FindBy(css = "i.fa.fa-times-circle.p-3")
	WebElement invitePopupcancel;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr")
	WebElement rows;

	public HomePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public HomePage inviteUserFlow() {

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", manageUsersGroupsLink);

		createBtn.click();
		test.info("clicked on create button");

		inviteUsersBtn.click();
		test.info("clicked on inviteUsers button");

		emailTxtBx.sendKeys(prop.getProperty("userAdded"));
		test.info("email entered");

		js.executeScript("arguments[0].click();", sendBtn);

		Actions act = new Actions(driver);

		act.doubleClick(sendBtn).build().perform();

		invitePopupcancel.click();

		test.log(Status.PASS, "this is passing");

		extent.flush();
		return this;

	}

	public void verifyUserAdded() {

		int totalrows = driver.findElements(By.xpath("//tbody[@role='rowgroup']//tr")).size();
		int totalcolumns = driver.findElements(By.xpath("//tbody[@role='rowgroup']//tr[1]//td")).size();

		for (int r = 1; r <= totalrows; r++) {
			for (int c = 1; c <= totalcolumns; c++) {

				List<WebElement> allValues = driver
						.findElements(By.xpath("//tbody[@role='rowgroup']//tr[" + r + "]//td[" + c + "]"));

				for (WebElement value : allValues) {

					System.out.println(value.getText());

					if (value.getText().contains(prop.getProperty("userAdded"))) {

						System.out.println("user is present in the table");
						break;

					}

				}
			}
		}
	}
}