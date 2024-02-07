package com.shop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.base.TestBase;

public class AddToCartPage extends TestBase {
	@FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
	WebElement clickWishList;

	@FindBy(xpath = "//a[text()='wish list']")
	WebElement navToWishList;

	@FindBy(xpath = "//input[@id='input-quantity']")
	WebElement qty;

	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement cart;

	@FindBy(xpath = "//a[text()='shopping cart']")
	WebElement viewCart;

	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void addQty(String amount) throws InterruptedException {
		qty.clear();
		qty.sendKeys(amount);
	}

	public ViewCartPage addToCart() throws InterruptedException {
		cart.click();
		Thread.sleep(3000);
		viewCart.click();
		return new ViewCartPage();
	}

}
