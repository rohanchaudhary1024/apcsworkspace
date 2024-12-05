/**
 * Bare minimum requirements for animal
 * 
 * @author Rohan Chaudhary
 * @version 11/2/2024
 */
class Pig
   implements Animal
{
   private String myType;
   private String mySound;

   /**
    * Initializes a newly created Pig object so that it represents an Animal of
    * the specified type that makes the specified sound.
    * 
    * @param type
    *           the type of Pig
    * @param sound
    *           the sound the Pig makes
    */
   public Pig(String type, String sound)
   {
      myType = type;
      mySound = sound;
   }


   /**
    * getter for mySound
    * 
    * @return mySound
    */
   public String getSound()
   {
      return mySound;
   }


   /**
    * getter for myType
    * 
    * @return myType field
    */
   public String getType()
   {
      return myType;
   }
}
