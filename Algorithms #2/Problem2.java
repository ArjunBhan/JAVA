/**
 * Name: Arjun Bhan
 * Due Data: 9/23/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 * Purpose: This program show whether a majority item exist in the list.
 */
public class Problem2 {


	public static Boolean majority(int[] A) {
		int Middle = A.length / 2;
		int End = A.length - 1;
		int Start = 0;
		int Center = A[A.length / 2];
		int StartInd = 0;
		int EndInd = 0;

		//Checking first half of the list
		while (Start <= Middle)
		{
			//The CurVal variable is constantly updated to find the first value in a list
			int CurVal = (Start + (Middle - Start) / 2);

			if (A[CurVal] == Center)
			{

				/*
				Checking if the previous element of the list is equal to the CurVal value and
				making sure the list would be indexed in by a negative value
				 */

				if (CurVal - 1 != -1 && A[CurVal - 1] == Center)
				{
					Middle = CurVal - 1;
				}

				//Indicates location of first time the middle item is found
				else {
					StartInd = CurVal;
					break;
				}
			}
			/*
			Used to move up the start point of the CurVal. This should only be
			used if their are different values before the middle value
			 */
			else {
				Start = CurVal + 1;
			}
		}
		//Checking second half of the list
		while (Middle <= End) {
			//Simular to the first half search code. This time we are incrmenting down the list.
			int CurVal = Middle + (End - Middle) / 2;
			if (A[CurVal] == Center)
			{
				/*
				Checking if the next element of the list is equal to the CurVal value and
				making sure the list would be indexed in by a negative value
				 */
				if (CurVal + 1 != A.length && A[CurVal + 1] == Center)
				{
					Middle = CurVal + 1;
				}

				else {
					EndInd = CurVal;
					break;
				}
			}
			else
			{
				//Decreasing search when a value is not located above a certain point
				End = CurVal - 1;
			}

		}
		//Returning whether the amount of space that the middle value takes up is greater than half the list
		return ((EndInd - StartInd)+1 > A.length/2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Test your majority method

		int[] testarray1 = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 4, 7};

		int[] testarray2 = {0, 0, 0,0, 0, 1, 2, 3, 10, 10};

		int[] testarray3 = {-1,2,3,4,5,5,5,5,10,10,10,10};
		int[] testarray4 = {5,5,5,10,10,10,10};
		int[] testarray5 = {1,2,3,4,5};
		System.out.println("Does there exist a majoirty element in testarray1? " + majority(testarray1));
		System.out.println("Does there exist a majoirty element in testarray2? " + majority(testarray2));
		System.out.println("Does there exist a majoirty element in testarray3? " + majority(testarray3));
		System.out.println("Does there exist a majoirty element in testarray4? " + majority(testarray4));
		System.out.println("Does there exist a majoirty element in testarray5? " + majority(testarray5));
	}
}


