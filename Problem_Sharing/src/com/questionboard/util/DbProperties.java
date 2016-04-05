package com.questionboard.util;

import java.net.URL;
import java.util.Properties;

public class DbProperties {
	private static Properties properties;
	
	static {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL filepath = classLoader.getResource("database.props");
		PropertyUtils propertyUtils = new PropertyUtils();
		properties = propertyUtils.getProperties(filepath.getPath());
	}
	
	public static String getValue(String key) {
		String value = null;

		if(properties != null) {
			value = properties.getProperty(key);
		}
		
		return value;
	}
}
