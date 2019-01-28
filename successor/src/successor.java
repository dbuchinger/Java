public class successor {

	public static void main(String[] args) {
		
		// full pitchers
		int A = Integer.parseInt(args[0]);
		int B = Integer.parseInt(args[1]);
		int C = Integer.parseInt(args[2]);
		
		// current pitcher contents
		int a = Integer.parseInt(args[3]);
		int b = Integer.parseInt(args[4]);
		int c = Integer.parseInt(args[5]);
		
		// amount to fill
		int differenceA = A - a;
		int differenceB = B - b;
		int differenceC = C - c;
		
		empty(A, B, C, a, b, c);
		fill(A, B, C, a, b, c);
		exchange(A, B, C, a, b, c, differenceA, differenceB, differenceC);

	}
	
	public static void empty(int A, int B, int C, int a, int b, int c) {
		if (a != 0) {
			System.out.println("0 " + b + " " + c);
		}
		if (b != 0) {
			System.out.println(a + " 0 " + c);
		}
		if (c != 0) {
			System.out.println(a + " " +  b + " 0");
		}
	}
	
	public static void fill(int A, int B, int C, int a, int b, int c) {
		if (a != A) {
			System.out.println(A + " " + b + " " + c);
		}
		if (b != B) {
			System.out.println(a + " " + B + " " + c);
		}
		if (c != C) {
			System.out.println(a + " " + b + " " + C);
		}
	}
	
	public static void exchange(int A, int B, int C, int a, int b, int c, int differenceA,
			int differenceB, int differenceC) {
		// filling a
		if (a != A) {
			if (differenceA >= b)  {
				System.out.println((a + b) + " 0 " + c);
			}
			else {
				System.out.println(A + " " + (b - differenceA) + " " + c);
			}
			if (differenceA >= c)  {
				System.out.println((a + c) + " " + b + " 0");
			}
			else {
				System.out.println(A + " " + b + " " + (c - differenceA));
			}
		}
		// filling b
		if (b != B) {
			if (differenceB >= a)  {
				System.out.println("0 " + (a + b) + " " + c);
			}
			else {
				System.out.println((a - differenceB) + " " + B + " " + c);
			}
			if (differenceB >= c)  {
				System.out.println(a + " " + (b + c) + " 0");
			}
			else {
				System.out.println(a + " " + B + " " + (c - differenceB));
			}
		}
		// filling c
		if (c != C) {
			if (differenceC >= a)  {
				System.out.println("0 " + b + " " + (a + c));
			}
			else {
				System.out.println((a - differenceC) + " " + b + " " + C);
			}
			if (differenceC >= b)  {
				System.out.println(a + " 0 " + (b + c));
			}
			else {
				System.out.println(a + " " + (b - differenceC) + " " + C);
			}
		}
	}
	

}
