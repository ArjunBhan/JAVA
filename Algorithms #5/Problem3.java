/**
 * Name: Arjun Bhan
 * Due Date: 11/5/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 */

import java.util.Arrays;

public class Problem3 {

	public static void threeway(int[] A)
	{
        int end = A.length-1;
        int pivot = A[0];

        int LowCount=0;
        int HighCount=A.length-1;

            //If value is less than pivot place it before the pivot's index.
            for(int i=0; i<=end;i++)
            {
                if(A[i]<pivot)
                {
                    swap(A,i,LowCount);
                    LowCount++;
                }
            }

            //If value is greater than pivot place it after the pivot's index.
            for(int j=end; j>=0;j--)
            {
                if (A[j] > pivot) {
                    swap(A, j, HighCount);
                    HighCount--;
                }
            }
        }

    //Changes the indexes of the inputed values.
    public static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method
		int[] testarray={1, 2, 2, 2, 6, 1, 7, 0, -5, 2, 8, 1, 3, 1, 1};
		// Test your method
		threeway(testarray);
		System.out.println(Arrays.toString(testarray));
		// Your method should output {0, -5, 1, 1, 1, 1, 1, 2, 6, 7, 2, 2, 2, 8, 3}
		// with all elements = pivot next to pivot elements<pivot on the left, >pivot on the right

        int[] testarray2={8,3,4,8,12,21,34,33,8,3,4,1};
        // Test your method
        threeway(testarray2);
        System.out.println(Arrays.toString(testarray2));

        int[] testarray3={64,46,34,12,46,74,23,64};
        // Test your method
        threeway(testarray3);
        System.out.println(Arrays.toString(testarray3));
		
	}
}

