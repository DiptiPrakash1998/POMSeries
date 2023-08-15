package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void actPageTitleTest() {
		String actTitle = accPage.getAccPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNT_PAGE_TITLE_VALUE);
	}

	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}

	@Test
	public void isMyAccountLinkExistTest() {
		Assert.assertTrue(accPage.isMyAccountLinkExist());
	}

	@Test
	public void accPageHeaderCountTest() {
		List<String> actAccHeaderList = accPage.getAccountPageHeadersList();
		Assert.assertEquals(actAccHeaderList.size(), 4);
	}

	@Test
	public void accPageHeaderTest() {
		List<String> actAccHeaderList = accPage.getAccountPageHeadersList();
		Assert.assertEquals(actAccHeaderList, AppConstants.EXP_ACCOUNT_HEADER_LIST);
	}

	

}
