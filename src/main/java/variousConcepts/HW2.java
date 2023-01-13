package variousConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class HW2 {
	WebDriver driver;
	
	By EMAIL_ADDRESS_FIELD = By.xpath("//input[@name='username']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGN_IN_BUTTON_FIELD= By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD_HEADER_FIELD=By.xpath("//h2[text()=' Dashboard ']");
	By BANK_AND_CASH_FIELD = By.xpath("//span[text()='Bank & Cash']");
	By NEW_ACCOUNT_FIELD = By.xpath("//a[text()='New Account']");
	By ACCOUNT_TITLE_FIELD = By.xpath("//input[@id='account']");
	By ACCOUNT_DESCRIPTION_FIELD = By.xpath("//input[@name='description']");
	By INITIAL_BALANCE_FIELD = By.xpath("//input[@id='balance']");
	By ACCOUNT_NUMBER_FIELD = By.xpath("//input[@name='account_number']");
	By CONTACT_PERSON_FIELD = By.xpath("//input[@id='contact_person']");
	By PHONE_NUMBER_FIELD = By.xpath("//input[@name='contact_phone']");
	By BANKING_URL_FIELD = By.xpath("//input[@id='ib_url']");
	By SUBMIT_BUTTON_FIELD = By.xpath("//button[@class='btn btn-primary' and @type='submit']");
	
	public HW2(WebDriver driver) {
		this.driver=driver;
	}

	public void enterLoginEmail(String userName) {
		driver.findElement(EMAIL_ADDRESS_FIELD).sendKeys(userName);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_ADDRESS_FIELD));
	}
	public void enterPassword(String password) {
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
	}
	public void clickLoginButton() {
		driver.findElement(SIGN_IN_BUTTON_FIELD).click();
	}
	public void verifyDashboardHeader() {
		Assert.assertEquals("Dashboard", driver.findElement(DASHBOARD_HEADER_FIELD).getText());
	}
	public void clickOnBankAndCashField() {
		driver.findElement(BANK_AND_CASH_FIELD).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(BANK_AND_CASH_FIELD));
	}
	public void clickOnNewAccountField() {
		driver.findElement(NEW_ACCOUNT_FIELD).click();
	}
	public void enterAccountTitle(String title) {
		driver.findElement(ACCOUNT_TITLE_FIELD).sendKeys(title);
	}
	public void enterAccountDescription(String description) {
		driver.findElement(ACCOUNT_DESCRIPTION_FIELD).sendKeys(description);
	}
	public void enterInitialBalance(String balance) {
		driver.findElement(INITIAL_BALANCE_FIELD).sendKeys(balance);
	}
	public void enterAccountNumber(String accountNumber) {
		driver.findElement(ACCOUNT_NUMBER_FIELD).sendKeys(accountNumber);
	}
	public void enterContactPerson(String contactPerson) {
		driver.findElement(CONTACT_PERSON_FIELD).sendKeys(contactPerson);
	}
	public void enterPhoneNumber(String phoneNumber) {
		driver.findElement(PHONE_NUMBER_FIELD).sendKeys(phoneNumber);
	}
	public void enterBankingUrl(String url) {
		driver.findElement(BANKING_URL_FIELD).sendKeys(url);
	}
	public void clickSubmitButton() {
		driver.findElement(SUBMIT_BUTTON_FIELD).click();
	}
}