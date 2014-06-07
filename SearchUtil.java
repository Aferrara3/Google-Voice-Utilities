//NOTE THAT FOR ANY SEARCH UTIL YOU MUST HAVE A DIRECTORY "ALL" IN THE SPECIFIED PATH
//THIS FOLDER SHOULD CONTAIN THE CONTENTS OF THE ORIGINAL "CALLS" FOLDER
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchUtil {

	String path="";
	
	public SearchUtil(String pathi){
		path = pathi;
	}
	
	public void textSearch(String str) throws IOException{
		System.out.println("Searching. Please waiy, this might take a minute. . .");
		String sourcepath = path + "All//";	

		File folder = new File(sourcepath);
		File[] listOfFiles = folder.listFiles();
		String[] files = new String[listOfFiles.length];
		List<String> texts = new ArrayList<String>();
		int counter = 0;
		
		for (int i = 0; i < listOfFiles.length; i++){
			counter=0;
			if (listOfFiles[i].isFile()){
			files[i] = listOfFiles[i].getName();
		    if (files[i].contains("- Text -")){
		    texts.add(files[i]);
		        	
		    BufferedReader br = new BufferedReader(new FileReader(listOfFiles[i]));
		    String line;
		    while ((line = br.readLine()) != null) {
		    	counter++;
		     	if (line.contains(str)){
		     		System.out.println("");
		     		System.out.println(listOfFiles[i].getName());
		     		System.out.println("line "+counter+": "+line );		
		     	}
		    }
		    br.close();
		        	 
		    }		                
			}
		}
		 
	}
	
	public void textSearch(String str, String name) throws IOException{
		String sourcepath = path + "All//";	
		
		File folder = new File(sourcepath);
		File[] listOfFiles = folder.listFiles();
		String[] files = new String[listOfFiles.length];
		List<String> texts = new ArrayList<String>();
		int counter = 0;
		
		for (int i = 0; i < listOfFiles.length; i++){
			counter=0;
			if (listOfFiles[i].isFile()){
			files[i] = listOfFiles[i].getName();
		    if (files[i].contains("- Text -")){
		    texts.add(files[i]);
		    String sender=files[i].split(" - ")[0];
		    
		    BufferedReader br = new BufferedReader(new FileReader(listOfFiles[i]));
		    String line;
		    while ((line = br.readLine()) != null) {
		    	counter++;
		     	if (line.contains(str) && sender.contains(name)){
		     		System.out.println("");
		     		System.out.println(listOfFiles[i].getName());
		     		System.out.println("line "+counter+": "+line );		
		     	}
		    }
		    br.close();
		        	 
		    }		                
			}
		}
		System.out.println("Search Complete! Append desired filename to ...\\All\\ to open the respective file");		
	}
	
	
	
}

/* Basic Sytax for Reading Contents of a File

BufferedReader br = new BufferedReader(new FileReader(file));
String line;
while ((line = br.readLine()) != null) {
   // process the line.
}
br.close();

*/
