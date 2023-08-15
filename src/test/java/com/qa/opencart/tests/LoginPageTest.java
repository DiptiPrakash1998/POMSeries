package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic 100:Login Page Design")
@Story("US101: Design login page for open cart app with title,url,forgetpwd & Login test")
public class LoginPageTest extends BaseTest {
	@Severity(SeverityLevel.MINOR)
	@Description("Checking Login page title test")
	@Feature("login page title")
	@Test
	public void getLoginPageTitle() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}
	@Severity(SeverityLevel.NORMAL)
	@Description("Checking Login page url tests")
	@Feature("login page url")
	@Test
	public void loginPageUrlTest() {
		String actURL = loginPage.getLoginPageUrl();
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}
	@Severity(SeverityLevel.BLOCKER)
	@Description("Checking Login page Forgot pwd tests")
	@Feature("login page forgot pwd")
	@Test
	public void ForgetPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	@Severity(SeverityLevel.CRITICAL)
	@Description("Checking Login page tests")
	@Feature("login page")
	@Test
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutLinkExist());
		Assert.assertTrue(accPage.getAccPageTitle().equals("My Account"));
	}

}
