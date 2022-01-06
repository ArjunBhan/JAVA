/**
 * @author Arjun Bhan <br>
 * 
 * This is the class definition for a node. It stores stores two items in it. 
 * The current item being used and the next item to be used. The code can be 
 * used to get the current item being used or the next item after it.   
 */

public class NodeBhan {
	
	/**
	 * Instance variable for the current node.
	 */
	private ItemBhan myData;
	
	/**
	 * Instance variable for the next node.
	 */
	private NodeBhan myNext;
	
	/**
	 * The default constructor for NodeBhan.
	 */
	public NodeBhan()
	{
		myData = null;
		myNext = null;
	}//default constructor
	
	/**
	 * The setter for the current node.
	 * @param newData the current node.
	 */
	public void setData(ItemBhan newData)
	{
		myData  = newData;	
	}//setData
	
	/**
	 * The setter for the next node.
	 * @param newNext the incoming node.
	 */
	public void setNext(NodeBhan newNext)
	{
	myNext = newNext;	
	}//setNode
	
	/**
	 *The getter of the next node.
	 * @return the incoming node.
	 */
	public NodeBhan getNext()
	{
		return myNext;
	}//getNext
	
	/**
	 * The getter of the current node.
	 * @return the current node.
	 */
	public ItemBhan getData()
	{
		return myData;
	}//getData
}
