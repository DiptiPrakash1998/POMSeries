package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataprovider.ProductDataProvider;

public class SearchTest extends BaseTest{
	@BeforeClass
	public void accPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(dataProvider = "productDataWithSearchKey", dataProviderClass =ProductDataProvider.class)
	public void searchProductResultsCountTest(String searchKey) {
		resultsPage = accPage.doSearch(searchKey);
		int productCount =resultsPage.getProductResultCount();
		Assert.assertTrue(productCount>0);
	}
	
	@Test(dataProvider = "productDataWithSearchKey", dataProviderClass =ProductDataProvider.class)
	public void searchPageTitleTest(String searchKey) {
		resultsPage = accPage.doSearch(searchKey);
		String actPageTitle = resultsPage.getResultaPageTitle(searchKey);
		System.out.println("Search page title:"+ actPageTitle);
		Assert.assertEquals(actPageTitle, "Search - "+searchKey);
	}
	
	
	@Test(dataProvider = "productDataWithName", dataProviderClass =ProductDataProvider.class)
	public void selectProductTest(String searchKey, String productName) {
		resultsPage = accPage.doSearch(searchKey);
		productInfoPage=resultsPage.selectProduct(productName);
		String actProductheaderName = productInfoPage.getProductHeaderName();
		System.out.println("prodcut header is:"+actProductheaderName);
		Assert.assertEquals(actProductheaderName, productName);	
	}
	
	
	
	@Test(dataProvider = "productDataWithImage", dataProviderClass =ProductDataProvider.class)
	public void productImagesTest(String searchKey, String productName, int expImagesCount) {
		resultsPage = accPage.doSearch(searchKey);
		productInfoPage=resultsPage.selectProduct(productName);
		int actProductImagesCount = productInfoPage.getProductImageCount();
		System.out.println("prodcut header is:"+actProductImagesCount);
		Assert.assertEquals(actProductImagesCount, expImagesCount);	
	}

}
