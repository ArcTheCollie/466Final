import java.util.ArrayList;

import javax.xml.crypto.Data;

/*This is a test.*/

public class FinalProject {
	
	/*this function takes in user input, creating and returning the base vector*/
	static Vector createUserInput() {
		return null;
	}
	
	/*this function will take the initial data and pre-process, changing all the lists to 
	 * vectors and get it ready for the algorithm*/
	static void preprocess() {
		
	}
	
	/*This function will take in a file name and store the data to a 2-d list;*/
	static void parseData(String filename) {
		ArrayList<ArrayList<Integer>> dataRows = new ArrayList<ArrayList<Integer>>();
	}
	
	public static void main(String[] args) {
		parseData("temp");
		preprocess();
		Vector base = createUserInput();
		kNearestNeighbor knn = new kNearestNeighbor(base, testingData, k);
	}
}
