package com.shop.dataproviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shop.utility.FetchData;

public class DataProvidersSet {
	
	@Test(dataProvider = "DPLog")
	public void checkLogin(String email, String password) {
		System.out.println(email);
		System.out.println(password);
	}
	
	@Test(dataProvider = "DPReg")
	public void checkRegister(String fName, String lName, String tel, String mail, String pwd, String confirmPwd) {
		System.out.println(fName);
		System.out.println(lName);
		System.out.println(tel);
		System.out.println(mail);
		System.out.println(pwd);
		System.out.println(confirmPwd);
	}
	
	
	@DataProvider(name = "DPReg")
	public static Object[][] RegDataProvider() {
		String projectpath = System.getProperty("user.dir");
		String sheetlocation = projectpath + "/TestData/TestDataSheet1.xlsx";
		Object[][] dp = getData(sheetlocation, "Sheet1");
		return dp;
	}
	@DataProvider(name = "DPLog")
	public static Object[][] LoginDataProvider() {
		String projectpath = System.getProperty("user.dir");
		String sheetlocation = projectpath + "/TestData/TestDataSheet1.xlsx";
		Object[][] dpLog = getData(sheetlocation, "Sheet2");
		return dpLog;
	}
	
	
	public static Object[][] getData(String sheetPath, String sheetName) {
		FetchData data = new FetchData(sheetPath, sheetName);
		int rows = FetchData.getNumberOfRows();
		int columns = FetchData.getNumberOfColumns();

		Object[][] obj = new Object[rows - 1][columns];

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				String cellData = FetchData.getStringData(i, j);
				obj[i - 1][j] = cellData;
			}
		}
		return obj;
	}

}
