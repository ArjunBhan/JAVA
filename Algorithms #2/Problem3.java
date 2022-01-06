/**
 * Name: Arjun Bhan
 * Due Data: 9/23/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 * Purpose: This program shows the square root of a specfic item is in the list.
 */
public class Problem3 {

	public static int squareroot(int x)
	{
        int Start=0;
        int End=x;
        int CurVal=0;
        int SquRoot=0;

        while(Start<=End)
        {
            //Finding the middle value based on the values we know it is between
            CurVal=(Start+(End-Start)/2);
            //Checking if the CurVal is a square root of x
            if((CurVal*CurVal)==x)
            {
                SquRoot=CurVal;
                break;
            }
            else {
                //Updating the start and end point of our search of the list
                if((CurVal*CurVal)<x)
                {
                    Start=SquRoot+1;;
                    SquRoot=CurVal;
                }

                else
                {
                    End=CurVal-1;
                }
            }
        }
        return SquRoot;
		
		
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test your count() method here
		
		int x1 = 14;
		int x2 = 8;
		int x3 = 122;
        int x4 = 10000;
        int x5 = 9;
        int x6 = 4;
		System.out.println("The square root of " + x1 + " is " + squareroot(x1));
		System.out.println("The square root of " + x2 + " is " + squareroot(x2));
		System.out.println("The square root of " + x3 + " is " + squareroot(x3));
        System.out.println("The square root of " + x4 + " is " + squareroot(x4));
        System.out.println("The square root of " + x5 + " is " + squareroot(x5));
        System.out.println("The square root of " + x6 + " is " + squareroot(x6));
		
	}

}
