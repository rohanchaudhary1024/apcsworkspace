/**
 * Extension of cow that adds a name field.
 * 
 * @author Rohan Chaudhary
 * @version 11/2/2024
 */
class NamedCow
   extends Cow
{
   private String myName;

   /**
    * Constructor for NamedCow, stores name, sound, sets type to "cow" by
    * default
    * 
    * @param name
    *           string
    * @param sound
    *           string
    */
   public NamedCow(String name, String sound)
   {
      super("cow", sound);
      myName = name;
   }


   /**
    * Constructor for Named cow, storing all fields based on input.
    * 
    * @param type
    *           string
    * @param name
    *           string
    * @param sound
    *           string
    */
   public NamedCow(String type, String name, String sound)
   {
      super(type, sound);
      myName = name;
   }


   /**
    * returns name of cow
    * 
    * @return myName field
    */
   public String getName()
   {
      return myName;
   }
}
