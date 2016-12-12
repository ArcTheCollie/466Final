import java.util.ArrayList;

public class Vector implements Comparable<Vector> {
	ArrayList<Integer> points;
	Integer classifier;
	Double distance;
	
	public Vector(ArrayList<Integer> dataRow) {
		this.points = new ArrayList<Integer>();
		for(int i = 0; i < dataRow.size() - 2; i ++) {
			points.add(dataRow.get(i));
		}
		classifier = dataRow.get(dataRow.size() - 1);
	}
	
	/*Write a function that takes in a vector and returns the distance.*/
	public void computeDistance(ArrayList<Integer> vectorB) {
		
	}
	
	/*Implement a comparator on distance*/
	@Override
	public int compareTo(Vector o) {
		// TODO Auto-generated method stub
		return this.distance.compareTo(o.distance);
	}
}
