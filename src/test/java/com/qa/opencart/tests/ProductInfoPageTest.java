package com.qa.opencart.tests;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest{
	@BeforeClass
	public void accPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	//{Brand=Apple, Availability=In Stock, Product Code=Product 18, 
	//productname=MacBook Pro, Reward Points=800, exttaxprice=$2,000.00, productcrice=$2,000.00}--- HashMap
	//{Brand=Apple, Product Code=Product 18, Reward Points=800, Availability=In Stock, 
	//productprice=$2,000.00, extaxprice=$2,000.00, productname=MacBook Pro}--- LinkedHaspMap
	//{Availability=In Stock, Brand=Apple, Product Code=Product 18, Reward Points=800, 
	//extaxprice=$2,000.00, productname=MacBook Pro, productprice=$2,000.00} --- TreeMap(Sorted Map)
	@Test
	public void productInfoTest() {
		resultsPage = accPage.doSearch("Macbook");
		productInfoPage = resultsPage.selectProduct("MacBook Pro");
		Map<String, String> productInfoMap = productInfoPage.getProductInfo();
		System.out.println(productInfoMap);
		softAssert.assertEquals(productInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(productInfoMap.get("Availability"), "In Stock23");
		softAssert.assertEquals(productInfoMap.get("productname"), "MacBook Pro");
		softAssert.assertEquals(productInfoMap.get("productprice"), "$2,000.00");
		softAssert.assertAll();
		
	}
}
