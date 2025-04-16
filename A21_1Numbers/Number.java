import java.util.*;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO Date

   @author  Period - TODO Your Period
   @author  Assignment - TODO Assignment Name

   @author  Sources - TODO list collaborators
 */
public class Number
{
  private int base;
  private int value;
  ArrayList<Digit> digits = new ArrayList<Digit>();

  public Number() {
    base = 10;
    value = 0;
    digits.add(new Digit());
  }

  public Number(int value, int base) {
    this.value = value;
    this.base = base;
    digits.add(new Digit(0,base));
    for (int i = value; i > 0; i--) {
      if (digits.get(0).increment() == true) {
        for (int j = 1; ; j++) {
          if (j >= digits.size()) {
            digits.add(new Digit(1,base));
            break;
          }
          else {
            if (digits.get(j).increment() == false) {
              break;
            }
          }
        }
      }
    }

    
  }

  public void increment() {
    for (int i = 0; i < digits.size(); i++) {
      if (digits.get(i).increment() == false) {
        return;
      }
    }
    digits.add(new Digit(1,base));
  }
  public String toString() {
    String output = "";
    for (int i = digits.size() - 1; i >= 0; i--) {
      output += (digits.get(i).toString());
    }
    return output;
  }
}
