package temporaire;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class Decompression {
	
	public static byte[] decompress(byte[] data) throws IOException, DataFormatException {  

		Inflater inflater = new Inflater();   
		inflater.setInput(data);  
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);  
		byte[] buffer = new byte[1024];  
		while (!inflater.finished()) {  
			int count = inflater.inflate(buffer);  
			outputStream.write(buffer, 0, count);  
		}  
		
		outputStream.close();  
		byte[] output = outputStream.toByteArray();  
		
		return output;  

	}
	
	public static byte[] LireFichier(String Chemin) throws IOException {
		File fichier = new File(Chemin);
		int length = (int) fichier.length();
		byte[] data = new byte[length];
		@SuppressWarnings("resource")
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(fichier));
		in.read(data, 0, length);
		 
		return data;
	}
	
	
}
