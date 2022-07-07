package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class HW2 {
	WebDriver driver;
	
	By EMAIL_ADDRESS_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGN_IN_BUTTON_FIELD= By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD_HEADER_FIELD=By.xpath("//h2[text()=' Dashboard ']");
	By BANK_AND_CASH_FIELD = By.xpath("//span[text()='Bank & Cash']");
	By NEW_ACCOUNT_FIELD = By.cssSelector("a[href='https://techfios.com/billing/?ng=accounts/add/");
	By ACCOUNT_TITLE_FIELD = By.cssSelector("input[name='account']");
	By ACCOUNT_DESCRIPTION_FIELD = By.cssSelector("input[name='description']");
	By INITIAL_BALANCE_FIELD = By.xpath("//input[@id='balance']");
	By ACCOUNT_NUMBER_FIELD = By.xpath("//input[@name='account_number']");
	By CONTACT_PERSON_FIELD = By.cssSelector("input[id='contact_person']");
	By PHONE_NUMBER_FIELD = By.cssSelector("input[name='contact_phone']");
	By BANKING_URL_FIELD = By.xpath("//input[@id='ib_url']");
	By SUBMIT_BUTTON_FIELD = By.xpath("//button[@class='btn btn-primary' and @type='submit']");
	
	
	
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test
	public void login() {
		
		driver.findElement(EMAIL_ADDRESS_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGN_IN_BUTTON_FIELD).click();
		Assert.assertEquals("Dashboard", driver.findElement(DASHBOARD_HEADER_FIELD).getText());
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(BANK_AND_CASH_FIELD));

		driver.findElement(BANK_AND_CASH_FIELD).click();
		driver.findElement(NEW_ACCOUNT_FIELD).click();
		driver.findElement(ACCOUNT_TITLE_FIELD).sendKeys("Anna R's");
		driver.findElement(ACCOUNT_DESCRIPTION_FIELD).sendKeys("checking");
		driver.findElement(INITIAL_BALANCE_FIELD).sendKeys("10.00");
		driver.findElement(ACCOUNT_NUMBER_FIELD).sendKeys("1234567890");
		driver.findElement(CONTACT_PERSON_FIELD).sendKeys("Anna Radnaeva");
		driver.findElement(PHONE_NUMBER_FIELD).sendKeys("4124564785");
		driver.findElement(BANKING_URL_FIELD).sendKeys("annar@gmail.com");
		driver.findElement(SUBMIT_BUTTON_FIELD).click();

	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
