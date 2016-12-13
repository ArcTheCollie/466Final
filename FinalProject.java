import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*This is a test.*/

public class FinalProject {
	static Vector userSpam = new Vector(Arrays.asList(0.0, 2.0, 2.0, 15.2361723, 1.0));
	static Vector userHam = new Vector(Arrays.asList(1.0, 0.0, 0.0, 15.2361723, 0.0));
	static ArrayList<Vector> testingData = new ArrayList<Vector>();
	
	/*This function will take in a file name and store the data to a 2-d list;*/
	static void parseData(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
		    
			String line;
		    String[] tokens;
		    ArrayList<Double> temp;
		    
		    while ((line = br.readLine()) != null) {
		    	temp = new ArrayList<Double>();
		    	tokens = line.split(",");
		    	System.out.println(tokens);
		    	for(String s : tokens) {
		    		temp.add(Double.parseDouble(s));
		    	}
		    	testingData.add(new Vector(temp));
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		parseData("input.csv");
		kNearestNeighbor knn = new kNearestNeighbor(userHam, testingData, 9);
		knn.predictClassifier();
	}
}
