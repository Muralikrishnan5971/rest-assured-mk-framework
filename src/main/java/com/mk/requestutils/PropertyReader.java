package com.mk.requestutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.mk.constants.ProjectConstants;
import com.mk.enums.ConfigProperty;

public class PropertyReader {

	private PropertyReader() {

	}

	private static final Properties properties = new Properties();
	private static final Map<String, String> CONFIG_MAP = new HashMap<>();

	static {

		try (FileInputStream fis = new FileInputStream(ProjectConstants.getConfigPropertiesFilePath())) {

			properties.load(fis);

		} catch (IOException exception) {

			exception.printStackTrace();

			System.exit(0);
		}

		properties.entrySet().forEach(e -> CONFIG_MAP.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));

	}

	public static String getConfigPropertyValue(ConfigProperty congifProperty) {

		return CONFIG_MAP.get(congifProperty.name().toLowerCase());
	}
}
