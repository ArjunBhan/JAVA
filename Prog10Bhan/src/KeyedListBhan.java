/**
 * @author Arjun Bhan <br>
 * This is the class for a linked list of items. It can get items and organize them 
 * alphabetically with the add method. It print those items with the print method. It finds if the list 
 * is empty with the isEmpty method. The code finds if the list is full with the isFull method.
 * The code can find the total price of all of its items with its calcTotal method.
 * The code can get the find the number of items with the getCount method. The code can reset the list to a  
 * empty state with the clear method. The code is able to delete an item with the remove method. The code  
 * can return a specific item of ItemBhan with the retrieve method. The code can use the print method to 
 * print out all items in the list.
 */
public class KeyedListBhan {

	/**
	 * Instance variable for the first element of a linked list.
	 */
	private  NodeBhan myHead;

	/**
	 * The default constructor for KeyedListBhan.
	 */
	public KeyedListBhan()
	{
		myHead = null;
	}//default constructor

	/**
	 * This method reset the list to a  
	 * empty state
	 */
	public void clear()
	{
		myHead = null;	

	}//clear

	/**
	 * This method store all the item's in a linked list, makes sure none of the items have the same value
	 * and organizes the items in a alphabetical order. 
	 * @param product: holds the quantity, name and price of an item.
	 * @return inList: checks if the item was added in the list.
	 */
	public boolean add(ItemBhan product)
	{
		NodeBhan current = myHead, previous = null;
		boolean success = false, found = false;
		String productName = product.getName();

		if (retrieve(productName) ==  null)
		{ 
			success = true; 
			while(current != null && found == false)
			{
				if(productName.compareToIgnoreCase(current.getData().getName())<0) 
				{
					found = true;
				}//if

				else
				{
					previous = current;
					current = current.getNext();
				}//else

			}//while

			NodeBhan addNode = new NodeBhan();
			addNode.setData(product);

			if(previous == null)
			{
				addNode.setNext(current);
				myHead = addNode;
			}//if

			else
			{
				addNode.setNext(current);	
				previous.setNext(addNode);
			}//else
			
		}//if
		return success;
	}//add
	/**
	 * This method deletes a user inputed item from the list 
	 * @param keyValue: The string of the item the code is trying to remove.
	 * @return itemGon: Boolean value showing whether a value was removed.
	 */
	public boolean remove(String keyValue)
	{ 
		NodeBhan current = myHead, previous = null;
		boolean itemGon = false;
		String strinSear = keyValue;
		if(retrieve(strinSear) != null)
		{	
			while(current != null && itemGon == false)
			{
				if(keyValue.compareToIgnoreCase(current.getData().getName())==0) 
				{
					itemGon = true;
				}//if
				else
				{
					previous = current;
					current = current.getNext();
				}//else
	
			}//while
			
			if (previous == null)
				myHead = current.getNext();
			else
				previous.setNext(current.getNext());
		}//if
		return itemGon;
	}//remove

	/**
	 * This method retrieves a user inputed item from the list. 
	 * @param keyValue: is the name of the item trying to be returned.
	 * @return retrItem the item that is being returned.
	 */
	public ItemBhan retrieve(String keyValue)
	{
		NodeBhan current = myHead;
		ItemBhan retrItem = null, itemComp = null; 
		boolean itemDiscov = false;

		while(current != null && itemDiscov != true)
		{
			itemComp = current.getData();

			if (itemComp.getName().compareToIgnoreCase(keyValue)==0)
			{
				itemDiscov = true; 
				retrItem = itemComp;
			}//if

			else 
				current = current.getNext();
		}//while

		return retrItem;
	}//retrieve

	/**
	 * This method calculates weather the list is empty.
	 * @return a statement showing whether a list is empty.
	 */
	public boolean isEmpty()
	{
		return (myHead == null);
	}//isEmpty

	/**
	 * This method calculates weather the list is full. Since a linked list
	 * is never full it will return false always. 
	 * @return false since lists are never full. 
	 */
	public boolean isFull()
	{
		return false;
	}//isFull

	/**
	 *This method prints out all the items in the linked list. 
	 */
	public void print()
	{
		NodeBhan current = myHead;

		while(current != null)
		{
			System.out.println(current.getData().toString());
			current = current.getNext();
		}//while

	}//print

	/**
	 * This method shows how many individual item there are in the linked list. 
	 * @return totQuant the amount of individual items in the linked list.
	 */
	public int getCount()
	{
		int totQuant = 0, singQuant = 0;
		ItemBhan item = null;
		NodeBhan current = myHead;

		while(current != null)
		{
			item = current.getData();
			singQuant = item.getQuant();
			totQuant += singQuant;
			current = current.getNext();
		}//while

		return totQuant;
	}//getCount

	/**
	 *This method calculates the total price of all the items. 
	 * @return totPrice the total price of all the items.
	 */
	public double calcTotal()
	{
		NodeBhan current = myHead;
		double totPrice = 0.0;
		ItemBhan curItem = null;

		while(current != null)
		{
			curItem = current.getData();
			totPrice += curItem.getQuant() * curItem.getPrice();
			current = current.getNext();
		}//while

		return totPrice;
	}//calcTotal

}//KeyedListBhan