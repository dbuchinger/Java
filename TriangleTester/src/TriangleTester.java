import java.util.Scanner;
public class TriangleTester {

	static boolean posXBound = false;
	static boolean negXBound = false;
	static boolean posYBound = false;
	static boolean negYBound = false;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Points point1 = new Points(2, 2);
		Points point2 = new Points(3, 5);
		Points point3 = new Points(4, 3);
		Points testPoint = new Points(2, 3);
		
		Points highPoint = point1;
		Points lowPoint = point1;
		Points leftPoint = point1;
		Points rightPoint = point1;
		
		Points givenPoints[] = {point1, point2, point3};
		
//		for (int i = 0; i < givenPoints.length; i++) {
//			System.out.println("point" + (i + 1) + ":" + givenPoints[i].coordinates());
//		}
		
		for (int i = 0; i < givenPoints.length; i++) {
			if (givenPoints[i].getX() < leftPoint.getX()) {
				leftPoint = givenPoints[i];
			}
			if (givenPoints[i].getX() > rightPoint.getX()) {
				rightPoint = givenPoints[i];
			}
			if (givenPoints[i].getY() < leftPoint.getY()) {
				lowPoint = givenPoints[i];
			}
			if (givenPoints[i].getY() > highPoint.getY()) {
				highPoint = givenPoints[i];
			}
		}
		
		
		
		System.out.println("\nCurrent high point: " + highPoint.coordinates());
		System.out.println("Current low point: " + lowPoint.coordinates());
		System.out.println("Current left point: " + leftPoint.coordinates());
		System.out.println("Current right point: " + rightPoint.coordinates()); 
		 /*
		System.out.println("What is the x coordinate of the test point?");
		testPoint.setX(input.nextInt());
		
		System.out.println("What is the y coordinate of the test point?");
		testPoint.setY(input.nextInt());
		
		System.out.println("The test point is at (" + testPoint.getX() + ", " + testPoint.getY() + ").");
		*/
		
		Line leftLine = null;
		Line rightLine = null;
		Line highLine = null;
		Line lowLine = null;
		
		if (leftPoint.getY() > testPoint.getY()) {
			leftLine = new Line(leftPoint, lowPoint);
		}
		else if (leftPoint.getY() <= testPoint.getY()) {
			leftLine = new Line(leftPoint, highPoint);
		}
		
		if (rightPoint.getY() > testPoint.getY()) {
			rightLine = new Line(rightPoint, lowPoint);
		}
		else if (rightPoint.getY() <= testPoint.getY()) {
			rightLine = new Line(rightPoint, highPoint);
		}
		if (highPoint.getX() > testPoint.getX()) {
			highLine = new Line(highPoint, leftPoint);
		}
		else if (highPoint.getX() <= testPoint.getX()) {
			highLine = new Line(highPoint, rightPoint);
		}
		if (lowPoint.getX() > testPoint.getX()) {
			lowLine = new Line(lowPoint, leftPoint);
		}
		else if (lowPoint.getX() <= testPoint.getX()) {
			lowLine = new Line(lowPoint, rightPoint);
		}
		
		Line line1 = new Line(point1, point2);
		Line line2 = new Line(point2, point3);
		Line line3 = new Line(point3, point1);
		
		
		
		
		/*
		if ((posXBound == true) && (negXBound == true) && (posYBound == true) && (negYBound == true)) {
			System.out.print("It's in the triangle");
		}
		else {
			System.out.print("It's not in the triangle");
		}
		*/
		
		xBound(line1, testPoint);
		xBound(line2, testPoint);
		xBound(line3, testPoint);
		yBound(line1, testPoint);
		yBound(line2, testPoint);
		yBound(line3, testPoint);
		
		System.out.println("\nBounded left: " + negXBound + "\nBounded right: " + posXBound);
		System.out.println("\nBounded low: " + negYBound + "\nBounded high: " + posYBound);
		
		
	}
	
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
		
		//System.out.println(check);
		
		if (check <= testPoint.getX()) {
			negXBound = true;
		}
		if (check >= testPoint.getX()) {
			posXBound = true;
		}
	}
	
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
		
		System.out.println(check);
		
		if (check <= testPoint.getY()) {
			negYBound = true;
		}
		if (check >= testPoint.getY()) {
			posYBound = true;
		}
	}
	
	/*
	public static void negXBound (Line line, Points testPoint) {
		double check = (testPoint.getX() - line.getXStart()) * line.getLine() + line.getYStart();
		if (check <= testPoint.getX()) {
			negXBound = true;
		}
		if (check >= testPoint.getX()) {
			posXBound = true;
		}
	}
	 */	
}
