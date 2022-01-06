/**
 *Name:StepsBhan
 *Purpose: This code is designed to help the main method function. It 
 * does this by taking input from the main and using it to either 
 * draw steps, set attributes of the steps or give a description 
 * of the steps. 
 *Parameters: The width, the number of steps and the fill style.
 *Returns: Area, summary of steps, width, number of step and fill style
 * of the steps.
 */
public class StepsBhan {
	private int myStepWidth;
	private int myNumSteps;
	private char myFillStyle;

	public StepsBhan(int newStepWidth, int newNumSteps, char newFillStyle) 
	{
		myStepWidth = newStepWidth;
		myNumSteps = newNumSteps;
		myFillStyle = newFillStyle;
	}// Full constructor

	public StepsBhan()
	{
		myStepWidth = 2;
		myNumSteps = 5;
		myFillStyle = '*';
	}//Empty constructor

	public void setWidth(int newWidth)
	{
		myStepWidth = newWidth;
	}//setWidth
	
	public void setSteps(int newNumSteps)
	{
		myNumSteps = newNumSteps;
	}//setSteps

	public void setFillStyle(char newFillStyle)
	{
		myFillStyle = newFillStyle;
	}//setFillStyle

	public int getWidth() 
	{
		return myStepWidth;
	}// getWidth

	public int getSteps() 
	{
		return myNumSteps;
	}// getSteps

	public int getFillStyle() 
	{
		return myFillStyle;
	}// getFillStyle

	public int calcArea()
	{
		int area = 0;
		for (int areaLoop = 1; areaLoop <= myNumSteps; areaLoop++)
		{
			area += myStepWidth * areaLoop;
		}//for
		
		return area;
	}//calcArea

	public void drawSteps() 
	{
		for (int stepLoop = 1; stepLoop <= myNumSteps; stepLoop++)
		{
			for (int  widthLoop = 0; widthLoop < myStepWidth * stepLoop; widthLoop++)
			{
				System.out.print(myFillStyle);
			}//For
			System.out.println();
		}//For
	}//drawSteps
	
	public void drawThickness() 
	{
		for (int stepCount = 1; stepCount <= myNumSteps; stepCount++)
		{
			for (int firWidCount = 0; firWidCount < myStepWidth; firWidCount++)
			{
				for (int secWidCount = 0; secWidCount < myStepWidth * stepCount; secWidCount++)
				{
						
					System.out.print(myFillStyle);
				}//For	
				System.out.println();
			}//For
		}//For
	}//drawThickness
	public String toString() 
	{
		String results = "";
		results += ("Width is "+ myStepWidth+"\n");
		results += ("Number of steps is "+  myNumSteps+"\n");
		results += ("Style is "+  myFillStyle+"\n");
		int area = calcArea();
		results += ("Area is "+ area +"\n");
		return results;
	}//toString
}//StepsBhan

