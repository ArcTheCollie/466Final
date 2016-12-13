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
      kNearestNeighbor knn;
		
		// kNearestNeighbor knn = new kNearestNeighbor(userHam, trainingData, 9);
		// String result = (knn.predictClassifier() == 1) ? "Spam" : "Not Spam";
		//System.out.println("This review is " + result);
		
		for(int k = 1; k <= 99; k+= 2) {
			int numCorrect = 0;
         int tp, fp, fn, tn;

         tp = fp = fn = tn = 0;

         knn = new kNearestNeighbor(trainingData, k);
			for(Vector v : testingData) {
            double expected = v.classifier;
            double actual = knn.predictClassifier(v);

            if (expected == 1) {
               if (actual == 0) {
                  // False Negative
                  ++fn;
               } else {
                  // True Positive
                  ++tp;
               }
            } else {
               if (actual == 0) {
                  // True Negative
                  ++tn;
               } else {
                  // False Positive
                  ++fp;
               }
            }
			}

         System.out.println("Ran the test suite with k = " + k + " on " + testingData.size() + " entries with " + trainingData.size() + " known values:");
         System.out.println("True Positive: " + tp);
         System.out.println("False Positive: " + fp);
         System.out.println("False Negative: " + fn);
         System.out.println("True Negative: " + tn);
		}
	}
}
