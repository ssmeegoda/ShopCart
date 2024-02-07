package com.shop.tests;

import com.shop.pages.IndexPage;
import com.shop.pages.LoginPage;
import com.shop.pages.RegisterPage;
import com.shop.pages.SearchPage;

public class TestFunctions {
	IndexPage index;
	LoginPage login;
	RegisterPage register;
	SearchPage searchPage;

	public void sendloginData(Object[][] obj) throws InterruptedException {
		for (Object[] rowData : obj) {
			login = new LoginPage();
			login.addLoginData(rowData[0].toString(), rowData[1].toString());
		}
	}

	public void sendRegisterData(Object[][] obj) throws InterruptedException {
		for (Object[] rowData : obj) {
			register = new RegisterPage();
			register.addData(rowData[0].toString(), rowData[1].toString(), rowData[2].toString(), rowData[3].toString(),
					rowData[4].toString(), rowData[5].toString());
		}
	}

}
