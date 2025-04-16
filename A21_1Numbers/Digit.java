/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  Rohan Chaudhary
   @version 4-5-2025

   @author  Period - 2
   @author  Assignment - A21_1Numbers

   @author  Sources - N/A
 */
public class Digit
{
  private int base;
  private int value;
  private String[] overflowVals = {"A","B","C","D","E","F"};

  public Digit() {
    base = 10;
    value = 0;
  }

  public Digit(int value, int base) {
    this.value = value;
    this.base = base;
    
  }

  public boolean increment() {
    if (value+1 >= base) {
      value = 0;
      return true;
    }
    value++;
    return false;
  }

  public String toString() {
    if (value > 9) {
      return overflowVals[value-10];
    }
    return String.valueOf(value);
  }


}
