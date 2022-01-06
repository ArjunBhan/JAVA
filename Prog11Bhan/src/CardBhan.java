/**
 * @author Arjun Bhan <br>
 * 
 * This is the class definition for a cards. It contains the value and suit of a card.
 */
public class CardBhan {
	
	/**
	 * Instance variable for card's number.
	 */
	private int myValue;
	
	/**
	 * Instance variable for card's suit.
	 */
	private char mySuit;
	
	/**
	 * The default constructor for CardBhan.
	 */
	public CardBhan(){
		myValue = 0; 
		mySuit = '?';
	}//Null constructor
	
	/**
	 * The setter for the card's suit.
	 * @param newSuit The incoming suit for the card.
	 */
	public void setSuit(char newSuit)
	{
		mySuit = newSuit;
	}//setSuit
	
	/**
	 * The setter for the card's number.
	 * @param newValue The incoming number for the card.
	 */
	public void setValue(int newValue)
	{
		myValue = newValue;
	}//setValue
	
	/**
	 * The getter for the card's suit. 
	 * @return The suit of this card.
	 */
	public char getSuit()
	{
		return mySuit;
	}//getSuit
	
	/**
	 * The getter for the card's value. 
	 * @return The value of this item.
	 */
	public int getValue()
	{
		return myValue;
	}//getValue
	
}//CardBhan

