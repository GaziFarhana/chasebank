package Steps;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Utils.Lib;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GUIStepDefinition extends Lib {

	public WebDriver driver;

	@Before
	public void Initialize() {
		System.getProperty("webdriver, chrome,driver",
				"/Users/gazifarhana/eclipse-workspace1/ChaseFindCreditCard/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.chase.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^i am at Chase homepage$")
	public void Print_Title() {
		System.out.println("i am at this page : " + driver.getTitle());

	}

	@When("^i click on \"([^\"]*)\"$")
	public void I_click_on(String xpath) throws IOException, InterruptedException {
		WebElement elem = Findelement(driver, readproperties(xpath));
		elem.click();
		Thread.sleep(4000);
		;
	}

	@And("^i enter \"([^\"]*)\" \"([^\"]*)\"$")
	public void I_Am_Entering(String xpath, String value) throws IOException, InterruptedException {
		String win1 = driver.getWindowHandle();
		Set<String> wins = driver.getWindowHandles();
		for (String win2 : wins) {
			if (!win2.equals(win1)) {
				driver.switchTo().window(win2);
				WebElement elem = Findelement(driver, readproperties(xpath));
				elem.sendKeys(value);
				Thread.sleep(3000);;
				
			}
		}
	}
	@Then("^i select \"([^\"]*)\" \"([^\"]*)\"$")
	public void I_Am_Selecting(String xpath, String value) throws IOException, InterruptedException {
		WebElement elem = Findelement(driver, readproperties(xpath));
		Select slct = new Select(elem);
		slct.selectByVisibleText(value);
		Thread.sleep(4000);
	}

	@After
	public void teardown() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}
}
