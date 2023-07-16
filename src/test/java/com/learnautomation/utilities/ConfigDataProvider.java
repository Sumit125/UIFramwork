package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() throws IOException {
		File src = new File("./Config/config.properties");
		FileInputStream ip = new FileInputStream(src);
		pro = new Properties();
		pro.load(ip);
	}

	public String getdatafromConfig(String key) {
	
		return pro.getProperty(key);

	}

}