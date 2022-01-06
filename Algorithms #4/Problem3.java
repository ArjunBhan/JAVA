/**
 * Name: Arjun Bhan
 * Due Data: 10/14/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 */

public class Problem3 {

	// Create a mergeklists() to merge 3 sorted arrays into one sorted array
	// Input: 3 sorted arrays a1[], a2[], a3[]
	// Output: one sorted array a[] that contains all the elements from input arrays
	// Complete the code here.
	// O(n) solution expected. Programs slower than O(n) will be graded out of 10 points.
	public static int[] Merge(int[] a, int[] b)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		int[] ab=new int[a.length+b.length];
		while (i < a.length && j < b.length) {
			if (a[i] <= b[j])
			{
				ab[k++] = a[i++];
			}
			else
			{
				ab[k++] = b[j++];
			}
		}
		//Copy leftovers into AB
		while (i < a.length) {
			ab[k++] = a[i++];
		}

		while (j < b.length) {
			ab[k++] = b[j++];
		}
		return ab;
	}

	public static void merge3lists(int[] a, int[] b, int[] c, int[] d)
	{
		int[] ab=new int[a.length+b.length];
		ab=Merge(a,b);
		d=Merge(ab,c);
		for(int i=0;i<d.length;i++)
		{
			System.out.println(d[i]);
		}

	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Test 1
		int[] l1 = {1,5,9,10,20};
		
		int[] l2 = {2,4,5,6,7,9,15};
		
		int[] l3 = {3,8,13,15,22};

		System.out.println("Test #1");

		int[] newl = new int[l1.length+l2.length+l3.length];
		
		merge3lists(l1,l2,l3,newl);

		//Test 2
		int[] l4 = {1,11,21,31};

		int[] l5 = {2,12,22,32};

		int[] l6 = {3,8,13,15,23};

		int[] newl2 = new int[l4.length+l5.length+l6.length];
		System.out.println("Test #2");
		merge3lists(l4,l5,l6,newl2);

		//Test 3
		int[] l7 = {6,8,10};

		int[] l8 = {3,4,5,11,23};

		int[] l9 = {1,2,35,40};

		int[] newl3 = new int[l7.length+l8.length+l9.length];
		System.out.println("Test #3");
		merge3lists(l7,l8,l9,newl3);
		
	}

}
