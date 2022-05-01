package com.mk.tests;

import org.testng.annotations.DataProvider;

import com.mk.pojos.Users;
import com.mk.requestutils.TestDataUtil;

public class TestRequestDataProvider {
	
	private TestRequestDataProvider() {
		
	}

	@DataProvider(name = "PostCallTestData")
	public static Object[][] postCallData() {

		Object[][] userData = new Object[2][1];

		Users user1 = Users.builder().setName(TestDataUtil.getUserName()).setJob(TestDataUtil.getUserJob()).build();
		Users user2 = Users.builder().setName(TestDataUtil.getUserName()).setJob(TestDataUtil.getUserJob()).build();

		userData[0][0] = user1;
		userData[1][0] = user2;

		return userData;

	}
}
