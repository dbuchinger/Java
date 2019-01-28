package triangle;
import java.util.Scanner;
public class triangle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		points point1 = new points(2, 4);
		points point2 = new points(7, 3);
		points point3 = new points(4, 0);
		
		System.out.println("What is the x value of the test point?");
		int xTest = input.nextInt();
		System.out.println("What is the y value of the test point?");
		int yTest = input.nextInt();
		
		points testPoint = new points(xTest, yTest);
		
		
	}
	
	public int findLow(int point1, int point2, int point3) {
		int low = point1;
		if (point2 < low) {
			low = point2;
		}
		if (point3 < low) {
			low = point3;
		}
		return low;
	}
	
	public int findHigh(int point1, int point2, int point3) {
		int high = point1;
		if (point2 > high) {
			high = point2;
		}
		if (point3 > high) {
			high = point3;
		}
		return high;
	}

}
