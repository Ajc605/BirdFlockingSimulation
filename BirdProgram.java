import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
class BirdProgram
{
  private JFrame frame;
  private Canvas canvas;
  private JPanel lowerPanel;
  private JButton addBirdButton;
  private ArrayList<DynamicBird> birds;
  private JSlider birdsSpeed;
  private double xTotal, yTotal, bNeighbours,  avgX, avgY, distFromCenter, turningAngle, diffX, diffY, angleRad, deltaTime;

  public BirdProgram()
  {
    //Setting canvas and  frame
    frame = new JFrame();
    canvas = new Canvas();
    frame.setTitle("Birds");
    frame.setSize(800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.add(canvas);
    lowerPanel = new JPanel();
    //setting birds array
    birds = new ArrayList<DynamicBird>();
    //setting button
    addBirdButton = new JButton("add");
    lowerPanel.setLayout(new FlowLayout());
    frame.add(lowerPanel, BorderLayout.PAGE_END);
    lowerPanel.add(addBirdButton);
    //setting slider
    birdsSpeed = new JSlider(JSlider.HORIZONTAL, 0, 30, 1);
    lowerPanel.add(birdsSpeed);
    //button that adds birds
    addBirdButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent event)
      {
        System.out.println("Button Clicked!");
        CartesianCoordinate initLocation = new CartesianCoordinate(Utils.randomInt(700),Utils.randomInt(500));
        birds.add(new RandomBirdB(canvas, initLocation));
      }
    });
    //slider for speed
    birdsSpeed.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent e)
      {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting())
      {
       deltaTime = (int)source.getValue();
       }
      }
      });
    //refresh the screen
    frame.revalidate();
    //call the gameloop
    gameLoop();
  }
    //Gameloop
    private void gameLoop()
    {
      while(true)
      {
        bNeighbours = 0;
        xTotal = 0;
        yTotal = 0;
        diffX = 0;
        diffY = 0;
        //undraw all birds in arry
        for (int i = 0; i < birds.size(); i++)
        {
          birds.get(i).undraw();
        }
        //uodate all birds in arry
        for (int i = 0; i < birds.size(); i++)
        {
            birds.get(i).update(deltaTime);
        }
        //redarw all birds in arry
        for (int i = 0; i < birds.size(); i++)
        {
            birds.get(i).draw();
        }

        Cohesion(birds);
        //keep birds on the canvas
        for (int i = 0; i < birds.size(); i++)
        {
            birds.get(i).wrapPosition(canvas.getWidth(),canvas.getHeight());
        }

        Utils.pause(20);
      }
   }

 public void Cohesion(ArrayList<DynamicBird> birds)
     {
       //double xTotal, yTotal, bNeighbours,  avgX, avgY, distFromCenter, turningAngle;
         for(DynamicBird b : birds)
				{
          //making a CartesianCoordinate for BirdsA to comepare
					CartesianCoordinate bird1 = new CartesianCoordinate(b.getX(), b.getY());

					for(DynamicBird b2 : birds)
					{
            //making a CartesianCoordinate for BirdsB to comepare
						CartesianCoordinate bird2 = new CartesianCoordinate(b2.getX(), b2.getY());
            //checking birdA isnt birdB
						if((bird2.getX() != bird1.getX()) && bird2.getY() != bird1.getY())
            {
              //finding the differnt between both birds
							diffX = Math.abs(bird2.getX() - bird1.getX());
							diffY = Math.abs(bird2.getY() - bird1.getY());
              //if its within the radius then add up the number of neighbours and the total x an y
              if((diffX <= 30) && (diffY <= 30))
              {
							  bNeighbours = bNeighbours + 1;
                xTotal = xTotal + diffX;
                yTotal = yTotal + diffY;

              }
						}
          }
          if(bNeighbours != 0)
          {
            //finidng the average x
			      avgX = xTotal/bNeighbours;
            //finidng the average y
				    avgY = yTotal/bNeighbours;
            distFromCenter = Math.sqrt((avgX * avgX) + (avgY * avgY));
				    angleRad = (Math.atan2(avgY , avgX));
            turningAngle = Math.toDegrees(angleRad);
            //System.out.println(+distFromCenter+ turningAngle);
            b.move(distFromCenter);
            b.turn(turningAngle);
          }

        }
      }


  public static void main(String [ ] args)
  {
    new BirdProgram();
  }
}
