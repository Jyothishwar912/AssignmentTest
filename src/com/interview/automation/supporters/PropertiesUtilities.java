package com.interview.automation.supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtilities {

	static private String filePath;
	private FileInputStream fip;
	private Properties properties;
	private String value;
	
	public PropertiesUtilities(String filePath) throws IOException {
		super();
		this.filePath = filePath;
		fip = new FileInputStream(filePath);
		properties = new Properties();
		properties.load(fip);
	}

	public String getPropertyValue(String key)
	{
		value = properties.getProperty(key);
		return value;
	}
	
	public String getPropertyValue(Object key)
	{
		value = (String) properties.get(key);
		return value;
	}
	
	public String getPropertyValue(String key,String defaultValue)
	{
		value = properties.getProperty(key,defaultValue);
		Optional<String> optional = Optional.ofNullable(value);
		if (optional.isPresent()) 
			;
		else
			value = defaultValue;
		/*if(value == null){
			value = defaultValue;
		}*/
		return value;
	}
	public String getPropertyValue(Object key,Object defaultValue)
	{
		value = (String) properties.getOrDefault(key,defaultValue);
		if(value == null){
			value = (String) defaultValue;
		}
		return value;
	}
	
	public Map<String, String> getTotalData(){
		Map<String, String> data = new HashMap<String, String>();
		
		Set setKeys = properties.keySet();
		for(Object obj : setKeys)
		{
			//String value = (String) properties.get(obj);
			String key = (String) obj;
			String value = properties.getProperty(key);
			data.put(key, value);
		}
		return data;
	}
	
	public Set<String> getKeys(){
		Set<Object> keys = properties.keySet();
		Set<String> keysUniq = new HashSet<String>();
		for(Object obj : keys){
			String key = (String) obj;
			keysUniq.add(key);
		}
		return keysUniq;
	}
	 
	public List<String> getValues(){
		List<String> keys = new ArrayList<String>();
		Set<String> keys1 = getKeys();
		for(String key : keys1){
			String value = properties.getProperty(key);
			keys.add(value);
		}
		return keys;
	}	
}
