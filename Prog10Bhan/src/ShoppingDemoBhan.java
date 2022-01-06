import java.io.File;
import java.io.FileNotFoundException;
import java.text.*;
import java.util.*;
/**
 * @author Name: Arjun Bhan CMPT 220 - Program 10
 * Due: Thursday, April 18, before 1:30 p.m
 * CMPT 220 - Program 10
 * Purpose: The purpose of this program is to teach us how to use linked list
 * by editing our program 9 to work with them.
 * Inputs: Menu option, item's price, amount of items, inputed text file, name of item looking for,
 * name of items wanting to delete and name of item.
 * Outputs:  Print statements about if the list is full or empty Size of list, catch statements
 * printing the list, total cost of items, a thank you when quitting and a prompt asking 
 * the user to choose a different option if incorrect input was taken.
 * Certification of Authenticity: I certify that this assignment is my own work, but
 * I discussed it with: Professor Schwartz and computer lab tutors.
 */
public class ShoppingDemoBhan 
{
	public static void main(String args[])
	{
		//variable initializers
		Scanner keyboard = new Scanner(System.in);	
		KeyedListBhan shop = new KeyedListBhan();	
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		String  remvStr = "" , menuCho = "", retItem = "", item = "", fileName= "", itemName="";
		int amonItem = 0, loop = 0, quant = 0;
		double itemCos = -1.0, fileCos = 0;
		char menuChoChar = '?';

		// File input
		System.out.print("Enter file name: ");
		fileName=keyboard.next();
		File myFile = new File(fileName); 

		try {
			Scanner input = new Scanner(myFile);
			loop = input.nextInt();
			
			//adds files qualities to cart
			for(int i=0; i<loop; i++)
			{		
				//item qualities
				itemName = input.next();
				quant = input.nextInt();
				fileCos = input.nextDouble();
				
				//item added
				ItemBhan itemQual = new ItemBhan();
				itemQual.setName(itemName);
				itemQual.setQuant(quant);
				itemQual.setPrice(fileCos);
				shop.add(itemQual);
			}//for

			System.out.println("File has been successfully inputed");
			input.close();
		}//try

		//Catch statements
		catch (FileNotFoundException ex)
		{
			System.out.println("File could not be found" + myFile.getAbsolutePath());
		}//catch 

		catch (InputMismatchException ex)
		{
			System.out.println("Type mismatch number unable to be read file");
			System.out.println(ex.getMessage());
		}//catch

		catch (NumberFormatException ex)
		{
			System.out.println("Error has occured unable to read file");
			System.out.println(ex.getMessage());
		}//catch

		catch (NullPointerException ex)
		{
			System.out.println("Null was returned. File could not be read");
			System.out.println(ex.getMessage());
		}//catch 

		catch(Exception ex)
		{
			System.out.println("Error has occured. File could not be read");
			ex.printStackTrace();
		}//catch
		
		while(menuChoChar != '0')
		{
			//menu
			System.out.println("Please choose a option from below");
			System.out.println("1. Add an Item to the list");
			System.out.println("2. Delete an Item to the list");
			System.out.println("3. Print each item from the list");
			System.out.println("4. Search for a user specfied item on the list");
			System.out.println("5. Count the total number of items in the list");
			System.out.println("6. Total the cost of the items in the list");
			System.out.println("7. Determine weather the list is empty");
			System.out.println("8. Determine weather the list is full");
			System.out.println("9. Clear the list");
			System.out.println("0 Quit");
			
			menuCho = keyboard.next();
			menuChoChar = menuCho.charAt(0);
			
			switch(menuChoChar)
			{

			//Adds items to the list.
			case('1'):

			if (shop.isFull() == false)
			{
				System.out.println("This program allows you to enter items into a cart");
				System.out.println("Please provide information about the item");
				System.out.println("enter a item on the cart");
				
				//item qualities
				item=keyboard.next();
				
				System.out.println("How many items would you like to input");

				do {
					amonItem = keyboard.nextInt();

					if(amonItem <= 0)
					{
						System.out.println("Quantity has to be positive");
					}//if

				}while(amonItem <= 0);//do while

				System.out.println("What price is the item");

				do {
					itemCos = keyboard.nextDouble();

					if(itemCos < 0)
					{
						System.out.println("Please enter a number that is not negative.");
					}//if

				}while(itemCos < 0);//do while
				
				//adding item
				ItemBhan itemQual = new ItemBhan();
				itemQual.setName(item);
				itemQual.setQuant(amonItem);
				itemQual.setPrice(itemCos);
				if (shop.add(itemQual)==true)
				{
					System.out.println("Item added");
					shop.add(itemQual);
				}//if
				
				else
					System.out.println("You have already inputed this item");

			}//if
			else
				System.out.println("You have inputed to many items. Cart cannot hold more"); 
			break;
			
			//remove item
			case('2'):
			if(!shop.isEmpty())
				{
				System.out.println("Enter the item you want to delete");
			remvStr = keyboard.next();
				if (shop.remove(remvStr))
					System.out.println("item was removed");

				else
					System.out.println("item was not in list, so could not be removed");
			}//if
			else
				System.out.println("list was empty no items to remove");
			break;
			
			//print list
			case('3'):
				
				if(shop.isEmpty())
					System.out.println("List was empty cannot print");
				
				else
					shop.print();
			break;
			
			//return item
			case('4'):
				System.out.println("Which item do you want to return");
			retItem = keyboard.next();

			if (shop.retrieve(retItem) == null)
				System.out.println("Sorry item is not in list");

			else
				System.out.println(shop.retrieve(retItem).toString());
			break;
			
			// amount of items in list
			case('5'):
				System.out.println("There are " + shop.getCount() + " in the list.");
			break;
			
			//list's price
			case('6'):
				System.out.print("The total price of all the items is ");
			System.out.println(moneyStyle.format(shop.calcTotal()));
			break;
			
			//Is list empty?
			case('7'):
				if(shop.isEmpty())
					System.out.println("List is empty");

				else
					System.out.println("List is not empty");
			break;
			
			//Is list full?
			case('8'):
				if (shop.isFull())
					System.out.println("List is full");

				else
					System.out.println("List is not full");
			break;
			
			//clears list
			case('9'):
				System.out.println("List is clear");
			shop.clear();
			break;
			
			//goodbye
			case('0'):
				System.out.println("Thank you for using the program");
			break;

			default:
				System.out.println("Please choose a option on the menu");
				break;
			}//switch

		}//while
	}//main

}//ShoppingDemoBhan
