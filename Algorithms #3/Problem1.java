/**
 * Name: Arjun Bhan
 * Due Data: 10/7/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 * Purpose: This program shows the maximum and second maximum value of an array.
 */
public class Problem1
{

public static Max2ndMax dcfindmax2ndmax(int[] A, int i, int j)
	{
        int Mid=(i+j)/2;
		Max2ndMax LeftSid=new Max2ndMax();
		Max2ndMax RightSid=new Max2ndMax();
		Max2ndMax MinMax=new Max2ndMax();
        if (j==i)
        {
            MinMax.max2nd = A[i];
            MinMax.max = A[j];
        }
        //If there are two elements in the list categories the values correctly within MinMax.
        else if(j-i==1)
        {
            if(A[i]<A[j])
            {
                MinMax.max2nd = A[i];
                MinMax.max = A[j];
            }
            else
            {
                MinMax.max2nd=A[j];
                MinMax.max = A[i];
            }
        }
        else{
            //Recursivly calling on the function so that the code can break down the list into small components.
			LeftSid=dcfindmax2ndmax(A, i, Mid);
			RightSid=dcfindmax2ndmax (A, Mid+1, j);

            //Making sure that the greatest value is listed as the max values and that the second max value is the MinMax.max2nd
            if (LeftSid.max > RightSid.max)
            {
                MinMax.max = LeftSid.max;
                if (LeftSid.max2nd > RightSid.max && LeftSid.max2nd!=LeftSid.max)
                {
                    MinMax.max2nd = LeftSid.max2nd;
                }
                else
                {
                    MinMax.max2nd = RightSid.max;
                }
            }
            else
            {
                MinMax.max = RightSid.max;
                if (LeftSid.max > RightSid.max2nd && RightSid.max2nd!=RightSid.max)
                {
                    MinMax.max2nd = LeftSid.max;
                }
                else
                {
                    MinMax.max2nd = RightSid.max2nd;
                }
            }

        }
        return(MinMax);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method

        int[] givenarray1 = {100,2,3,4,5,6,7,67,2,32};
        Max2ndMax pair = new Max2ndMax();
        pair = dcfindmax2ndmax(givenarray1, 0, givenarray1.length-1);
        int max2nd = pair.max2nd;
        int max = pair.max;
        System.out.println("The max and 2ndmax of the given array are "+ max + " and "+max2nd+".");

		int[] givenarray2 = {0,0,104,3,4,5,6,72,67,32};
		pair = dcfindmax2ndmax(givenarray2, 0, givenarray2.length-1);
		max2nd = pair.max2nd;
		max = pair.max;
		System.out.println("The max and 2ndmax of the given array are "+ max + " and "+max2nd+".");


        int[] givenarray3 = {1000,2,5,1,4,91,93,73};
        pair = dcfindmax2ndmax(givenarray3, 0, givenarray3.length-1);
        max2nd = pair.max2nd;
        max = pair.max;
        System.out.println("The max and 2ndmax of the given array are "+ max + " and "+max2nd+".");

        int[] givenarray4 = {1,2,3,4,5};
        pair = dcfindmax2ndmax(givenarray4, 0, givenarray4.length-1);
        max2nd = pair.max2nd;
        max = pair.max;
        System.out.println("The max and 2ndmax of the given array are "+ max + " and "+max2nd+".");

        int[] givenarray5 = {100,10,1};
        pair = dcfindmax2ndmax(givenarray5, 0, givenarray5.length-1);
        max2nd = pair.max2nd;
        max = pair.max;
        System.out.println("The max and 2ndmax of the given array are "+ max + " and "+max2nd+".");
		
	}
	
	
}
