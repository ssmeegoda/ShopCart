package com.shop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.base.TestBase;

public class RegisterPage extends TestBase {

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//input[@name='telephone']")
	WebElement telephone;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@name='confirm']")
	WebElement confirmPassword;

	@FindBy(xpath = "//label[text()='Subscribe']//following-sibling::div/descendant::input[@value=1]")
	WebElement newsLetter;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement privacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement register;

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public void addData(String fName, String lName, String mail, String tel, String pwd, String confirmPwd)
			throws InterruptedException {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(mail);
		telephone.sendKeys(tel);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(confirmPwd);
		Thread.sleep(2000);
	}

	public void clicknewsLetter() {
		newsLetter.click();
	}

	public void privacyPolicyCheck() {
		privacyPolicy.click();
	}

	public SearchPage clickRegButton() {
		register.click();
		return new SearchPage();
	}
}
