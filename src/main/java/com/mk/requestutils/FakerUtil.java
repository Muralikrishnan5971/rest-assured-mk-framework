package com.mk.requestutils;

import com.github.javafaker.Faker;

public final class FakerUtil {

	private FakerUtil() {

	}

	private static final Faker faker = new Faker();

	static String getName() {

		return faker.name().name();
	}

	static String getJob() {

		return faker.job().title();
	}
}
