package com.shop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.base.TestBase;

public class SearchPage extends TestBase {

	@FindBy(xpath = "//input[@name='search']")
	WebElement searchField;

	@FindBy(xpath = "//button[contains(@class,'btn btn-default btn')]")
	WebElement searchBtn;

	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterproduct(String product) {
		searchField.sendKeys(product);
		searchBtn.click();
	}

}
