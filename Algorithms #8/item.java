/**
 * Name: Arjun Bhan
 * Due Date: 12/9/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 */

public class item {
	public int id;
	public double value;
	public int size;
	public double density;
	
	
	public item(double givenvalue, int givensize, int givenid)
	{
		id = givenid;
		
		size = givensize;
		
		value = givenvalue;
		
		density = value/size;
	}
	

}