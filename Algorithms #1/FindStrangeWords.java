/**
 * Name: Arjun Bhan
 * Due Data: 9/8/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 * Purpose: This program outputs words that contain all five vowels a, e, i, o,u, and they occur in order.
 */
public class FindStrangeWords {

    public static void main (String[] argv)
    {
	mainTest ();
    }

  
    static void mainTest ()
    {
      //Passing in words from the words.txt file into function
      String[] words = WordTool.getDictionary ();
      findConsecVowelWords (words);
    }

    static void findConsecVowelWords (String[] words)
    {
        int [] PlaceList=new int[5];
        int Counter=0;
        char[] VowelLis=new char[]{'a','e','i','o','u'};

        //Looping through every word in the list
        for(int i=0;i<words.length;i++)
        {
            Counter=0;

            //Looping through every character in the given word
            char[] letters = words[i].toCharArray ();
            for(int j=0;j<letters.length;j++)
            {

                //Checking if character is a vowel
                if (letters[j]==VowelLis[Counter])
                {
                    PlaceList[Counter]=j;

                    //If statment makes sure to output the right information when a word contains all vowel sequentially.
                    if(Counter!=VowelLis.length-1)
                    {
                        Counter++;
                    }
                    else
                    {
                        System.out.println("The Word "+words[i] + "has the vowel: ");
                        for(int w=0;w<PlaceList.length;w++)
                        {
                            System.out.print(VowelLis[w]);
                            System.out.println(" located in " + PlaceList[w]);
                        }
                    }
                }

            }
        }
    }
}