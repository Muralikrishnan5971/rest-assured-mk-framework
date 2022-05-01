package com.mk.requestbuilderutils;

import static io.restassured.RestAssured.given;

import com.mk.enums.ConfigProperty;
import com.mk.requestutils.PropertyReader;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

	private RequestBuilder() {

	}

	public static RequestSpecification buildGetRequest() {

		return given()
					.baseUri(PropertyReader.getConfigPropertyValue(ConfigProperty.BASEURI))
					.log()
					.all();
	}

	public static RequestSpecification buildPostRequest() {

		return buildGetRequest()
					.contentType(ContentType.JSON);
	}
}
