package paquet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Doublet {
	public String parentHash = null;
	public ArrayList<String> filsHash = null;
	
	public Doublet(String pH, ArrayList<String> fH){
		this.parentHash = pH;
		this.filsHash = fH;
	}
	
	public ArrayList<String> getListeFils(){
		return filsHash;
	}
	
	public String getParent(){
		return parentHash;
	}

}
