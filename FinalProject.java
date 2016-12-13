import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/*This is a test.*/

public class FinalProject {
	static Vector userSpam = new Vector(Arrays.asList(0.0, 2.0, 2.0, 15.2361723, 1.0));
	static Vector userHam = new Vector(Arrays.asList(1.0, 0.0, 0.0, 15.2361723, 0.0));
	static ArrayList<Vector> Data = new ArrayList<Vector>();
	
	/*This function will take in a file name and store the data to a 2-d list;*/
	static void parseData(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
		    
			String line;
		    String[] tokens;
		    ArrayList<Double> temp;
		    
		    while ((line = br.readLine()) != null) {
		    	temp = new ArrayList<Double>();
		    	tokens = line.split(",");
		    	for(String s : tokens) {
		    		temp.add(Double.parseDouble(s));
		    	}
		    	Data.add(new Vector(temp));
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
		Collections.shuffle(Data, new Random(13));
		ArrayList<Vector> trainingData = new ArrayList<Vector>(Data.subList(0, (Data.size() / 3 * 2)));
		ArrayList<Vector> testingData = new ArrayList<Vector>(Data.subList((Data.size() / 3 * 2), Data.size() - 1));
		
		kNearestNeighbor knn = new kNearestNeighbor(userHam, trainingData, 9);
		String result = (knn.predictClassifier() == 1) ? "Spam" : "Not Spam";
		//System.out.println("This review is " + result);
		
		for(int k = 1; k <= 99; k+= 2) {
			int numCorrect = 0;
			for(Vector v : testingData) {
				knn = new kNearestNeighbor(v, trainingData, k);
				if(knn.predictClassifier() == v.classifier)
					numCorrect += 1;
			}
			System.out.println("With k = " + k + 
							   " the program had " + numCorrect + 
							   " out of " + testingData.size() + " correct.");
		}
	}
}
