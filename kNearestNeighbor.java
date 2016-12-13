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
	public double predictClassifier() {
		/*start by computing the distances*/
		for(Vector v : vectors) {
			v.computeDistance(base.points);
		}
		Collections.sort(vectors);
		
		Double classifier = 0.0;
		for(int i = 0; i < k; i++) {
			if(vectors.get(i).classifier == 1.0)
				classifier += 1;
		}
		
		return (classifier >= (k/2)) ? 1.0 : 0.0;
	}
}
