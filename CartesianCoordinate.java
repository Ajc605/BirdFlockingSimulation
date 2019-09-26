class CartesianCoordinate
{
	//Lines 1-11 was given to me in Lab3 on pages 2
	public double xPosition;
	public double yPosition;

	public CartesianCoordinate(double x, double y)
	{
		this.xPosition = x;
		this.yPosition = y;
	}
  //getter method for x position
	public double getX()
	{
		return this.xPosition;
	}
	//getter meathod for y position
	public double getY()
	{
		return this.yPosition;
	}
	//setter meathod for x positon
	public void setX(double x)
	{
		this.xPosition = x;
	}
	//setter meathod for y position
	public void setY(double y)
	{
		this.yPosition = y;
	}
	//chnages the x and y positions 
	public void add(double dx, double dy)
	{
		this.xPosition += dx;
		this.yPosition += dy;
	}

}
