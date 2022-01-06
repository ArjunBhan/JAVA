/**
 * Name: Arjun Bhan
 * Due Date: 11/5/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 */

import java.util.Random;
public class Problem2
{
	public static int[] partition_2pivots(int[] A, int start, int end)
	{
		//Randomly selecting two value from the list to place as the first and last points on the list
		Random rand=new Random();
		int firRandInd=rand.nextInt(end-start)+start;
		int SecRandInd=rand.nextInt(end-start)+start;

		int[] outputAr = new int[2];
		swap(A, start,SecRandInd);
		swap(A, end,firRandInd);

		//Making sure the first value of the list is always smaller than the last value.
		if(A[start]>A[end])
		{
			swap(A, start,end);
		}

		int BigPivot = A[end];
		int SmallPivot=A[start];

		int i=end-1;
		int j = start+1;
		int k=start+1;
		while(k<=i)
		{
			//Handles values after the pivot
			if(A[k] > BigPivot)
			{
				swap(A,k,i);
				i--;
			}

			//Handles the values less than or equal to the pivot
			else
			{
				if (A[k] < SmallPivot)
				{
					swap(A,k,j);
					j++;
				}
				k++;
			}
		}
		i++;
		j--;

		//Swaps the pivots to the correct area.
		swap(A,j,start);
		swap(A,i,end);

		outputAr[0]=j;
		outputAr[1]=i;
		return outputAr;

	}

	public static void quicksort_2pivots(int[] A, int start, int end)
	{
		if ( start < end )
		{
			int[] p = partition_2pivots(A, start, end);

			//recursively calling on the three segments created by the partition_2pivots method
			quicksort_2pivots(A, start, p[0]-1);
			quicksort_2pivots(A,p[0]+1,p[1]-1);
			quicksort_2pivots(A, p[1]+1, end);
			
		}
	}

	//Changes the indexes of the inputed values.
	public static void swap(int[] A, int i, int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		
	}



	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		// Test 
		
		int[] testarray1 = {2, 4, 1, 6, 3, 7, 8};
		
		int[] testarray2 = {6, 3, 4, 5, 1};

		int[] testarray3 = {9,7,2,4,5};

		int[] testarray4 = {4, 5, 1, 2, 33};

		quicksort_2pivots(testarray1, 0, testarray1.length-1);
		quicksort_2pivots(testarray2, 0, testarray2.length-1);
		quicksort_2pivots(testarray3, 0, testarray3.length-1);
		quicksort_2pivots(testarray4, 0, testarray4.length-1);
		
		//Output sorted arrays
		for(int i = 0; i < testarray1.length; i++)
		{
			System.out.print(testarray1[i] + " ");
		}
		
		System.out.println();
		
		for(int i = 0; i < testarray2.length; i++)
		{
			System.out.print(testarray2[i] + " ");
		}

		System.out.println();

		for(int i = 0; i < testarray3.length; i++)
		{
			System.out.print(testarray3[i] + " ");
		}

		System.out.println();

		for(int i = 0; i < testarray4.length; i++)
		{
			System.out.print(testarray4[i] + " ");
		}
		
	}//main
}//Problem2
