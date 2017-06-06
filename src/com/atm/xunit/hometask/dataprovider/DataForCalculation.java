package com.atm.xunit.hometask.dataprovider;

import org.testng.annotations.DataProvider;

public class DataForCalculation {

	@DataProvider(name = "addInput")
	public Object[][] getAddData() {
		return new Object[][] { { 2, 2, 4 }, { 2, 3, 5 }, { 5, 3, 8 } };
	}

	@DataProvider(name = "subInput")
	public Object[][] getSubData() {
		return new Object[][] { { 4, 2, 2 }, { 5, 3, 2 }, { 6, 3, 3 } };
	}

	@DataProvider(name = "mulInput")
	public Object[][] getMulData() {
		return new Object[][] { { 4, 2, 8 }, { 5, 3, 15 }, { 6, 3, 18 } };
	}

	@DataProvider(name = "divideInput")
	public Object[][] getDivideData() {
		return new Object[][] { { 4, 2, 2 }, { 6, 3, 2 }, { 15, 3, 5 } };
	}

	@DataProvider(name = "sqrtInput")
	public Object[][] getSqrtData() {
		return new Object[][] { { 4, 2 }, { 16, 4 }, { 81, 9 } };
	}

	@DataProvider(name = "addNegInput")
	public Object[][] getNegAddData() {
		return new Object[][] { { 2, 2, 5 }, { 2, 3, 6 }, { 5, 3, 9 } };
	}

	@DataProvider(name = "subNegInput")
	public Object[][] getNegSubData() {
		return new Object[][] { { 2, 2, 1 }, { 2, 3, 1 }, { 15, 3, 9 } };
	}

	@DataProvider(name = "mulNegInput")
	public Object[][] getNegMulData() {
		return new Object[][] { { 2, 2, 41 }, { 12, 3, 111 }, { 115, 3, 91 } };
	}

	@DataProvider(name = "divNegInput")
	public Object[][] getNegDivData() {
		return new Object[][] { { 2, 2, 4 }, { 2, 3, 11 }, { 15, 3, 19 } };
	}

	@DataProvider(name = "sqrtNegInput")
	public Object[][] getSqrtNegData() {
		return new Object[][] { { -4, 12 }, { -16, 45 }, { -181, 97 } };
	}
	
	@DataProvider(name = "cosine")
	public Object[][] getCosineData() {
		return new Object[][] { { 0, 1 }, { 45, 0.70710678118 }, { 90, 0 } };
	}
	
	@DataProvider(name = "tangent")
	public Object[][] getTangentData() {
		return new Object[][] { { 0, 0 }, { 45, 1}, {60, 1.73205080757} };
	}


}
