import java.io.*;
import java.util.*;
import java.util.regex.*;

public class file {

	private Scanner x;
	int count = 0;
	
	public void openFile (){
		
		try {
			x= new Scanner(new File ("data.txt"));
		}
		
		catch(Exception e){
			System.out.println("could not find file");
		}
	}
	
	public void readFile(){
		
		while(x.hasNext()){
			String a = x.next();
			
			regexChecker("[0-9]{1,1}",a);
		}
	}

	public void regexChecker(String theRegex, String str2check){
		
		Pattern checkRegex= Pattern.compile(theRegex);
		
		Matcher regexMatcher= checkRegex.matcher(str2check);
		
	
		while(regexMatcher.find()){
			if(regexMatcher.group().length()!=0){
				count++;
			}
		}
	}
	
	public void closeFile(){
		System.out.println("This document contains "+count+" integers.");
		x.close();
	}
}