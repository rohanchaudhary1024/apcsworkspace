import java.lang.reflect.*;

/**
   This class implements a vendor that sells one kind of item.
   A vendor carries out sales transactions.

   @author  Rohan Chaudhary
   @version 10-8-2024

   @author Period - 2
   @author Assignment - Java Methods Ch09 - SnackBar

   @author Sources - N/A
 */
public class Vendor
{
    private int stock;
    private int price;
    private int deposit;
    private int change;
    private static double totalSales = 0.0;



    /**
     * Constructor for the Vendor Class.
     * inital deposit and change are assigned to 0, price and stock are assigned 
     * according to parameters.
     * @param setPrice int value price is set to
     * @param setStock int value stock is set to
     */
    public Vendor(int setPrice, int setStock)
    {
        price = setPrice;
        stock = setStock;
        deposit = 0;
        change = 0;
    }

    /**
     * setter for the stock of items
     * @param setStock integer value stock is set to
     */
    public void setStock(int setStock)
    {
        stock = setStock;
    }

    /**
     * getter for stock of items
     * @return integer value of stock
     */
    public int getStock()
    {
        return stock;
    }

    /**
     * if stock is greater than 0, add the input parameter to deposit
     * @param cents int amount to add to deposit (if conditions suceed)
     */
    public void addMoney(int cents)
    {
        if (stock > 0) {
            deposit += cents;
        }
        return;
    }

    /**
     * getter of current amount of cents deposited
     */
    public int getDeposit()
    {
        return deposit;
    }

    /**
     * If item is in stock, and deposit matches or exceeds the price of the
     * item, make a purchase, detracting the stock, returning the correct 
     * amount of changing, setting deposit to zero, adding the sale to totalSales,
     * and returning true.
     * 
     * If conditions fail, return false.
     * @return true if sale goes through, fales if it doesnt
     */
    public boolean makeSale()
    {
        if (stock > 0 && deposit >= price) {
            stock--;
            change = deposit - price;
            totalSales += (price * .01);
            deposit = 0;
            return true;
        }
        
        change = deposit;
        deposit = 0;
        return false;
    }

    /**
     * returns and zeroes change in cents
     * @return amount of change in cents (int)
     */
    public int getChange ()
    {
        int temp = change;
        change = 0;
        return temp;
    }

    /**
     * returns and zeroes totalSales
     * @return sales in dollars (double)
     */
    public static double getTotalSales()
    {
        double temp = totalSales;
        totalSales = 0.0;
        return temp;
    }

    /**
        Intended only for debugging.
        
        <p>A generic toString implementation that uses reflection to print
        names and values of all fields <em>declared in this class</em>.
        Note that superclass fields are left out of this implementation.</p>
        
        @return  a string representation of this Vendor.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
