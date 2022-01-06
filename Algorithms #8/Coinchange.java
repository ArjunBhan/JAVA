/**
 * Name: Arjun Bhan
 * Due Date: 12/9/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Coinchange {

	public static int greedycoinchange(int givenvalue, int[] givencoins)
	{
		int Coins = 0;

		//Going through every coin type
		for(int i = 0; i < givencoins.length; i++)
		{
			//Updating the amount of coins and the value left
			Coins = givenvalue/givencoins[i]+Coins;
			givenvalue = givenvalue%givencoins[i];
		}
		return Coins;
		
		// Complete the code here to make change of givenvalue using coins in the array givencoins
		// Minimize the number of coins used
		// Input: Coin denominations in array givencoins are already sorted in descending order
		// Output: The number of coins used to make change of givenvalue		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 0; // n cents
		
		Scanner reader = new Scanner(System.in);  
		
		System.out.println("Please enter the value you want to make change: ");
		
		n = reader.nextInt();
		
		int[] coins = {10, 5, 1};
		// Add various denominations to test the program
		
		System.out.println("used "+ greedycoinchange(n, coins)+" coins for "+ n + " cents");
		
	}

}
