import java.util.*;

/**
 * Testing class for Chick, NamedCow, and Pig. Initializes objects of each and
 * tests their methods. it represents, and how to use it.
 * 
 * @author Rohan Chaudhary
 * @version 11/2/2024 Period - 2 Assignment - A29.1 Old MacDonald Sources - N/A
 */
public class Farm
{
   private Animal[] a = new Animal[3];

   /**
    * Initializes array of Chick, NamedCow, and Pig objects
    */
   public Farm()
   {
      a[0] = new NamedCow("cow", "Elsie", "moo");
      a[1] = new Chick("chick", "cluckity cluck", "cheep");
      a[2] = new Pig("pig", "oink oink");
   }


   /**
    * Tests getType and getSound methods for all objects in Animal array,
    * printing out output. Tests getName method for namedCow
    */
   public void animalSounds()
   {
      for (int i = 0; i < a.length; i++)
      {
         System.out.println(a[i].getType() + " goes " + a[i].getSound());
      }
      NamedCow named = (NamedCow)a[0];
      System.out.println(named.getType() + " is named " + named.getName());
   }
}
