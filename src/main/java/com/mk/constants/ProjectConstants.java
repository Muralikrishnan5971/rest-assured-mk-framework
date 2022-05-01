package com.mk.constants;

import lombok.Getter;

public final class ProjectConstants {

	private ProjectConstants() {

	}

	private static final String RESOURCE = System.getProperty("user.dir");

	private static @Getter String configPropertiesFilePath = RESOURCE + "/src/test/resources/propertiesfile/config.properties";
	private static @Getter String resposeSchemaFilePath = "schema/responseSchema.json";

}
