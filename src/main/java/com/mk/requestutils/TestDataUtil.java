package com.mk.requestutils;

public class TestDataUtil {

	private TestDataUtil() {

	}

	public static String getUserName() {

		return FakerUtil.getName().toLowerCase();
	}

	public static String getUserJob() {

		return FakerUtil.getJob().toLowerCase();
	}
}
