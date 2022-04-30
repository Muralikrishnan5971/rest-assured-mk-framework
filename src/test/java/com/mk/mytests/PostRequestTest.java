package com.mk.mytests;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mk.pojos.DeserialisedUsers;
import com.mk.pojos.Users;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class PostRequestTest {

	@Test(dataProvider = "PostCallTestData")
	public void ReqresPostCall(Users user) {

		Response response = given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.body(user)
				.post("https://reqres.in/api/users");
		
		response.prettyPrint();
		
		Assertions.assertThat(response.getStatusCode()).as("Validating response status code").isEqualTo(201);
		
		response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/responseSchema.json"));
		
		Assertions.assertThat(response.timeIn(TimeUnit.SECONDS)).as("Validating response time").isLessThan(5);
		
		Assertions.assertThat(response.getContentType()).as("Validating response content type").contains("application/json");
		
		DeserialisedUsers deserialisedUser = response.body().as(DeserialisedUsers.class);
		
		System.out.println(deserialisedUser.getName());
		
		System.out.println(deserialisedUser.getJob());
		
		System.out.println(deserialisedUser.getId());
		
		System.out.println(deserialisedUser.getCreatedAt());
		
	}

	@DataProvider(name = "PostCallTestData")
	public Object[][] postCallData() {

		Object[][] userData = new Object[2][1];

		Users user1 = Users.builder().setName("John").setJob("Teacher").build();
		Users user2 = Users.builder().setName("Wayne").setJob("Singer").build();

		userData[0][0] = user1;
		userData[1][0] = user2;

		return userData;
	}
}
