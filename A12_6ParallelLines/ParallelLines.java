import java.awt.*;
import javax.swing.*;

/**
   Creates an illusion of parallel lines bending when a drawIllusion is called, 
   The Class ParallelLines is an extension of Jpanel, with a method to create the base component and call
   the drawIllusion method, which uses a nested loop system to create the illusion through offset squares
   on parallel lines.
  
   @author  Rohan Chaudhary
   @version 9-28-2024

   Period - 2
   Assignment - A12.6 - ParallelLines

   Sources - N/A
 */
public class ParallelLines extends JPanel
{
  // No Instance Variables used in this case. 
    
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //   to paint the background
    
    int width = getWidth();    
    int height = getHeight();
    
    drawIllusion(g, width, height);
  }

  /**
     Creates an illusion of parallel lines being bent by creating squares slightly offset in each row.
     Uses a starting X and Y location that slowly oscillates depending on the row, using a nested loop to 
     create 8 rows of 7 squares each, drawing a line at the end.
     @param g
     @param width
     @param height
     @param size
   */
  public void drawIllusion(Graphics g, int width, int height)
  {
    int startLocX = 0;
    int startLocY = 0;
    int tempStartPos = 0;
    for ( int row = 0; row < 8; row++ )
    {
      // Decides Horizontal Offset
      if (row <= 2 && row > 0) 
        startLocX += 5;
      else if ((row <= 4 || row > 6) && row > 0)
        startLocX -= 5;
      else if (row > 4)
        startLocX += 5;
      startLocY = row * 20;
      tempStartPos = startLocX;
      for ( int col = 0; col < 7; col++ )
      {
        // Draws the Square
        // Uses Temporary Variable to calculate position of Next Square
        g.fillRect(tempStartPos, startLocY, 20, 20);
        tempStartPos += 38;
        
      }
      // Draws a Dividing Line
      g.drawLine(0, startLocY+20, 265, startLocY+20);
    }   
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("ParallelLines");
    w.setBounds(100, 100, 640, 480);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ParallelLines panel = new ParallelLines();
    panel.setBackground(Color.WHITE);
    Container c = w.getContentPane();
    c.add(panel);
    w.setResizable(true);
    w.setVisible(true);
  }
}
