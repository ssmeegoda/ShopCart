package com.shop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "input-email")
	WebElement email;

	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//h2[text()='Returning Customer']")
	WebElement returnCustomer;

	@FindBy(xpath = "//h2[text()='New Customer']")
	WebElement newCustomer;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueRegBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public SearchPage addLoginData(String emailField, String passwordField) throws InterruptedException {
		email.clear();
		email.sendKeys(emailField);
		password.clear();
		password.sendKeys(passwordField);
		Thread.sleep(2000);
		loginBtn.click();
		return new SearchPage();
	}

	public boolean returnCustomerValidate() {
		return returnCustomer.isDisplayed();
	}

	public RegisterPage naviagettoRegPage() {
		continueRegBtn.click();
		return new RegisterPage();
	}

}
