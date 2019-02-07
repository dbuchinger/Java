public class Line {
	
	private double slope;
	private int xStart;
	private int yStart;
	private int xEnd;
	private int yEnd;
	private int xDifference;
	
	public Line (Points point1, Points point2) {
		this.xStart = point1.getX();
		this.yStart = point1.getY();
		this.xEnd = point2.getX();
		this.yEnd = point2.getY();
	}
	

	public double getSlope() {
		slope = (yEnd-yStart)/(xEnd-xStart);
		return slope;
	}
	
	public int getXStart() {
		return xStart;
	}
	public int getYStart() {
		return yStart;
	}
	public int getXEnd() {
		return xEnd;
	}
	public int getYEnd() {
		return yEnd;
	}
}
