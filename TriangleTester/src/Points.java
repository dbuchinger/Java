// class for points and their coordinates

public class Points {
	private double x;
	private double y;
	
	public Points (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String coordinates() {
		String coords = "(" + x + ", " + y + ")";
		return coords;
	}
}
