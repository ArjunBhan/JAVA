/**
 * Name: Arjun Bhan
 * Due Data: 9/8/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 * Purpose: This program outputs the number that is contained in A but, not B.
 */
public class Problem2 {


	public static int missingnumber(int[] A, int[] B) {
		boolean InLisB= false;
		int NumbMis = 0;

		//These for loops go through all number in list A and list B in order to see which value of there don't match
		for(int i=0;i<A.length;i++)
		{
			InLisB= false;

			for(int j=0;j<B.length;j++)
			{
				if(A[i] == B[j])
				{
					InLisB= true;
				}
			}

			//If none of the values in B matched with the current A value then we found the missing value.
			if (InLisB==false)
			{
				NumbMis=A[i];
			}
		}

		return NumbMis;
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] testarray1 = {5, 7, 10, 9, 23, 1, 13, 100};

		int[] testarray2 = {100, 7, 5, 13, 1, 9, 10};

		System.out.println("The missing number in testarray2 is "+ missingnumber(testarray1, testarray2));
	}

}
