// class for the line formed by two points and its slope

public class Line {
	
	private double slope;
	private double xStart;
	private double yStart;
	private double xEnd;
	private double yEnd;
	private double xDifference;
	
	public Line (Points point1, Points point2) {
		this.xStart = point1.getX();
		this.yStart = point1.getY();
		this.xEnd = point2.getX();
		this.yEnd = point2.getY();
		this.xDifference = point2.getX() - point1.getX();
	}
	

	public double getSlope() {
		slope = (yEnd-yStart)/(xEnd-xStart);
		return slope;
	}
	
	public double getXStart() {
		return xStart;
	}
	public double getYStart() {
		return yStart;
	}
	public double getXEnd() {
		return xEnd;
	}
	public double getYEnd() {
		return yEnd;
	}
	public double getXDifference() {
		return xDifference;
	}
}
