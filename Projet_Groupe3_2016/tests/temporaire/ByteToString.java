package temporaire;

public class ByteToString {
	
	public static String byteToString(byte[] bArray){
		String file_string = "";

	    for(int i = 0; i < bArray.length; i++)
	    {
	        file_string += (char)bArray[i];
	    }

	    return file_string;    
	  }

}
