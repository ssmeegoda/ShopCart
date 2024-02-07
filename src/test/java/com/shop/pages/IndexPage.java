package com.shop.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shop.base.TestBase;

public class IndexPage extends TestBase {

	@FindBy(id = "logo")
	WebElement logo;

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccount;

	@FindBy(linkText = "Register")
	WebElement register;

	@FindBy(linkText = "Login")
	WebElement login;

	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean logoValidate() {
		return logo.isDisplayed();
	}

	public RegisterPage userRegister() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(myAccount));
		myAccount.click();
		Thread.sleep(2000);
		register.click();
		return new RegisterPage();
	}

	public LoginPage userLogin() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(myAccount));
		myAccount.click();
		Thread.sleep(2000);
		login.click();
		return new LoginPage();
	}
}
