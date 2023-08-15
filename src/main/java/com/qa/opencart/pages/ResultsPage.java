package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class ResultsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By productResult = By.cssSelector("div.product-layout.product-grid");
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil =new ElementUtil(this.driver);
	}
	
	public String getResultaPageTitle(String searchKey) {
		return eleUtil.waitForTitleIsAndCapture(searchKey, 5);
	}

	public int getProductResultCount() {
	int resultCount=eleUtil.waitForElementsVisible(productResult, 10).size();
	System.out.println("Product result count--->"+ resultCount);
	return resultCount;
	}
	
	public ProductInfoPage selectProduct(String productName) {
		By productNameLocator = By.linkText(productName);
		eleUtil.doClick(productNameLocator);
		return new ProductInfoPage(driver);
	}

}
