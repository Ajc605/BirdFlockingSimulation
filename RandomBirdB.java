class RandomBirdB extends DynamicBird
{
  public double angle;
  //cope the contrustion form DynamicBird
  public RandomBirdB(Canvas canvas, CartesianCoordinate initLocation)
  {
    super(canvas, initLocation);
    this.flash();
  }
  //getter method for I
  public double getI()
  {
    double i = Utils.randomDouble();
    return i;
  }
  //same update loop with and added random feathure
  public void update(double time)
  {
    double distance = (getSpeed() * time)/10;
    move(distance);
    double random = (Utils.randomDouble()*40) - 20;//this randomDouble is used to set teh bird to move randomly
    angle = random;
    turn(random);
  }
}
