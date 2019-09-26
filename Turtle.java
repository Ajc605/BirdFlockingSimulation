
import javax.swing.*;
class Turtle
{
    private Canvas canvas; // private field reference to a canvas object
    private CartesianCoordinate myLocation;
    private CartesianCoordinate initlocation;
    private double angle_amount;
    private boolean penUse;
    double angle;

    public Turtle(Canvas canvas)
    {
      this.canvas = canvas;
      penUse = true;
      myLocation = initlocation;
    }

    public Turtle(Canvas canvas, CartesianCoordinate initlocation)
    {
      this.canvas = canvas;
      penUse = true;
      angle = 0;
      myLocation = initlocation;

    }

    public void PenUp()
    {
        penUse = false;
    }

    public void PenDown()
    {
        penUse = true;
    }

    public void turn(double angle_amount)
    {
      angle = angle + angle_amount;
    }

    public void move(double pixels)
    {
        double radians = Math.toRadians(angle);
        double dx = pixels * Math.sin(radians);
        double dy = pixels * Math.cos(radians);
        CartesianCoordinate oldLocation = new CartesianCoordinate(myLocation.getX(), myLocation.getY());
        myLocation.add(dx, dy);
        if (penUse)
        {
          canvas.drawLineBetweenPoints(myLocation, oldLocation);
        }
    }

    void draw()
    {
        PenDown();
        turn(-90);
        move(4);
        turn(120);
        move(8);
        turn(120);
        move(8);
        turn(120);
        move(4);
        turn(90);
        PenUp();
    }

    public void undraw()
    {
        canvas.removeMostRecentLine();
        canvas.removeMostRecentLine();
        canvas.removeMostRecentLine();
        canvas.removeMostRecentLine();
    }

    public void flash()
    {
      draw();
      Utils.pause(10);
      undraw();
      Utils.pause(10);
    }

    public double getX()
    {
      return myLocation.getX();
    }

    public double getY()
    {
      return myLocation.getY();
    }
    //used to keep the Turtle on the canvas
    public void wrapPosition(double x, double y)
    {
      if(myLocation.getX() <= 0)
      {
        myLocation.setX(x);
      }
      else if(x <= myLocation.getX())
      {
        myLocation.setX(1);
      }
      else if (myLocation.getY() <= 0)
      {
        myLocation.setY(y);
      }
      else if(y <= myLocation.getY())
      {
        myLocation.setY(1);
      }
      else
      {

      }
    }
}
