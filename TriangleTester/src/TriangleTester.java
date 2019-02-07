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
		Points testPoint = new Points(1,3);
		
		Points highPoint = point1;
		Points lowPoint = point1;
		Points leftPoint = point1;
		Points rightPoint = point1;
		
		Points givenPoints[] = {point1, point2, point3};
		
//		for (int i = 0; i < givenPoints.length; i++) {
//			System.out.println("point" + (i + 1) + ":" + givenPoints[i].coordinates());
//		}
		
		for (int i = 0; i < givenPoints.length; i++) {
			System.out.println("\nStart\nCurrent high point: " + highPoint.coordinates());
			System.out.println("Current low point: " + lowPoint.coordinates());
			System.out.println("Current left point: " + leftPoint.coordinates());
			System.out.println("Current right point: " + rightPoint.coordinates());
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
			System.out.println("\nEnd\nCurrent high point: " + highPoint.coordinates());
			System.out.println("Current low point: " + lowPoint.coordinates());
			System.out.println("Current left point: " + leftPoint.coordinates());
			System.out.println("Current right point: " + rightPoint.coordinates());
		}
		
		
		/*
		System.out.println("What is the x coordinate of the test point?");
		testPoint.setX(input.nextInt());
		
		System.out.println("What is the y coordinate of the test point?");
		testPoint.setY(input.nextInt());
		
		System.out.println("The test point is at (" + testPoint.getX() + ", " + testPoint.getY() + ").");
		*/
		
		Line line1 = null;
		Line line2 = null;
		Line line3 = null;
		Line line4 = null;
		
		if (leftPoint.getY() > testPoint.getY()) {
			line1 = new Line(leftPoint, lowPoint);
		}
		else if (leftPoint.getY() <= testPoint.getY()) {
			line1 = new Line(leftPoint, highPoint);
		}
		
		if (rightPoint.getY() > testPoint.getY()) {
			line2 = new Line(rightPoint, lowPoint);
		}
		else if (rightPoint.getY() <= testPoint.getY()) {
			line2 = new Line(rightPoint, highPoint);
		}
		if (highPoint.getX() > testPoint.getX()) {
			line3 = new Line(highPoint, leftPoint);
		}
		else if (highPoint.getX() <= testPoint.getX()) {
			line3 = new Line(highPoint, rightPoint);
		}
		if (lowPoint.getX() > testPoint.getX()) {
			line4 = new Line(lowPoint, leftPoint);
		}
		else if (lowPoint.getX() <= testPoint.getX()) {
			line4 = new Line(lowPoint, rightPoint);
		}
		
		
		/*
		if ((posXBound == true) && (negXBound == true) && (posYBound == true) && (negYBound == true)) {
			System.out.print("It's in the triangle");
		}
		else {
			System.out.print("It's not in the triangle");
		}
		*/
		
		negXBound(line1, testPoint);
		negXBound(line2, testPoint);
		
		System.out.println("\nBounded left: " + negXBound + "\nBounded right: " + posXBound);
		
		
	}
	
	public static void negXBound (Line line, Points testPoint) {
		double check1 = line.getXStart() + (testPoint.getX() - line.getXStart()) * (1/line.getSlope());
		if (check1 <= testPoint.getX()) {
			negXBound = true;
		}
		if (check1 >= testPoint.getX()) {
			posXBound = true;
		}
	}
	
	/*
	public static void negXBound (Line line, Points testPoint) {
		double check1 = (testPoint.getX() - line.getXStart()) * line.getLine() + line.getYStart();
		if (check1 <= testPoint.getX()) {
			negXBound = true;
		}
		if (check1 >= testPoint.getX()) {
			posXBound = true;
		}
	}
	 */	
}
