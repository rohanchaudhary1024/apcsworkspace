import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

/**
 * Test for the complex number class. testConstructor1Param - test the 1
 * parameter constructor testConstructor2Param - test the 2 parameter
 * constructor testAddRealAndComplexNum - addition of a complex number with a
 * real number testAdd2ComplexNums - addition of two complex numbers
 * testMultiply2ComplexNums - multiplication of two complex numbers
 * testMultiplyRealAndComplexNum - multiplication of a complex number with a
 * real number testAbsoluteValue - absolute value of a complex number
 * testToString - test toString / output of the class
 *
 * @author Rohan Chaudhary
 * @version 10/10/2024
 * @author Period: 2
 * @author Assignment: JMCh09Ex17_Complex
 * @author Sources: N/A
 */
public class ComplexJUTest
    extends junit.framework.TestCase
{
    @Test
    public void testConstructor1Param()
    {
        Complex test = new Complex(2.0);
        assertEquals(2.0, test.getA(), 0);
        assertEquals(0.0, test.getB(), 0);
    }


    @Test
    public void testConstructor2Param()
    {
        Complex test = new Complex(2.0, 3.0);
        assertEquals(2.0, test.getA(), 0);
        assertEquals(3.0, test.getB(), 0);
    }


    @Test
    public void testAddRealAndComplexNum()
    {
        Complex complex = new Complex(2.0, 3.0);
        double real = 3.0;
        Complex test = complex.add(real);
        assertEquals(5.0, test.getA(), 0);
        assertEquals(3.0, test.getB(), 0);
    }


    @Test
    public void testAdd2ComplexNums()
    {
        Complex complex1 = new Complex(2.0, 3.0);
        Complex complex2 = new Complex(3.0, 5.0);
        Complex test = complex1.add(complex2);
        assertEquals(5.0, test.getA(), 0);
        assertEquals(8.0, test.getB(), 0);
    }


    @Test
    public void testMultiply2ComplexNums()
    {
        Complex complex1 = new Complex(2.0, 3.0);
        Complex complex2 = new Complex(3.0, 5.0);
        Complex test = complex1.multiply(complex2);
        assertEquals(-9.0, test.getA(), 0);
        assertEquals(19.0, test.getB(), 0);

    }


    @Test
    public void testMultiplyRealAndComplexNum()
    {
        Complex complex = new Complex(2.0, 3.0);
        double real = 2.0;
        Complex test = complex.multiply(real);
        assertEquals(4.0, test.getA(), 0);
        assertEquals(6.0, test.getB(), 0);
    }


    @Test
    public void testAbsoluteValue()
    {
        Complex complex = new Complex(3.0, 4.0);
        assertEquals(5, complex.abs(), 0);
    }

    @Test
    public void testToString() {
        Complex complex = new Complex(3.0,2.0);
        assertEquals("3.0 + 2.0i", complex.toString());
    }
    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter(ComplexJUTest.class);
    }


    public static void main(String args[])
    {
        org.junit.runner.JUnitCore.main("ComplexJUTest");
    }
}
