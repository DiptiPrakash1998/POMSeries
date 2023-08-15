package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

public class RegisterPageTest extends BaseTest {
	@BeforeClass
	public void regSetup() {
		registerPage = loginPage.navigateToRegisterPage();
	}

	public String generateRandomEmailId() {
		return "testautomation" + System.currentTimeMillis() + "@email.com";
	}

	@Test
	public void userRegisterTest() {
		String actRegSucMesg = registerPage.registerUser("Sai", "Ram", generateRandomEmailId(), "1234567890", "sai@123", "yes");
		Assert.assertEquals(actRegSucMesg, AppConstants.USER_REG_SUCCESS_MSG);
	}

}
