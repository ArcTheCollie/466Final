import java.util.ArrayList;
import java.util.List; 

public class Vector implements Comparable<Vector> {
	ArrayList<Double> points;
	Double classifier;
	Double distance;
	
	public Vector(List<Double> dataRow) {
		this.points = new ArrayList<Double>();
		for(int i = 0; i < dataRow.size() - 2; i ++) {
			points.add(dataRow.get(i));
		}
		classifier = dataRow.get(dataRow.size() - 1);
	}
	
	/*Write a function that takes in a vector and returns the distance.*/
	public void computeDistance(ArrayList<Double> vectorB) {
		if(vectorB.size() != points.size())
			System.out.println("Something is wrong with the vector sizes.");
		Double dist = 0.0;
		for(int i = 0; i < points.size(); i++) {
			dist += Math.pow(points.get(i) - vectorB.get(i), 2);
		}
		distance = Math.sqrt(dist);
	}
	
	/*Implement a comparator on distance*/
	@Override
	public int compareTo(Vector o) {
		// TODO Auto-generated method stub
		return this.distance.compareTo(o.distance);
	}
}
