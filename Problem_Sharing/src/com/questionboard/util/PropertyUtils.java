package com.questionboard.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
	
	public Properties getProperties(String filename) {
		Properties properties = new Properties();
		InputStream inputStream = null;

		try {
			inputStream = new FileInputStream(filename);
			properties.load(inputStream);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;
	}
}
