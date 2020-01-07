package com.selenium.automation.supporters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


/*========> Text Files
> if we want to convey a file as textfile save that file with .txt extension
> textfile are used to save data or some information
*/
public class TextUtilities1 {	
	private File file;
	private FileWriter fWriter;
	private BufferedWriter bWriter;
	private FileReader fReader;
	private BufferedReader bReader;	
	
	public TextUtilities1(String filepath) throws IOException {		
		file = new File(filepath);//to load a file java provided predefined class called file from java.io
		//====> in file class we have createewFile() i order to create a new file
		String status = (file.createNewFile())?"file created":"already exists";
		//In order to write data to a file java provided 2 predefined class called "filewriter","bufferwriter"
		System.out.println(status);
		//bufferedWriter have overloaded write ()-write(String varName), write(int varName)...etc
		fWriter = new FileWriter(file);		
		bWriter = new BufferedWriter(fWriter);		
		//to store data permanently bufferedWriter class have 1 () called flush()
		bWriter.flush();
		//In order to read data from text file java have 2 predefined class "filereader","bufferreader" from java.io
		fReader = new FileReader(file);
		bReader = new BufferedReader(fReader);
	}
	
	public void writeData(String data) throws IOException {
		Optional<BufferedWriter> opt = Optional.ofNullable(bWriter);{
			if(opt.isPresent()) {
				bWriter.write(data);
				bWriter.flush();
			}
			else {
				System.out.println("it is pointing to null");
			}
		}		
	}
	
	public void writeData(int data) throws IOException {
		Optional<BufferedWriter> opt = Optional.ofNullable(bWriter);{
			if(opt.isPresent()) {
				bWriter.write(data);
				bWriter.flush();
			}
			else {
				System.out.println("it is pointing to null");
			}
		}		
	}
	
	public void writeData(char[] data) throws IOException {
		Optional<BufferedWriter> opt = Optional.ofNullable(bWriter);
			if(opt.isPresent()) {
				bWriter.write(data);
				bWriter.flush();
			}
			else {
				System.out.println("it is pointing to null");
			}
		}	
	
	public void writeData(String[] data) throws IOException {
		Optional<BufferedWriter> opt = Optional.ofNullable(bWriter);
		if(opt.isPresent()) {
			for(String s : data) {
				bWriter.write(s);
				bWriter.flush();
			}
		}else {
			System.out.println("it is pointing to null");
		}				
	}
	
	public void writeData(List<Object> data) throws IOException {
		for(Object obj :data) {
			String s = (String) obj;
			bWriter.write(s);
			bWriter.newLine();
			bWriter.flush();			
		}
		System.out.println("written");
	}
	
	public String getSingleData() throws IOException {
		//==========> bufferReader class have different () in that readLine()-it reads one line of data and returns that in the form String
		String data = bReader.readLine();
		System.out.println(data);
		return data;
	}
	
	/*public List getFileData() throws IOException {
		List data = new ArrayList();
		//===> checks whether the data is present in file or not.if data is present returns true if not present returns false
		while(bReader.ready()) {
			String str = bReader.readLine();
			data.add(str);			
		}	
		System.out.println(data);
		return data;
	}
	
	public List getUniqueData() throws IOException {
		List withDups = getFileData();
		Set<String> uniqueData = new HashSet<String>();
		uniqueData.addAll(withDups);
		return withDups;
	}*/
	
	public List<String> getTotalFileData() throws IOException {
		List<String> fileData = new ArrayList<String>();
		
		while(bReader.ready()){
			fileData.add(bReader.readLine());
		}
		System.out.println(fileData);
		return fileData;
	}
	
	public Set<String> getTotalFileUniqueData() throws IOException{
		Set<String> UniqueData = new HashSet<String>();
		while(bReader.ready()){
			UniqueData.add(bReader.readLine());
		}
		System.out.println(UniqueData);
		return UniqueData;
		//======> console result is []/because the directly we are calling the method. the called () 
		//cannot search address as it not being called through constructor as constructor have filepath
		/*List data = getTotalFileData();
		Set data1 = new LinkedHashSet();
		data1.addAll(data);
		return data1;*/
	}
	
	public Map<Integer, String> getTotalFileDataMap() throws IOException {
		Map<Integer, String> data = new HashMap<Integer, String>();
		int count=1;
		while(bReader.ready()) {
			data.put(count, bReader.readLine());
			/*String s = bReader.readLine();
			data.put(count, s);*/
			count++;
		}
		System.out.println(data);
		return data;
	}	
	public static void main(String[] args) throws IOException {
		TextUtilities1 textUti = new TextUtilities1("D:\\Automation\\FramesworksPractice\\TestData\\testText.txt");
		//textUti.writeData("hello");			
		List<Object> list = new ArrayList<Object>();
		list.add("hello");		
		list.add("gsg");
		list.add("hiii");
		list.add("hello");
		list.add("hello");
		textUti.writeData(list);
		//textUti.getSingleData();
		/*textUti.getFileData();
		textUti.getUniqueData();*/
		//textUti.getTotalFileData();
		//textUti.getTotalFileUniqueData();
		textUti.getTotalFileDataMap();
	}

}
