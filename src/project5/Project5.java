/**
 * Scott Glascott
 * 2/15/2015
 * For this assignment we were tasked with creating an analog clock. This 
 * assignment proved to be difficult since I had to learn about all of the
 * graphics, Jframe and timer Classes. The main class creates a JFrame, within
 * the JFrame the ClockComponent draws the clock. The main class uses the 
 * Gregorian Calendar time to send to the ClockComponent class. The class then
 * refreshes the clock every second.
 */
package project5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Project5
{

    public static void main(String[] args)
    {
        //Creating the JFrame
        JFrame window = new JFrame();
        window.setSize(600,600);
        window.setTitle("Analog Clock");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Creating the Clock object
        final ClockComponent c = new ClockComponent(0,0,0);
        final GregorianCalendar gc = new GregorianCalendar();
        
        //Creates the clock class that will refresh after every second
        class Clock implements ActionListener
        {
            public void actionPerformed(ActionEvent even)
            {
                Date d1 = new Date();
                gc.setTime(d1);
                c.setTime(gc.get(GregorianCalendar.SECOND),
                                 gc.get(GregorianCalendar.MINUTE),
                                 gc.get(GregorianCalendar.HOUR));
                c.repaint();
                
            }
        }
        Timer t = new Timer(1000, new Clock());
        t.start();
        window.add(c);
        window.setVisible(true);
    }
    
}
