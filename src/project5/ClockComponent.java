/**
 * This class creates the template for the clock.
 */
package project5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.*;
import javax.swing.JComponent;

public class ClockComponent extends JComponent
{
    private int s;
    private int m;
    private int h;
    /*
    The constructor recieves the time from the main class.
    */
    public ClockComponent(int s, int m, int h)
    {
        this.s = s;
        this.m = m;
        this.h = h;
    }
    /*
    The setTime method allows for the updates times to be sent from the main
    class. This then updates the clock.
    */
    public void setTime(int s, int m, int h)
    {
        this.s = s;
        this.m = m;
        this.h = h;
    }
        /**
         * This method is what draws the clock. It uses an x and y coordinate
         * variable for each second, minute, and hour. Then it sets the center
         * of the frame's coordinates to 0,0. This made it easier to
         * make the clock symmetrical and to give the hands a true center.
         * Then it adds the time digits to the perimeter of the clock.
         * Then a for loop adds the dashes for the second / minute places.
         * Finally it draws the lines for all 3 hands.
         */
    public void paint(Graphics g)
    {
        int xSecond;
        int ySecond;
        int xMinute;
        int yMinute;
        int xHour;
        int yHour;
       
        Graphics2D g2 = (Graphics2D)g;
                
        // changing the orgin to the center of the frame
        int h2 = getHeight();
        int w2 = getWidth();
        g2.translate(w2 / 2, h2 / 2);
        
        
        //Draws the frame of the clock
        g2.drawOval(-250, -250, 500,500);
        g2.setColor(Color.black);
        
        //draws a circle in the center
        Ellipse2D.Double center = new Ellipse2D.Double(-10,-10, 20, 20);
        g2.draw(center);
        
        
       //draws the time digits around the perimteter
       g2.drawString("12", 0, -250);
       g2.drawString("1", 132, -216);
       g2.drawString("2", 216, -132);
       
       g2.drawString("3", 250, 0);
       g2.drawString("4", 220, 132);
       g2.drawString("5", 145, 216);
       
       g2.drawString("6", 0, 260);
        g2.drawString("8", -225, 132);
       g2.drawString("7", -145, 216);
       
       g2.drawString("9", -260, 0);
        g2.drawString("10", -225, -132);
       g2.drawString("11", -132, -216);
       
       //The for loop uses an equation to set the dashes on the frame of the
       //circle.
       for(int i = 0; i < 60; i++)
       {
           int xDash;
           int xDash2;
           int yDash;
           int yDash2;

           
           
           xDash = (int)(Math.cos(i *3.14f / 30 - 3.14f/2)*250);
           yDash = (int) (Math.sin(i * 3.14f / 30 - 3.14f / 2)*250);
           
           xDash2 = (int)(Math.cos(i *3.14f / 30 - 3.14f/2)*200);
           yDash2 = (int) (Math.sin(i * 3.14f / 30 - 3.14f / 2)*200);
           
           g2.drawLine(xDash2,yDash2,xDash,yDash);
           
           
           
       }
       
      
        //Here I am using the same equation as in the for loop to
       //draw the hands of the clock. This is based off the current time.
       xSecond = (int)(Math.cos(s *3.14f / 30 - 3.14f/2) * 200);
       ySecond = (int) (Math.sin(s * 3.14f / 30 - 3.14f / 2) * 200);
       xMinute = (int) (Math.cos(m * 3.14f / 30 - 3.14f / 2) * 200 ); 
       yMinute = (int) (Math.sin(m * 3.14f / 30 - 3.14f / 2) * 200 ); 
       xHour = (int) (Math.cos((h * 30 + m / 2) * 3.14f / 
               180 - 3.14f / 2) * 125); 
       yHour = (int) (Math.sin((h * 30 + m / 2) * 3.14f / 
               180 - 3.14f / 2) * 125);
       
       g2.setColor(Color.RED);
       g2.drawLine(0, 0, xSecond, ySecond);
       
       g2.setColor(Color.BLACK);
       g2.drawLine(0,0,xMinute, yMinute);
       
       g2.drawLine(0, 0, xHour, yHour);

    }
}
