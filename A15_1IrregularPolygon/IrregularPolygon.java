import java.awt.Color;
import java.awt.geom.*;
import java.util.*;
import gpdraw.*;

/**
 * Class representing an Irregular Polygon using an arrayList of points
 * Functionality for adding points, calculating area, perimeter, and drawing it
 * using an attached module. it represents, and how to use it.
 *
 * @author Rohan Chaudhary
 * @version 11-12-2024
 * @author Period - 2
 * @author Assignment - Irregular Polygon
 * @author Sources - N/A
 */
public class IrregularPolygon
{
    private DrawingTool              pen; // = new DrawingTool(new SketchPad(300, 300, 0));
    private ArrayList<Point2D.Double> myPolygon;

    // constuctors

    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }

    // public methods


    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }


    public double perimeter()
    {
        if (myPolygon.size() < 3)
        {
            return 0.0;
        }
        double perimeter = 0.0;
        double tX = 0.0;
        double tY = 0.0;
        for (int i = 0; i < myPolygon.size(); i++)
        {
            if (i != myPolygon.size() - 1)
            {
                tX = Math.abs(myPolygon.get(i).getX() - myPolygon.get(i + 1).getX());
                tY = Math.abs(myPolygon.get(i).getY() - myPolygon.get(i + 1).getY());
                perimeter += Math.sqrt(Math.pow(tX, 2.0) + Math.pow(tY, 2.0));
            }
            else
            {
                tX = Math.abs(myPolygon.get(i).getX() - myPolygon.get(0).getX());
                tY = Math.abs(myPolygon.get(i).getY() - myPolygon.get(0).getY());
                perimeter += Math.sqrt(Math.pow(tX, 2.0) + Math.pow(tY, 2.0));
            }
        }
        return perimeter;
    }


    public double area()
    {
        // Initial Addition
        double area = 0.0;
        for (int i = 0; i < myPolygon.size(); i++)
        {
            if (i != myPolygon.size() - 1)
            {
                area += (myPolygon.get(i).getX() * myPolygon.get(i + 1).getY());
            }
            else
            {
                area += (myPolygon.get(i).getX() * myPolygon.get(0).getY());
            }
        }

        // Initial Subtraction
        for (int i = 0; i < myPolygon.size(); i++)
        {
            if (i != myPolygon.size() - 1)
            {
                area -= (myPolygon.get(i).getY() * myPolygon.get(i + 1).getX());
            }
            else
            {
                area -= (myPolygon.get(i).getY() * myPolygon.get(0).getX());
            }
        }

        area = area * .5;
        return Math.abs(area);
    }


    public void draw()
    {
        pen.up();
        for (int i = 0; i < myPolygon.size(); i++)
        {
            pen.move(myPolygon.get(i).getX(), myPolygon.get(i).getY());
            pen.down();
        }
        if (myPolygon.size() > 0)
        {
            pen.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
        }
        pen.up();
        pen.move(0, 0);
    }
}
