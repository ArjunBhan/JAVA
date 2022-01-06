/** 
* This code is designed to tell the user how much money an inputed value
* can be broken into dollar bills and coins of different denominations.
* The code will also tell the user the total amount of dollar bills and coins 
* used to get the inputed value.
*/

import java.util.Scanner; 
public class ChangeMakerBhan 
{
	public static void main(String args[])
	{
	
		//Instructions
		System.out.println("Enter a whole number");
		System.out.println("I will output a combination of bills and coins");
		System.out.println("that equals that amount of change");
		
		Scanner keyboard = new Scanner(System.in);
		
		/** 
		 * This code takes the user inputed value and converts the value 
		 * into pennies. The code uses division to convert the pennies into 
		 * different monetary amounts.    
		 */	
		int amount = keyboard.nextInt();
		
		//Dollar amounts
		int orignalAmount = amount;
		int twenty_dollars = amount/2000;
		amount = amount%2000;
		int ten_dollars = amount/1000;
		amount = amount%1000;
		int five_dollars = amount/500;
		amount = amount%500;
		int one_dollars = amount/100;
		amount = amount%100;
		
		//Coin amounts
		int quaters = amount/25;
		amount = amount%25;
		int dimes = amount/10;
		amount = amount%10;
		int nickels = amount/5;
		amount = amount%5;
		int pennies = amount;
		
		//Amount of dollar and coins used
		int tot_dollars = twenty_dollars+ten_dollars+five_dollars+one_dollars;
		int tot_coins = quaters+dimes+nickels+pennies;
		
		System.out.println(orignalAmount + " cents can be given as: ");
		
		//Prints dollars
		System.out.println(twenty_dollars + " twenty dollar bills");
		System.out.println(ten_dollars + " ten dollar bills");
		System.out.println(five_dollars + " five dollar bills");
		System.out.println(one_dollars + " one dollar bills");
		
		//Prints coins
		System.out.println(quaters + " quaters");
		System.out.println(dimes + " dimes");
		System.out.println(nickels + " nickels and");
		System.out.println(pennies + " pennies");
		
		//Prints the amount of dollar and coins used.
		System.out.println("The value entered has the total of " + tot_dollars+" "
						   + "dollar bills and "+ tot_coins + " coins.");	
	}//main
}//ChangeMakerBhan
