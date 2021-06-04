package abhamare_hw7EC.sequence;

import java.util.Random;

import static abhamare_hw7EC.sequence.State.ACTIVE;

public class Repeater extends Sequence
{
    public Repeater(String word, State state)
    {
        super(word, state);
    }

    public String emitWord()
   {

       Random rand = new Random();
       int index = 0;

       char[] variant= new char[this.getWord().length() + 5];

       if(this.getState()==ACTIVE)
       {
           index = rand.nextInt(this.getWord().length() - 1);

           //String sub1 = this.getWord().charAt(index) + "";

           int counter = 0;

           if(index >= 2)
           {
               return this.getWord().substring(index);
           }
           for(int i = 0; i < this.getWord().length(); i++)
           {
               if(i == index)
               {
                   variant[counter++] = (this.getWord().charAt(i));
               }
               variant[counter++] = (this.getWord().charAt(i));
           }

         return  new String(variant);
       }

       return this.getWord();
   }

   public String convertIntoString(char[] a, int size)
   {
       String word = "";
       for (int i = 0; i < size-1; i++)
       {
           word = word + a[i];
       }
       return word;
   }

   public boolean isActive()
   {
       if (getState() == State.ACTIVE)
       {
           return true;
       }
       return false;
   }

}
