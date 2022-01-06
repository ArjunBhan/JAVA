/**
 * @author Arjun Bhan <br>
 * 
 * This is the class definition for a stack. It contains a max size, a list of cards and a value that shows where in the list you are.
 */
public class StackBhan {
	
	/**
	 * Instance variable for the max amount of cards in the deck.
	 */
	private static final int MAX_SIZE = 52;
	
	/**
	 * Instance variable for the list of cards.
	 */
	private CardBhan[] myList;
	
	/**
	 * Instance variable that show the current position of the list 
	 */
	private int myTop; 
	
	/**
	 * The default constructor for CardBhan.
	 */
	public StackBhan()
	{
		myList = new CardBhan[MAX_SIZE];
		myTop = 0;		
	}//Null constructor
	
	/**
	 * This method adds items into the array.
	 * @param addedVal: holds the value that is going to be added into the array.
	 * @return added: checks if the item was added in the list.
	 */
	public boolean push(CardBhan addedVal)
	{
		boolean added = false;
		if (!isFull())
		{
			myList[myTop] = addedVal;
			myTop++;
			added = true;
		}//if
		return added;
	}//push
	
	/**
	 * This method removes the most recently pushed item from the array.
	 * @return delVal: The card that was deleted. 
	 */
	public CardBhan pop()
	{
		CardBhan delVal = null;
		if(!isEmpty())
		{
			myTop--;
			delVal = myList[myTop];
		}//if
		return delVal;
	}//pop
	
	/**
	 * This shows whether the array is empty or not.
	 * @return delVal: The card that was deleted. 
	 */
	public boolean isEmpty()
	{
		return (myTop == 0);
	}//isEmpty
	
	public boolean isFull()
	{
		return (myTop == MAX_SIZE);
	}//isFull
	
}//StackBhan


