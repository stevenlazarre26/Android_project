import java.io.*;
import java.util.*;

public class main {

	private Scanner x;
	
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
			String b = x.next();
			String c = x.next();
			String d = x.next();
			
			System.out.printf("%s %s %s",a,b,c,d);
		}
	}
	public void closeFile(){
		x.close();
		
	}
	
}
