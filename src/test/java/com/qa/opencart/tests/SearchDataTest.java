package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataprovider.ProductDataProvider;

import co.qa.opencart.pojo.Product;

public class SearchDataTest extends BaseTest{
	@BeforeClass
	public void accPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(dataProvider = "productData",dataProviderClass=ProductDataProvider.class)
	public void searchProductResultsCountTest(Product product) {
		resultsPage = accPage.doSearch(product.getSearchKey());
		int productCount =resultsPage.getProductResultCount();
		Assert.assertTrue(productCount>0);
	}
	
	@Test(dataProvider = "productData",dataProviderClass=ProductDataProvider.class)
	public void searchPageTitleTest(Product product) {
		resultsPage = accPage.doSearch(product.getSearchKey());
		String actPageTitle = resultsPage.getResultaPageTitle(product.getSearchKey());
		System.out.println("Search page title:"+ actPageTitle);
		Assert.assertEquals(actPageTitle, "Search - "+product.getSearchKey());
	}
	
	@Test(dataProvider = "productData",dataProviderClass=ProductDataProvider.class)
	public void selectProductTest(Product product) {
		resultsPage = accPage.doSearch(product.getSearchKey());
		productInfoPage=resultsPage.selectProduct(product.getProductName());
		String actProductheaderName = productInfoPage.getProductHeaderName();
		System.out.println("prodcut header is:"+actProductheaderName);
		Assert.assertEquals(actProductheaderName, product.getProductName());	
	}
	
	
	@Test(dataProvider = "productData",dataProviderClass=ProductDataProvider.class)
	public void productImagesTest(Product product) {
		resultsPage = accPage.doSearch(product.getSearchKey());
		productInfoPage=resultsPage.selectProduct(product.getProductName());
		int actProductImagesCount = productInfoPage.getProductImageCount();
		System.out.println("prodcut header is:"+actProductImagesCount);
		Assert.assertEquals(actProductImagesCount, product.getProductImages());	
	}

}
