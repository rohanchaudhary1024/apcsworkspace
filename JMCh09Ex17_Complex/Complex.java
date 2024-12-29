/**
 * Represents a complex number of the form a + bi. Provides methods for adding,
 * multiplying and calculating the absolute value.
 *
 * @author Rohan Chaudhary
 * @version 10/10/2024
 * @author Period: 2
 * @author Assignment: JMCh09Ex17_Complex
 * @author Sources: N/A
 */
public class Complex
{
    private double a;
    private double b;

    /**
     * Sets a to a double parameter. Sets b to 0.0
     * 
     * @param setA
     *            value to set a to (double)
     */
    public Complex(double setA)
    {
        a = setA;
        b = 0.0;
    }


    /**
     * Sets a and b to their respective parameters (doubles).
     * 
     * @param setA
     *            value to set a to (double)
     * @param setB
     *            value to set b to (double)
     */
    public Complex(double setA, double setB)
    {
        a = setA;
        b = setB;
    }


    /**
     * returns constant of complex number
     * 
     * @return constant a (double)
     */
    public double getA()
    {
        return a;
    }


    /**
     * returns imaginary coefficient of complex number
     * 
     * @return coeffecient b (double)
     */
    public double getB()
    {
        return b;
    }


    /**
     * sets constant a to newA
     * 
     * @param newA
     *            value to set a to
     */
    public void setA(double newA)
    {
        a = newA;
    }


    /**
     * sets imaginary coeffecient to newB
     * 
     * @param newB
     *            value to set b to
     */
    public void setB(double newB)
    {
        b = newB;
    }


    /**
     * returns the square root of a^2+b^2
     * 
     * @return square root of a^2+b^2 (double)
     */
    public double abs()
    {
        return (Math.sqrt(Math.pow(a, 2.0) + Math.pow(b, 2.0)));
    }


    /**
     * adds two Complex objects by adding both a values and b values. creating a
     * new complex object and returning it.
     * 
     * @param other
     *            the other complex to add to the one calling the method
     * @return complex sum of both complex objects
     */
    public Complex add(Complex other)
    {
        Complex newComplex = new Complex(a + other.a, b + other.b);
        return newComplex;
    }


    /**
     * adds a Complex object to a double, adding a to the value of double
     * 
     * @param other
     *            the double to be added to the complex
     * @return complex sum of complex object and double
     */
    public Complex add(double other)
    {
        Complex newComplex = new Complex(a + other, b);
        return newComplex;
    }


    /**
     * Converts the Complex Object to a string in the format of a + bi
     * @return string value in the form a + bi
     */
    public String toString()
    {
        return a + " + " + b + "i";
    }


    /**
     * multiplies two Complex objects by FOILING both, creating a new complex
     * object and returning it.
     * 
     * @param other
     *            the other complex to multiply to the one calling the method
     * @return complex product of both complex objects
     */
    public Complex multiply(Complex other)
    {
        double newA = (a * other.a + (-b * other.b));
        double newB = (a * other.b + b * other.a);
        Complex newComplex = new Complex(newA, newB);
        return newComplex;
    }


    /**
     * multiplies a Complex object by a double, adding a to the value of double
     * 
     * @param other
     *            the double to be added to the complex
     * @return complex sum of complex object and double
     */
    public Complex multiply(double other)
    {
        Complex newComplex = new Complex(a * other, other * b);
        return newComplex;
    }

}
