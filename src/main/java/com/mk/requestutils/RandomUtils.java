package com.mk.requestutils;

public class RandomUtils {

	private RandomUtils() {

	}

	public static String getUserName() {

		return FakerUtils.getName().toLowerCase();
	}

	public static String getUserJob() {

		return FakerUtils.getJob().toLowerCase();
	}
}
