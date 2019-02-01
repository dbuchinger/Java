import java.util.Scanner;
public class TriangleTester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Points point1 = new Points(0, 0);
		Points point2 = new Points(0, 5);
		Points point3 = new Points(5, 0);
		Points testPoint = new Points(0,0);
		
		System.out.println("What is the x coordinate of the test point?");
		testPoint.setX(input.nextInt());
		
		System.out.println("What is the y coordinate of the test point?");
		testPoint.setY(input.nextInt());
		
		System.out.println("The test point is at (" + testPoint.getX() + ", " + testPoint.getY() + ").");
		
		
		
	}

}
