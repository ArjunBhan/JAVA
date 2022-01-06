/**
 * Name: Arjun Bhan
 * Due Data: 10/7/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 * Purpose: This program shows the maximum difference between the largest value in a list and the smallest value that precedes it.
 */
public class Problem2 {

	public static MaxMin findmaxdiff(double[] A, int i, int j)
	{
		int Mid=(i+j)/2;
		MaxMin LeftSid=new MaxMin();
		MaxMin RightSid= new MaxMin();
		MaxMin MinMax=new MaxMin();

		//If there is only one element in the list the difference will be zero
		if (j==i)
		{
			MinMax.min = A[i];
			MinMax.max = A[j];
			MinMax.diff=A[j]- A[i];
			return (MinMax);
		}

		//If there are two elements in the list check to see which element is greater and smaller
		else if(j-i==1)
		{
			if(A[i]<A[j])
			{
				MinMax.min = A[i];
				MinMax.max = A[j];
				MinMax.diff=A[j]- A[i];
				return (MinMax);
			}

			//Makes sure that values where the lower index is bigger have negative difference.
			else
			{
				MinMax.min=A[j];
				MinMax.max = A[i];
				MinMax.diff=A[j]- A[i];
				return (MinMax);
			}
		}

		LeftSid = findmaxdiff(A, i, Mid);
		RightSid = findmaxdiff(A, Mid + 1, j);
		MinMax.diff=RightSid.max-LeftSid.min;

		//Finding the greatest difference amongst the numbers.
		if(MinMax.diff<LeftSid.diff)
		{
			if(RightSid.diff<LeftSid.diff)
			{
				MinMax.diff=LeftSid.diff;
			}

			else
			{
				MinMax.diff=RightSid.diff;
			}
		}

		else if(MinMax.diff<RightSid.diff)
		{
			MinMax.diff=RightSid.diff;
		}

		//Finding the greatest max value
		if(LeftSid.max>RightSid.max)
		{
			MinMax.max=LeftSid.max;
		}

		else
		{
			MinMax.max=RightSid.max;
		}

		//Finding smallest min value.
		if(LeftSid.min>RightSid.min)
		{
			MinMax.min=RightSid.min;
		}

		else
		{
			MinMax.min=LeftSid.min;
		}

		return MinMax;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxMin r;
		// Test your findmaxdiff() method here
		double[] testarray1 = {2, 3, 10, 6, 4, 8, 1};
		r=findmaxdiff(testarray1, 0, testarray1.length-1);
		System.out.println(Math.round(r.diff));

		double[] testarray2 = {6,7, 9, 1, 4, 3, 2};
		r=findmaxdiff(testarray2, 0, testarray2.length-1);
		System.out.println(Math.round(r.diff));

		double[] testarray3 = {1,2,3,4,5,6,7,8};
		r=findmaxdiff(testarray3, 0, testarray3.length-1);
		System.out.println(Math.round(r.diff));

		double[] testarray4 = {7,12,13,15,1,4,6};
		r=findmaxdiff(testarray4, 0, testarray4.length-1);
		System.out.println(Math.round(r.diff));

		double[] testarray5 = {4,5,7,3,1};
		r=findmaxdiff(testarray5, 0, testarray5.length-1);
		System.out.println(Math.round(r.diff));

	}
}
