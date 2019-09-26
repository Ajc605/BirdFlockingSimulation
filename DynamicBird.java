class DynamicBird extends Turtle
{
  private double speed = 1 ;

  public DynamicBird(Canvas canvas, CartesianCoordinate initLocation)
  {
		super(canvas, initLocation);
		this.flash();
	}
  //setter method for speed
  public void setSpeed(double i)
  {
    this.speed = i;
  }
  //getter method for speed
  public double getSpeed()
  {
    return speed;
  }
  //used to make the bird move in a game loop
  public void update(double time)
  {
     double distance;
     distance = (speed * time)/10;//I divided it by 10 as it was moving a bit fast
     move(distance);
     Utils.pause(5);
  }



}
