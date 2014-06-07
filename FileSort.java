import java.io.IOException;

public class FileSort {

	public static void main(String[] args) throws IOException {
		//HOW-TO:
		//Download a local copy of your google voice data history here: https://www.google.com/settings/takeout
		//Create a Copy of "Calls folder and name it "All" to use search utilities
		
		//Path to Voice top directory -- example: String source path = "C://Users//User//...//UsernameByDefault@gmail.com-proabblyAccessDate-takeout//Voice//
		//PATH MUST GO to the VOICE// directory
		
		String path = "C://Users//Alex//voice-takeout//Voice//";
		
		VoiceData files = new VoiceData(path);
		
		//UNCOMMENT THE LINE BELOW TO SEPARATE CALLS AND TEXTS
			files.textSeparate();
		
		//UNCOMMENT THE LINE BELOW TO SORT TEXTS BY CONTACT AND CALL TYPE (placed, received, missed, etc.)
			files.textSort();
		
		//UNCOMMENT THE LINE BELOW TO SORT TEXTS BY CONTACT
			files.callsSort();
		
		//UNCOMMENT EIHER LINE BELOW TO CONDUCT A SEARCH
			//Uncomment the first line if you wish to search for messages from multiple senders
			//Uncomment the second line if you know all or part of the senders name
				//files.textSearch("string to search");
				//files.textSearch("string to search", "sender name");
	}

}
