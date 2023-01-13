package session2_New;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import variousConcepts.HW2;

public class TestHW{


	WebDriver driver;
	
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
	public void loginAndCreateAccount() {
		
		HW2 hw = PageFactory.initElements(driver, HW2.class);
		
		hw.enterLoginEmail("demo@techfios.com");
		hw.enterPassword("abc123");
		hw.clickLoginButton();
		hw.verifyDashboardHeader();
		hw.clickOnBankAndCashField();
		hw.clickOnNewAccountField();
		hw.enterAccountTitle("Anna R's");
		hw.enterAccountDescription("checking");
		hw.enterInitialBalance("10.00");
		hw.enterAccountNumber("1234567890");
		hw.enterContactPerson("Anna Radnaeva");
		hw.enterPhoneNumber("4124564785");
		hw.enterBankingUrl("annar@gmail.com");
		hw.clickSubmitButton();
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
	
	
}
