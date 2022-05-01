package com.mk.tests;

import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.mk.constants.ProjectConstants;
import com.mk.enums.ConfigProperty;
import com.mk.pojos.DeserialisedUsers;
import com.mk.pojos.Users;
import com.mk.requestbuilderutils.RequestBuilder;
import com.mk.requestutils.PropertyReader;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class PostRequestTest {

	@Test(dataProvider = "PostCallTestData", dataProviderClass = TestRequestDataProvider.class)
	public final void reqresPostCall(Users user) {

		Response response = RequestBuilder.buildPostRequest()

					.body(user)
					.post(PropertyReader.getConfigPropertyValue(ConfigProperty.POSTCALLPATHPARAM));

		response.prettyPrint();
		
		response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(ProjectConstants.getResposeSchemaFilePath()));

		Assertions.assertThat(response.getStatusCode()).as("Validate response status code").isEqualTo(201);

		Assertions.assertThat(response.timeIn(TimeUnit.SECONDS)).as("Validate response time").isLessThan(5);

		Assertions.assertThat(response.getContentType()).as("Validate response content type").contains("application/json");

		DeserialisedUsers deserialisedUser = response.body().as(DeserialisedUsers.class);

		System.out.println(deserialisedUser.getName());

		System.out.println(deserialisedUser.getJob());

		System.out.println(deserialisedUser.getId());

		System.out.println(deserialisedUser.getCreatedAt());

		
	}

}
