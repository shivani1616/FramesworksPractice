package com.selenium.automation.supporters;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;


public class PropertyUtilities1{
	private String filepath;
	private Properties properties;
	private FileInputStream fip;
	private String value;
	
	// =========> creating constructor
	public PropertyUtilities1(String filepath) throws IOException {
		this.filepath = filepath;
		fip = new FileInputStream(filepath);//to specify the location of file we hv predifed class called file,fileinputstream from java.io
		//we want to get the webelements 1)need to load the file 2)then we can get the web elements
		//in order to read the data from properties file java provided a predefined class called "properties"
		properties = new Properties();//created object of Properties class
		//in order to load the file properties class hv a () called load()-->when ever we call this () it loads file into java
		properties.load(fip);// 1) loaded fip	
	}	
	
		//=========> 2) in order to get the elements below are the different ways - overloading 
	//getting Single Key value.
	//in order to read the data from object repository in properties class we hv "getproperty()"
	public String getPropertyValue(String key) {
		value = properties.getProperty(key);//if key is given getproperty() gives value
		return value;
	}
	//if the we want a value and we have given key,but key is not present, then go for the below (default value)
	public String getPropertyValue(String key, String defaultValue) {
		value = properties.getProperty(key, defaultValue);
		Optional<String> data = Optional.ofNullable(value);
		if(data.isPresent()) {
			System.out.println("The value of key exist i.e : " +value);
		}else {
			//value = defaultValue;
			System.out.println("The defaultValue is: " +value);
		}
		return defaultValue;
	}
	
	//default we have elements in the form of String in Object Repository but incase if the elements are in Object to get those elements
	public String getPropertyValue(Object key) {
		value = (String) properties.get(key);// we get element in Object -> String cannot hold Parent (Object) - hence need Type casting
		return value;		
	}
	
	public String getPropertyValue(Object key, Object defaultValue) {
		value = (String) properties.getOrDefault(key, defaultValue);
		if(value == null) {
			value = (String) defaultValue;
		}
		return value;		
	}
	
	public Map<String, String> getKeysValues() {
		Map<String, String> keysValues = new LinkedHashMap<>();
		Set<Object> keys = properties.keySet();//through keyset i got all the keys in the form of object
		//System.out.println(keys);
		for(Object obj : keys) {
			String key = (String) obj;// got the keys in String by typecasting
			value = properties.getProperty(key);// as getproperty() can hold only Strings but keyset returned key in Object hence typecasted
			keysValues.put(key, value);
		}
		return keysValues;
	}
	
	public Set<String> keysSet() {
		Set<String> keysUnique = new LinkedHashSet<String>();//linkedhashset have insertion order//hashset donot have insertion order
		//properties class extends hashtable class which implements Map interface which have keyset() which gives all the keys in set 
		Set<Object> keys = properties.keySet();// keyset() return Set<Object>
		for(Object keyset :keys) {
			String keyss = (String) keyset;
			keysUnique.add(keyss);
		}
		return keysUnique;
	}	
	
	public List<String> getValues() {
		List<String> values = new ArrayList<String>();
		Set<Object> keys = properties.keySet();
		for(Object obj:keys) {
			String key = (String) obj;
			value = properties.getProperty(key);
			values.add(value);
		}		
		return values;
	}
	public void writeData(String key, String value) throws IOException {
		Map<String, String> data = new LinkedHashMap<String, String>();
		FileWriter fileWriter = new FileWriter(filepath);
		properties.setProperty(key, value);
		properties.store(fileWriter, "created");
		System.out.println("done");		

	}	
	/*public static void main(String[] args) throws IOException {
		PropertyUtilities1 prOp = new PropertyUtilities1("D:\\Automation\\FramesworksPractice\\src"
				+ "\\com\\selenium\\automation\\objectrepository\\OR_Gmail.properties");
		//getAllKeys()		
		//System.out.println(prOp.getAllKeys());
		System.out.println(prOp.keysSet());;
		prOp.writeData("1", "a");
		prOp.writeData("2", "b");
		List<String> dataValues = prOp.getValues();
		System.out.println(dataValues);
		//prOp.getPropertyValue("jerhgure", "hello");
		;
		System.out.println(prOp.keysSet());
		
		
	}	*/
	//===============================>creating a object repository file/also how to write data into properties file
	/*public static void main(String[] args) throws IOException {
		Properties prOp1 = new Properties();
		prOp1.setProperty("id","identifierId");
		FileWriter fileWriter = new FileWriter("or.properties");
		prOp1.store(fileWriter, "filecreated");
		System.out.println("done");
	}*/
}










/*import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

public class PropertyUtilities {
	private String filepath;
	private FileInputStream fip;
	private  Properties properties;
	private String value;
	
	public PropertyUtilities(String filepath) throws IOException {
		this.filepath = filepath;
		fip = new FileInputStream(filepath);
		properties = new Properties();
		properties.load(fip);	

	}
	
	public String getPropertyValue(String key) {
		value = properties.getProperty(key);
		System.out.println("The value is : " +value);
		return value;
	}
	
	public String getPropertyValue(Object key) {
		value = (String) properties.get(key);
		System.out.println("The value is : " +value);
		return value;
	}
	
	public String getPropertyValue(String key, String defaultValue) {
		value = properties.getProperty(key, defaultValue);
		Optional<String> opt = Optional.ofNullable(value);
		if(opt.isPresent())
			System.out.println("The key is present : " +value);
		else {
			value = defaultValue;
			System.out.println("The defaultValue is present : " +value);
		}		
		return value;
		
	}
	
	public String getPropertyValue(Object key, Object defaultValue) {
		value = (String) properties.getOrDefault(key, defaultValue);
		Optional<String> opt = Optional.ofNullable(value);
		if(opt.isPresent())
			System.out.println("The Value is present : " +value);
		else {
			value = (String) defaultValue;
			System.out.println("The defaultValue is present : " +value);
		}
		return value;		
	}
	
	public Set<String> getKeys() {
		Set<Object> keys = properties.keySet();
		Set<String> keyValues = new HashSet<String>();
		for(Object obj : keys) {
			value = (String) obj;
			keyValues.add(value);
		}
		return keyValues;
	}
	
	public List<String> getValues() {
		List<String> keyValues = new ArrayList();
		Set<String> keys = getKeys();
		for(String val : keys) {
			value = properties.getProperty(val);
			keyValues.add(value);
		}
		return keyValues;
	}
	
	public Map<String, String> getKeysValues(){
		Map<String, String> data = new LinkedHashMap<String, String>();
		Set<Object> keys = properties.keySet();
		for(Object obj : keys) {
			String key = (String) obj;
			value = properties.getProperty(key);
			data.put(key, value);
		}
		return data;		
	}
	
	public static void main(String[] args) throws IOException {
		PropertyUtilities prOp = new PropertyUtilities("D:\\Automation\\FramesworksPractice\\src\\com\\selenium\\"
				+ "automation\\objectrepository\\OR_Gmail.properties");
		prOp.getPropertyValue("un_id1", "DEFAULTVALUE");
		prOp.getPropertyValue("password_name");
		prOp.getPropertyValue("password_next_xpath");
		prOp.getPropertyValue("un_next_xpath");
		Map<String, String> dataValue = prOp.getKeysValues();
		System.out.println(dataValue);
	}
	
	
	
	
	

}
*/