import java.io.*;
import java.util.*;
/**
 * @author Name: Arjun Bhan CMPT 220 - Program 11
 * Due: Monday, May 6, before 1:30 p.m
 * CMPT 220 - Program 11
 * Purpose: The purpose of this code is to make a simulation of the battle card game.
 * Inputs: File name
 * Outputs: The amount of card the game started with. The total amount of card(s). 
 * The number of rounds. Amount of cards used.
 * Certification of Authenticity: I certify that this assignment is my own work, but
 * I discussed it with: Professor Schwartz and computer lab tutors.
 */
public class BattleDemoBhan {

	static StackBhan playOneDis = new StackBhan();
	static StackBhan playOneDec = new StackBhan();
	static StackBhan playTwoDis = new StackBhan();
	static StackBhan playTwoDec = new StackBhan();
	static Scanner keyboard = new Scanner(System.in);	

	public static void main(String args[])
	{
		String fileRead = "";
		int cardsPlay = 0, amounPlay = 0;
		System.out.println("Put in a text file");
		fileRead =  keyboard.next();
		cardsPlay = deal(fileRead);

		if(cardsPlay == 0)
		{
			System.out.println("There are no card in this file");
		}//if
		else if(cardsPlay > 52)
		{
			System.out.println("There are too many cards in the file");
		}//else if
		else
		{
			while(amounPlay < 1000 &&  ((!playOneDec.isEmpty() || !playOneDis.isEmpty())) && ((!playTwoDis.isEmpty() || !playTwoDec.isEmpty())))
			{
				if(playOneDec.isEmpty())
				{
					copy(playOneDec,playOneDis);
				}//if
				//System.out.println(countCards(playOneDis) + countCards(playOneDec));
				if( playTwoDec.isEmpty() )
				{
					copy(playTwoDec,playTwoDis);	
				}//if
				play();
				amounPlay++;
				System.out.println(countCards(playTwoDis) + countCards(playTwoDec));
			}//while
		
		System.out.print( printResults(cardsPlay, amounPlay));
		}//else
		
		
	}//main

	public static int deal(String fileName)
	{
		char cardSuit='?';
		int cardNum = 0, rounds = 0;

		File fileRead = new File(fileName);
		
		try {
			Scanner input = new Scanner(fileRead);
			
			while(input.hasNext())
			{
				CardBhan cardQual = new CardBhan();
				cardNum = input.nextInt();
				cardSuit = input.next().charAt(0);
				cardQual.setSuit(cardSuit);
				cardQual.setValue(cardNum);
				
				if(rounds % 2 == 0) {
					playOneDec.push(cardQual);
				}//if
				
				else 
				{
					playTwoDec.push(cardQual);
				}//else
				
				rounds++;
			
			}//while
			
			input.close();
			
		}//try
		
		//Catch statements
		catch (FileNotFoundException ex)
		{
			System.out.println("File could not be found" + fileRead.getAbsolutePath());
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

		return rounds;
	}//deal

	public static boolean play()
	{
		boolean cardPlayed = false;
		int whoWon = 0;
		CardBhan firCard = null ,secCard = null;
		
		firCard = playOneDec.pop();
		secCard = playTwoDec.pop();
		whoWon = compare(firCard, secCard);
		if(whoWon != 0)
		{
			winPlay(whoWon, firCard, secCard );
			cardPlayed = true;
		}
		return cardPlayed; 
	}//play

	public static int compare(CardBhan playOneCard, CardBhan playTwoCard)
	{
		int winner = 0;
		if(playOneCard.getValue() != playTwoCard.getValue())
		{
			if(playOneCard.getValue() > playTwoCard.getValue())
			{
				winner = 1;
			}//if 
	
			else if (playOneCard.getValue() < playTwoCard.getValue())
			{
				winner = 2;
			}//else if 
		}//if
		
		else
		{
			if (playOneCard.getSuit() > playTwoCard.getSuit())
			{
				winner = 1;
			}//if

			else if (playOneCard.getSuit() < playTwoCard.getSuit())
			{
				winner = 2;
			}//else if
			else 
				playOneDis.push(playOneCard);
				playTwoDis.push(playTwoCard);

		}//else
		return winner;

	}//compare
	
	public static void winPlay(int playerWon, CardBhan playOneCar, CardBhan playTwoCar)
	{

		if (playerWon == 1)
		{
			playOneDis.push(playOneCar);
			playOneDis.push(playTwoCar);	
		}//if

		else if(playerWon == 2)
		{
			playTwoDis.push(playTwoCar);
			playTwoDis.push(playOneCar);	
		}//else

		else
		{
			playOneDis.push(playOneCar);
			playTwoDis.push(playTwoCar);	
		}//else

	}//winPlay

	public static void copy(StackBhan playDeck, StackBhan discard)
	{
		StackBhan temp = new StackBhan();
		while(!discard.isEmpty())
		{
			temp.push(discard.pop());
			
		}//while
		while(!temp.isEmpty())
		{
			playDeck.push(temp.pop());
		}
	}//copy

	public static int countCards(StackBhan selecDeck)
	{
		int counter = 0;
		StackBhan temp = new StackBhan();
		while (!selecDeck.isEmpty())
		{
			temp.push(selecDeck.pop());
			counter++;
		}//while
		
		while(!temp.isEmpty())
		{
			selecDeck.push(temp.pop());
		}//while
		
		return counter;
	}

	public static String printResults(int totCards, int numRounds)
	{
		String summary = "";

		summary += ("The game started with " + totCards + " card(s)." + "\n");
		summary += ("The number of rounds  " + numRounds + ".\n");
		summary += ("Player one has  "  +  (countCards(playOneDec)+ countCards(playOneDis)) + " card(s)." + "\n");
		summary += ("Player two has  "  +  (countCards(playTwoDec) + countCards(playTwoDis)) +" card(s)." + "\n");
		
		if (numRounds >= 1000)
		{
			summary += ("Game takes too long" + ".\n");
			summary += ("No one won.");
		}//if
		
		else  if(playTwoDec.isEmpty())
		{	
			summary += ("The game has a clear winner" + ".\n");
			summary += ("Player 1 won.");
		}//else if 
		
		else
		{
			summary += ("The game has a clear winner" + ".\n");
			summary += ("Player 2 won.");
		}//else
		
		return summary;	
	}//printResults
	
}//BattleDemoBhan

