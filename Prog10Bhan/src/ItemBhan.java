import java.text.DecimalFormat;
/**
 * @author Arjun Bhan <br>
 * 
 * This is the class definition for an item. It stores a price, name and quantity of an item. 
 * At the end of the code it has a toString that shows the items properties.   
 */
public class ItemBhan 
{
	private DecimalFormat moneyStyle = new DecimalFormat("$0.00");

	/**
	 * Instance variable for item's name.
	 */
	private String myName;

	/**
	 * Instance variable for quantity of item.
	 */
	private int myQuant;

	/**
	 * Instance variable for price of item.
	 */
	private double myPrice;

	/**
	 * The default constructor for ItemBhan.
	 */
	public ItemBhan()
	{
		myName = "";
		myQuant = 0;
		myPrice = 0.0;
	}//Empty constructor

	/**
	 * The setter for the item's name
	 * @param newName The incoming name for this item
	 */
	public void setName(String newName)
	{
		myName = newName;
	}//setName

	/**
	 * The setter for the item's quantity. 
	 * @param newQuant The incoming amount of this item
	 */
	public void setQuant(int newQuant)
	{
		myQuant = newQuant;
	}//setQuant

	/**
	 * The setter for the item's price. 
	 * @param newPrice The incoming price of this item
	 */
	public void setPrice(double newPrice)
	{
		myPrice = newPrice;
	}//setPrice

	/**
	 * The getter for the item's name. 
	 * @return The name of this item.
	 */
	public String getName()
	{
		return myName;
	}//getName

	/**
	 * The getter for the item's quantity. 
	 * @return The quantity of this item.
	 */
	public int getQuant()
	{
		return myQuant;
	}//getQuant

	/**
	 * The getter for the item's price. 
	 * @return The price of this item.
	 */
	public double getPrice()
	{
		return myPrice;
	}//getPrice

	/**
	 * Returns details about this item as a string.
	 */
	public String toString()
	{
		String results = "";
		results += ("Item " + myName + "\n");
		results +=	("Quantity " + myQuant + "\n");
		results +=	("Price " + moneyStyle.format(myPrice) + "\n");
		return results;
	}//toString

}//ItemBhan

