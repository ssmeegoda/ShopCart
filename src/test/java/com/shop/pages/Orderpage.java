package com.shop.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shop.base.TestBase;

public class Orderpage extends TestBase {
	Select select;

	@FindBy(xpath = "//input[@id='input-search']")
	WebElement inputSearchBox;

	@FindBy(xpath = "//select[@name='category_id']")
	WebElement catogaries;

	@FindBy(xpath = "//input[@id='button-search']")
	WebElement searchBtn;

	@FindBy(xpath = "//select[@id='input-sort']")
	WebElement sortByPrice;

	@FindBy(xpath = "//div[@class='product-thumb']/descendant::h4/child::a")
	WebElement productname;

	@FindBy(xpath = "//input[@id='description']")
	WebElement checkDescription;

	public Orderpage() {
		PageFactory.initElements(driver, this);
	}

	public String validateSearchBox() {
		return inputSearchBox.getAttribute("value");
	}

	public void selectCategories(String productValue) throws InterruptedException {
		select = new Select(catogaries);
		select.selectByValue(productValue);
		checkDescription.click();
		Thread.sleep(3000);
	}

	public void sortByPrice(String sortRange) throws InterruptedException {
		select = new Select(sortByPrice);
		select.selectByVisibleText(sortRange);
		Thread.sleep(2000);
		List<WebElement> list = select.getOptions();
		for (WebElement element : list) {
			System.out.println(element.getText());
		}
	}

	public AddToCartPage clickProductTitle() {
		productname.click();
		return new AddToCartPage();
	}
}
