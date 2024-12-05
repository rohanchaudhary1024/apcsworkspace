/**
 * Class that implements bare requirements for Animal, adding a second sound
 * field and randomizing between the two when getSound is called
 * 
 * @author Rohan Chaudhary
 * @version 11/2/2024
 */
class Chick
   implements Animal
{
   private String myType;
   private String mySound;
   private String secondSound = null;

   /**
    * Initializes a newly created Chick object so that it represents an Animal
    * of the specified type that makes the specified sound.
    * 
    * @param type
    *           the type of Chick
    * @param sound
    *           the sound the Chick makes
    */
   public Chick(String type, String sound)
   {
      myType = type;
      mySound = sound;
   }


   /**
    * Initializes Chick with type, and both sounds.
    * 
    * @param type
    *           type of chick
    * @param sound1
    *           sound 1 of chick
    * @param sound2
    *           sound 2 of chick
    */
   public Chick(String type, String sound1, String sound2)
   {
      myType = type;
      mySound = sound1;
      secondSound = sound2;
   }


   /**
    * Randomly chooses a sound to return
    * 
    * @return one of the initialized sound fields
    */
   public String getSound()
   {
      if (!(secondSound == null))
      {
         double randNum = Math.random();
         if (randNum < .5)
         {
            return mySound;
         }
         else
         {
            return secondSound;
         }
      }
      return mySound;
   }


   /**
    * Returns type field
    * 
    * @return type field
    */
   public String getType()
   {
      return myType;
   }
}
