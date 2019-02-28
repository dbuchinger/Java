// Derek Buchinger 2/28/19

import java.util.Scanner;
public class TriangleTester {

	static boolean posXBound = false;
	static boolean negXBound = false;
	static boolean posYBound = false;
	static boolean negYBound = false;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// initialize triangle and the point to be tested
		Points point1 = new Points(-3, -3);
		Points point2 = new Points(-5, -5);
		Points point3 = new Points(-3, -5);
		Points testPoint = new Points(-3, -4);
		
		// get the three lines formed by the points and check whether or not they bound the point in all directions
		Line line1 = new Line(point1, point2);
		Line line2 = new Line(point2, point3);
		Line line3 = new Line(point3, point1);
		
		xBound(line1, testPoint);
		xBound(line2, testPoint);
		xBound(line3, testPoint);
		yBound(line1, testPoint);
		yBound(line2, testPoint);
		yBound(line3, testPoint);
		
		// results statements based on if all bound booleans are true or not
		if ((posXBound == true) && (negXBound == true) && (posYBound == true) && (negYBound == true)) {
			System.out.print("It's in the triangle");
		}
		else {
			System.out.print("It's not in the triangle");
		}
		
	}
	
	// method for checking the positive and negative x bounds of the test point
	public static void xBound (Line line, Points testPoint) {
		double check = 0;
		double right = line.getXStart();
		double left = line.getXStart();
		if (line.getXEnd() > right) {
			right = line.getXEnd();
		}
		if (line.getXEnd() < left) {
			left = line.getXEnd();
		}
		
		if (line.getXDifference() == 0) {
			check = line.getXStart();
		}
		else {
			check = line.getXStart() + ((testPoint.getY() - line.getYStart()) / line.getSlope());
		}
		
		if (!((check >= left) && (check <= right))) {
			return;
		}
		
		if (check <= testPoint.getX()) {
			negXBound = true;
		}
		if (check >= testPoint.getX()) {
			posXBound = true;
		}
	}
	
	// method for checking the positive and negative y bounds of the test point
	public static void yBound (Line line, Points testPoint) {
		double check = 0;
		double high = line.getYStart();
		double low = line.getYStart();
		if (line.getYEnd() > high) {
			high = line.getXEnd();
		}
		if (line.getYEnd() < low) {
			low = line.getXEnd();
		}
		if (line.getXDifference() == 0) {
			check = line.getXStart();
		}
		else {
			check = line.getYStart() + ((testPoint.getX() - line.getXStart()) * line.getSlope());
		}
		
		if (!((check >= low) && (check <= high))) {
			return;
		}
		
		if (check <= testPoint.getY()) {
			negYBound = true;
		}
		if (check >= testPoint.getY()) {
			posYBound = true;
		}
	}
	
}
