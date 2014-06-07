import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class VoiceData {
	
	String path="";
		 
	public VoiceData(String pathi){
		path = pathi;
	}
	
	public void textSeparate(){
		System.out.println("");
		System.out.println("Separating Calls from Texts");
	    System.out.println( ". . ." );
    
		String sourcepath = path + "Calls//";	
		String targetpath = path + "Texts//";	
		File bfile = new File(targetpath);
    	bfile.mkdirs();
		File folder = new File(sourcepath);
		File[] listOfFiles = folder.listFiles();
		String[] files = new String[listOfFiles.length];
		List<String> texts = new ArrayList<String>();
		    
		 for (int i = 0; i < listOfFiles.length; i++){
			 if (listOfFiles[i].isFile()){
				 files[i] = listOfFiles[i].getName();
		                
		         	if (files[i].contains("- Text -")){
		         		texts.add(files[i]);
		         	}		                
			 }
		 }
		    
		 int movecount=0;
		 for (int i = 0; i < texts.size(); i++){ 
			 File  afile = new File(sourcepath+texts.get(i));
			 afile.renameTo(new File(targetpath+texts.get(i)));
			 movecount++;
		 }
		 System.out.println("Success! Texts Migration Complete");
		 System.out.println(movecount + " Files Moved of " + texts.size() + " Expected");
	}
		
	public void textSort(){

		System.out.println("");
		System.out.println("Sorting Texts");
	    System.out.println( ". . ." );
	    
		String pathWithName = path + "Texts";	
		int foldersCreated=0;
		
		 File folder = new File(pathWithName);
		 File[] listOfFiles = folder.listFiles();
		 String[] files = new String[listOfFiles.length];
		 List<String> names = new ArrayList<String>();
		    
		 for (int i = 0; i < listOfFiles.length; i++){
		     if (listOfFiles[i].isFile()){
		    	 files[i] = listOfFiles[i].getName();
		         String name = files[i].split(" - ")[0];
		         String sourcepath=pathWithName+"//"+files[i];
		         String targetpath=pathWithName+"//"+name+"//"+files[i];
		         File bfile = new File(pathWithName+"//"+name);
	             bfile.mkdirs();
		                
	             if (i==0 || !names.get(names.size()-1).equals(name)){
	            	 foldersCreated++;
		         }
		         names.add(name);
		         File afile = new File(sourcepath);
		         afile.renameTo(new File(targetpath));
	                					                	
		     }
		                	
		 }
		 System.out.println("Success! Texts Sorting Complete");
		 System.out.println(foldersCreated + " Folders Created of " + foldersCreated + " Unique Contacts Identified");
	}

	
	//FOR TESTING PURPOSES TO RESOLVE ISSUE OF FILENAMES TOO LONG TO DELETE
	public void renameForDelete(){

		String path2 = path + "Texts//";	
		
		File folder = new File(path2);
		File[] listOfFiles = folder.listFiles();
		String[] files = new String[listOfFiles.length];
		    		    
		for (int i = 0; i < listOfFiles.length; i++){
			if (listOfFiles[i].isFile()){
				files[i] = listOfFiles[i].getName();
		               
				File  afile = new File(path2+files[i]);
		        afile.renameTo(new File(path2+i));
			}
		}
	}

    /* 
    
    //Name
    files[i].split(" - ")[0])
    //"Received, Placed, Missed ...etc
    files[i].split(" - ")[1]);
    //Date YYYY-MM-DDT...
    files[i].split(" - ")[2])
    
   */
	public void callsSort(){
		System.out.println("");
		System.out.println("Sorting Calls");
	    System.out.println( ". . ." );
		String pathWithName = path + "Calls";	
		int foldersCreated=0;
		
		 File folder = new File(pathWithName);
		 File[] listOfFiles = folder.listFiles();
		 String[] files = new String[listOfFiles.length];
		 List<String> names = new ArrayList<String>();
		    
		 for (int i = 0; i < listOfFiles.length; i++){
			 if (listOfFiles[i].isFile()){
				 files[i] = listOfFiles[i].getName();
		         String name = files[i].split(" - ")[0];
		         String type = files[i].split(" - ")[1];
		         String sourcepath=pathWithName+"//"+files[i];
		         String targetpath=pathWithName+"//"+name+"//"+type+"//"+files[i];
		                
		         File bfile = new File(pathWithName+"//"+name+"//"+type);
	             bfile.mkdirs();
		                
	             if (i==0 || !names.get(names.size()-1).equals(name)){
	            	 foldersCreated++;
	             }
	             names.add(name);
		         File afile = new File(sourcepath);
		         afile.renameTo(new File(targetpath));
	                					                	
			 }
		 }
		 System.out.println("Success Call Sorting Complete");
		 System.out.println(foldersCreated + " Folders Created of " + foldersCreated + " Unique contacts identified");
	}

	public void textSearch(String str) throws IOException{
	SearchUtil search = new SearchUtil(path);
	search.textSearch(str);
	}
	public void textSearch(String str, String name) throws IOException{
		SearchUtil search = new SearchUtil(path);
		search.textSearch(str, name);
	}
}
