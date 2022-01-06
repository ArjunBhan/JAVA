/**
 * Name: Arjun Bhan
 * Due Data: 10/14/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 */
public class Problem1 {

	
	public static void intersection(int[] s1, int[] s2)
	{
		// complete the intersection() method to output
		// elements that occur in both s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place

		int i = 0;
		int j = 0;
		int pre = -1;
		while (i < s1.length && j < s2.length) {
			//Checking if values are equal or had been used previously.
			if (s1[i] == s2[j] && s1[i]!=pre)
			{
				pre=s1[i];
				System.out.println(s1[i++]);
				j++;
			}
			else if(s1[i] > s2[j])
			{
				j++;
			}
			else
			{
				i++;
			}
		}
		
	}
	
		public static void union(int[] s1, int[] s2)
	{
		// complete the union() method to output
		// the union s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place
		int i = 0;
		int j = 0;
		int Pre=-1;
		while (i < s1.length && j < s2.length) {
			//Outputting the smallest non repeating value
			if (s1[i] < s2[j])
			{
				if (Pre!=s1[i])
				{
					Pre = s1[i];
					System.out.println(s1[i]);
				}
				i++;
			}

			else
			{
				if (Pre!=s2[j]) {
					Pre = s2[j];
					System.out.println(s2[j]);
				}
				j++;
			}
		}
		//Printing out remaining values that weren't outputted previously
		while (i < s1.length) {
			if (Pre!=s1[i]) {
				Pre = s1[i];
				System.out.println(s1[i]);
			}
			i++;
		}

		while (j < s2.length) {
			if (Pre!= s2[j]) {
				Pre = s2[j];
				System.out.println(s2[j]);
			}
			j++;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test your intersection() method here
		//Test #1
		int[] testarray1 = {0, 0, 0, 1, 2, 3, 97, 98};
		int[] testarray2 = {0, 1, 2, 3, 4, 4, 10, 98, 100, 100};

		
		System.out.println("intersection of testarray1 and testarray2: ");
		intersection(testarray1,testarray2);
		//should output 0, 1, 2, 3, 98
		System.out.println("union of testarray1 and testarray2: ");
		union(testarray1,testarray2);
		//should output 0, 1, 2, 3, 4, 10, 97, 98, 100

		//Test #2
		int[] testarray3 = {1,2,3,4,5,6,7,7,8};
		int[] testarray4 = {7,8,9,13};


		System.out.println("intersection of testarray3 and testarray4: ");
		intersection(testarray3,testarray4);
		System.out.println("union of testarray3 and testarray4: ");
		union(testarray3,testarray4);

		//Test #3
		int[] testarray5 = {1,2,3};
		int[] testarray6 = {1,2,3};


		System.out.println("intersection of testarray5 and testarray6: ");
		intersection(testarray5,testarray6);
		System.out.println("union of testarray5 and testarray6: ");
		union(testarray5,testarray6);
	}

}
