package projet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
	}
}


ListeFils lst = new ListeFils();
for (int k=0; k <lst.truc.size(); k++){

	try {
		BufferedInputStream oos =new BufferedInputStream(new FileInputStream(lst.truc.get(k)));
		System.out.println(oos);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}