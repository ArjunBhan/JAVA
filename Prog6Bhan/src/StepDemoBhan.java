/**
 * Name: Arjun Bhan CMPT 220 - Program 6
 * Due: Wednesday, March 6th, before 1:30 p.m
 * CMPT 220 - Program 6
 * Purpose: The purpose of this program is to refine your knowledge about
 * classes and methods. 
 * Inputs: Menu option, width, number of steps and style.
 * Outputs: Area, text description, draw steps, draw thick steps and a goodbye text
 * when the user quits.
 * Certification of Authenticity: I certify that this assignment is my own work, but
 * I discussed it with: Professor Schwartz and computer lab tutors.
 */
import java.util.Scanner;
public class StepDemoBhan {
	public static void main(String args[]) {
		//Variable initializers
		Scanner keyboard = new Scanner(System.in);
		StepsBhan stepMaker = new StepsBhan();
		char menuOpChar = '?';
		String menuOptionCap="?", menuOption = "?", stepsSummary = "?", style="?";
		int steps = 0, width = 0;
		
		while(menuOpChar != 'Q')
		{
			//print statements 
			System.out.println("Please enter your option");
			System.out.println("W : Assign the Step Width");
			System.out.println("N : Assign the Number of Steps");
			System.out.println("F : Assign the Fill Style");
			System.out.println("A : Calculate Area");
			System.out.println("T : Text Description of the Steps");
			System.out.println("D : Draw the steps");
			System.out.println("X : Draw thick Steps");
			System.out.println("Q : Quit");
			
			//user menu
			menuOption = keyboard.next();
			menuOptionCap = menuOption.toUpperCase();
			menuOpChar = menuOptionCap.charAt(0);
			switch (menuOpChar)
			{
			
				case 'W': 
				{
					do
					{
						System.out.println("Please enter a new width(negative "
											+ "numbers are not allowed) ");
						width = keyboard.nextInt();
					}while(width < 0);//Do while
				
					stepMaker.setWidth(width);
					break;
				}//case W
			
				case 'F':
				{
					System.out.println("Please enter a fill style ");
					style=keyboard.next();
				
					stepMaker.setFillStyle(style.charAt(0));
					break;
				}//case F
			
				case 'N': 
				{
					do 
					{
						System.out.println("Assign the Number of Steps(negative "
											+ "number are not allowed) ");
						steps = keyboard.nextInt();
					}while(steps < 0);//Do while
				
					stepMaker.setSteps(steps);
					break;
				}//case N
			
				case 'A':
				{
					int area = stepMaker.calcArea();
					System.out.println("The area is "+ area);
					break;
				}//case A
			
				case 'T':
				{
					stepsSummary = stepMaker.toString();
					System.out.println(stepsSummary);
					break;
				}//case T
			
				case'D': 
				{
					stepMaker.drawSteps();
					break;
				}//case D
			
				case 'X': 
				{
					stepMaker.drawThickness();
					break;
				}//Case X
			
				case 'Q': 
				{
					System.out.println("Thank you for using the program");
					break;
				}//Case Q
			
				default: 
				{
					System.out.println(menuOption +" is not an option on the menu");
					break;
				}//default
			}//Switch
			
		}//While
		
	}//Main
}//StepDemoBhan
