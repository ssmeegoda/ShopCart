package com.shop.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.shop.base.TestBase;
import com.shop.dataproviders.DataProvidersSet;
import com.shop.pages.AddToCartPage;
import com.shop.pages.IndexPage;
import com.shop.pages.LoginPage;
import com.shop.pages.Orderpage;
import com.shop.pages.RegisterPage;
import com.shop.pages.SearchPage;
import com.shop.pages.ViewCartPage;

public class IndexpageTest extends TestBase {
	IndexPage index;
	LoginPage login;
	RegisterPage register;
	SearchPage searchPage;
	TestFunctions functions;
	DataProvidersSet dpSet;
	AddToCartPage cart;
	ViewCartPage viewCartPage;

	@BeforeClass
	public void setUp() {
		launchApp();
	}

	@AfterClass
	public void tearDwon() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test(priority = 1)
	public void validateLogo() {
		index = new IndexPage();
		boolean status = index.logoValidate();
		Assert.assertTrue(status);
	}

	@Test(priority = 2)
	public void validateTitle() {
		index = new IndexPage();
		String actualtitle = index.getTitle();
		String expectedTitle = "Your Store";
		Assert.assertEquals(actualtitle, expectedTitle);
	}

	@Parameters({ "login_status" })
	@Test(priority = 3)
	public void validateUserLoginStatus(boolean login_status) throws InterruptedException {
		if (login_status) {
			login = index.userLogin();
			Assert.assertTrue(login.returnCustomerValidate());
			functions = new TestFunctions();
			functions.sendloginData(DataProvidersSet.LoginDataProvider());
		} else {
			Thread.sleep(2000);
			System.out.println("User should register first");
			register = index.userRegister();
			functions = new TestFunctions();
			functions.sendRegisterData(DataProvidersSet.RegDataProvider());
			Thread.sleep(2000);
			register.clicknewsLetter();
			register.privacyPolicyCheck();

		}
	}

	@Parameters({ "product" })
	@Test(priority = 4)
	public void searchPage(String product) {
		searchPage = new SearchPage();
		searchPage.enterproduct(product);
	}

	@Parameters({ "product", "category", "sortPrice" })
	@Test(priority = 5)
	public void orderPage(String product, String category, String sortPrice) throws InterruptedException {
		Orderpage orderPage = new Orderpage();
		String actualSearchKey = orderPage.validateSearchBox();
		Assert.assertEquals(actualSearchKey, product);
		orderPage.selectCategories(category);
		orderPage.sortByPrice(sortPrice);
		orderPage.clickProductTitle();

	}

	@Parameters({ "qty" })
	@Test(priority = 6)
	public void addToCart(String qty) throws InterruptedException {
		cart = new AddToCartPage();
		cart.addQty(qty);
		cart.addToCart();

	}

}
