class LineSegment
{
	CartesianCoordinate startPoint;
	CartesianCoordinate endPoint;
	//takes two CartesianCoordinate and sets them for the lrest of the class
	public LineSegment( CartesianCoordinate start , CartesianCoordinate end)
	{
		this.startPoint = start;
		this.endPoint = end;
	}
	//used ro]]to return start point
	public String getStartPoint()
	{
		String getStart;
		getStart = (this.startPoint.xPosition + "," + this.startPoint.yPosition);
		return getStart;
	}
	//used to return end point
	public String getEndPoint()
	{
		String getEnd;
		getEnd = (this.endPoint.xPosition + "," + this.endPoint.yPosition);
		return getEnd;
	}
	//used to find teh length of between the two CartesianCoordinate given
	public double Length( CartesianCoordinate start, CartesianCoordinate end)
	{
		this.startPoint = start;
		this.endPoint = end;
		double x = start.xPosition - end.xPosition;
		double y = start.yPosition - end.yPosition;
		double x_abs = Math.abs(x);
		double y_abs = Math.abs(y);
		double x_sqrd = Math.pow( x_abs, 2);
		double y_sqrd = Math.pow( y_abs, 2);
		double length = Math.sqrt(x_sqrd + y_sqrd);
		return length;
	}
}
