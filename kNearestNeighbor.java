import java.util.ArrayList;
import java.util.Collections;

public class kNearestNeighbor {
	ArrayList<Vector> vectors;
	Vector base;
	Integer k;
	
	public kNearestNeighbor(Vector base, ArrayList<Vector> vectors, Integer k) {
		this.base = base;
		this.vectors = vectors;
		this.k = k;
	}
	
	/*Compute all the distances from the base to the vectors, and predict the output based on the
	most common classifier. */
	public void predictClassifier() {
		/*start by computing the distances*/
		for(Vector v : vectors) {
			v.computeDistance(base.points);
		}
		Collections.sort(vectors);
		
		for(int i = 0; i < k; i++) {
			System.out.println("Distance: " + vectors.get(i).distance + " Class: " + vectors.get(i).classifier);
		}
	}
}
