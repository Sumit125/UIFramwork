package com.learnautomation.utilities;

import org.testng.annotations.DataProvider;

public class DataInput {
	
	@DataProvider(name = "testdata")
	public Object[][] testData() {
	    // Define and return the test data as a two-dimensional array
	    Object[][] data = {
	        {"1245"},
	       
	        // Add more test data as needed
	    };
	    return data;
	}

}
