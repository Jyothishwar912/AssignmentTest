package com.interview.automation.utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import com.interview.automation.supporters.PropertiesUtilities;

public class POJOSupporters {

	
	static private PropertiesUtilities prConf;
	
	
	
	
	static public PropertiesUtilities getConfObj() throws IOException {
		prConf = new PropertiesUtilities(FilePaths.confPath);
		return prConf;
	}
	
	
	
}









